package fr.positif.utils;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;

/**
 *
 * @author DASI Team
 */
/* DÉPENDANCES Maven:
<dependency>
    <groupId>com.google.maps</groupId>
    <artifactId>google-maps-services</artifactId>
    <version>0.2.11</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-nop</artifactId>
    <version>1.7.26</version>
</dependency>
*/
public class GeoTest {

    final static String MA_CLE_GOOGLE_API = "AIzaSyAhf3JleYpal9S-xouJYH8lf7Dvz5Y2Nko";

    final static GeoApiContext MON_CONTEXTE_GEOAPI = new GeoApiContext.Builder().apiKey(MA_CLE_GOOGLE_API).build();

    public static LatLng getLatLng(String adresse) {
        try {
            GeocodingResult[] results = GeocodingApi.geocode(MON_CONTEXTE_GEOAPI, adresse).await();

            return results[0].geometry.location;

        } catch (Exception ex) {
            return null;
        }
    }

    public static double toRad(double angleInDegree) {
        return angleInDegree * Math.PI / 180.0;
    }

    public static double getFlightDistanceInKm(LatLng origin, LatLng destination) {

        // From: http://www.movable-type.co.uk/scripts/latlong.html
        double R = 6371.0; // Average radius of Earth (km)
        double dLat = toRad(destination.lat - origin.lat);
        double dLon = toRad(destination.lng - origin.lng);
        double lat1 = toRad(origin.lat);
        double lat2 = toRad(destination.lat);

        double a = Math.sin(dLat / 2.0) * Math.sin(dLat / 2.0)
                + Math.sin(dLon / 2.0) * Math.sin(dLon / 2.0) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));
        double d = R * c;

        return Math.round(d * 1000.0) / 1000.0;
    }

    public static Double getTripDurationByBicycleInMinute(LatLng origin, LatLng destination, LatLng... steps) {
        return getTripDurationOrDistance(TravelMode.BICYCLING, true, origin, destination, steps);
    }

    public static Double getTripDistanceByCarInKm(LatLng origin, LatLng destination, LatLng... steps) {
        return getTripDurationOrDistance(TravelMode.DRIVING, false, origin, destination, steps);
    }

    public static Double getTripDurationOrDistance(TravelMode mode, boolean duration, LatLng origin, LatLng destination, LatLng... steps) {

        DirectionsApiRequest request = DirectionsApi.getDirections(MON_CONTEXTE_GEOAPI, origin.toString(), destination.toString());
        request.mode(mode);
        request.region("fr");

        if (steps.length > 0) {

            String[] stringSteps = new String[steps.length];
            for (int i = 0; i < steps.length; i++) {
                stringSteps[i] = steps[i].toString();
            }

            request.waypoints(stringSteps);
        }

        double cumulDistance = 0.0;
        double cumulDuration = 0.0;

        try {
            DirectionsResult result = request.await();
            DirectionsRoute[] directions = result.routes;

            for (int legIndex = 0; legIndex < directions[0].legs.length; legIndex++) {

                cumulDistance += directions[0].legs[legIndex].distance.inMeters / 1000.0;
                cumulDuration += Math.ceil(directions[0].legs[legIndex].duration.inSeconds / 60.0);
            }

        } catch (Exception ex) {
            return null;
        }

        if (duration) {
            return cumulDuration;
        } else {
            return cumulDistance;
        }
    }

    public static void main(String[] args) {

        if (MA_CLE_GOOGLE_API.equals("XXXXXXXX-Moodle-Clé")) {
            for (int i=0; i<100; i++) {
                System.err.println("[ERREUR] VOUS AVEZ OUBLIÉ DE CHANGER LA CLÉ DE L'API !!!!!");
            }
            System.exit(-1);
        }

        String adresse1 = "7 Avenue Jean Capelle Ouest, Villeurbanne";
        LatLng coords1 = getLatLng(adresse1);
        System.out.println("Lat/Lng de Adresse #1: " + coords1);

        String adresse2 = "37 Avenue Jean Capelle Est, Villeurbanne";
        LatLng coords2 = getLatLng(adresse2);
        System.out.println("Lat/Lng de Adresse #2: " + coords2);

        String adresse3 = "61 Avenue Roger Salengro, Villeurbanne";
        LatLng coords3 = getLatLng(adresse3);
        System.out.println("Lat/Lng de Adresse #3: " + coords3);
        
        // Coordonnées directes: Rond-Point du Totem, Cours Tolstoï, Villeurbanne
        LatLng coords4 = new LatLng(45.763781,4.8735128);
        System.out.println("Lat/Lng de Coords #4: ( " + coords4.lat + "; " + coords4.lng + " )");


        Double duree = getTripDurationByBicycleInMinute(coords1, coords3);
        System.out.println("Durée de Trajet à Vélo de Adresse #1 à Adresse #3 (trajet direct): " + duree + " min");

        Double distance = getTripDistanceByCarInKm(coords1, coords3, coords2);
        System.out.println("Distance en Voiture de Adresse #1 à Adresse #3 en passant par Adresse #2 (distance par la route): " + distance + " km");

        Double distanceVolDOiseau = getFlightDistanceInKm(coords1, coords3);
        System.out.println("Distance à Vol d'Oiseau de Adresse #1 à Adresse #3 (distance géographique): " + distanceVolDOiseau + " km");
        
        Double autreDistanceVolDOiseau = getFlightDistanceInKm(coords1, coords4);
        System.out.println("Distance à Vol d'Oiseau de Adresse #1 à Coords #4 (distance géographique): " + autreDistanceVolDOiseau + " km");
    }
}
