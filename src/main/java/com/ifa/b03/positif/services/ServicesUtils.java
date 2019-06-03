package com.ifa.b03.positif.services;

import com.google.maps.model.LatLng;
import com.ifa.b03.positif.entities.Address;
import com.ifa.b03.positif.entities.Client;
import com.ifa.b03.positif.utils.Astro;
import com.ifa.b03.positif.utils.GeoTest;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class ServicesUtils {

    static void validateAndGenerateGpsAddress(Address address) throws Exception {

        LatLng coords = GeoTest.getLatLng(address.getAddress());

        if (coords == null) {
            throw new Exception("Invalid address. Can't find coordinates.");
        } else {
            address.setLatitude(coords.lat);
            address.setLatitude(coords.lng);
        }
    }


    static void generateAstralProfil(Client client) {
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
