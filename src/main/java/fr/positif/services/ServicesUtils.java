package fr.positif.services;

import com.google.maps.model.LatLng;
import fr.positif.entities.Address;
import fr.positif.entities.Client;
import fr.positif.utils.Astro;
import fr.positif.utils.GeoTest;

import java.io.IOException;
import java.util.List;

class ServicesUtils {

    static void validateAndGenerateGpsAddress(Address address) throws Exception {
        
        //Todo: Fix
        //LatLng coords = GeoTest.getLatLng(address.getAddress());

        LatLng coords = new LatLng(0.5, 0.5);
        
        if (coords == null) {
            throw new Exception("Invalid address. Can't find coordinates.");
        } else {
            address.setLatitude(coords.lat);
            address.setLatitude(coords.lng);
        }
    }
    
    static void generateAstralProfile(Client client) {
        Astro astro = new Astro();
        List<String> profil;

        try {
            profil = astro.getProfil(client.getFirstname(), client.getBirthDate());

            client.setZodiacSign(profil.get(0));
            client.setChineseSign(profil.get(1));
            client.setColor(profil.get(2));
            client.setAnimal(profil.get(3));

        } catch (IOException ex) {
            // TODO
        }
    }
}
