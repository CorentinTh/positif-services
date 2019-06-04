package fr.positif;

import fr.positif.entities.*;
import fr.positif.services.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Demo {

    /**
     * Un client s'enregistre
     */
    public static void registerClientOk() {

        // ---------------- Input from front end

        String firstname = "John",
                lastname = "Doe",
                phoneNumber = "06 25 25 65 65",
                email = "john.doe@carameil.fr",
                gender = "M",
                address = "2 rue raspail 69100 Villeurbanne",
                password = "pass",
                dob = "1997-05-11T22:00:00.000Z";

        // ---------------- IHM backend

        Client client = new Client(new Address(address), phoneNumber, email, lastname, firstname, gender, password, Date.from(Instant.parse(dob)));

        boolean status = Services.registerClient(client);

        // ---------------- Front end feedback

        System.out.println(status ? "Enregistrement ok" : "Enregistrement pas ok");

    }

    /**
     * Une erreur lors de l'enregistrement d'un client : l'address postale est incorrecte.
     */
    public static void registerClientFailed() {

        // ---------------- Input from front end

        String firstname = "John",
                lastname = "Doe",
                phoneNumber = "06 25 25 65 65",
                email = "john.doe@carameil.fr",
                gender = "M",
                address = "",
                password = "pass",
                dob = "1997-05-11T22:00:00.000Z";

        // ---------------- IHM backend

        Client client = new Client(new Address(address), phoneNumber, email, lastname, firstname, gender, password, Date.from(Instant.parse(dob)));

        boolean status = Services.registerClient(client);

        // ---------------- Front end feedback

        System.out.println(status ? "Enregistrement ok" : "Enregistrement pas ok");

    }

    /**
     * Le client est capable de consulter son profile
     */
    public static void checkClientProfile() {

        // ---------------- Prerequisite

        Demo.registerClientOk();

        // ---------------- Input from front end

        Long id = 1L;

        // ---------------- IHM backend

        Client client = (Client) Services.getPerson(id);

        // ---------------- Front end feedback

        System.out.println(client);

    }

    /**
     * Un client est capable d'avoir la liste des mediums
     */
    public static void checkMediumList() {

        // ---------------- Prerequisite

        ServicesInit.insertMediums();

        // ---------------- Input from front end

        // ---------------- IHM backend

        List<Medium> list = Services.getMediums(1, 100);

        // ---------------- Front end feedback

        System.out.println(list);

    }

    /**
     * Un client est capable de voir le details d'un medium
     */
    public static void getMediumInfo() {

        // ---------------- Prerequisite

        ServicesInit.insertMediums();

        // ---------------- Input from front end

        Long mediumID = 1L;

        // ---------------- IHM backend

        Medium medium = Services.getMedium(mediumID);

        // ---------------- Front end feedback

        System.out.println(medium);

    }

    /**
     * Un client, munis d'un médium peuvent créer une consultation
     */
    public static void createConsultation(){
        // ---------------- Prerequisite

        Demo.registerClientOk();
        ServicesInit.insertMediums();
        ServicesInit.insertEmployees();

        // ---------------- Input from front end

        Long mediumID = 2L;
        Long clientID = 1L; // Ou stockage en session

        // ---------------- IHM backend

        Medium medium = Services.getMedium(mediumID);
        Client client = (Client) Services.getPerson(clientID);


        boolean status = Services.initConsultation(client, medium);

        // ---------------- Front end feedback

        System.out.println(status ? "Demande de consultation envoyé." : "Erreur lors de la demande de consultation.");
    }

}
