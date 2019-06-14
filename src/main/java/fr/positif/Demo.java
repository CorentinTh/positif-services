package fr.positif;

import fr.positif.entities.*;
import fr.positif.services.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Demo {

    /**
     * Un client s'enregistre
     */
    public static void registerClientOk() {

        // ---------------- Input from front end

        System.out.println(" >> ENREGISTREMENT CLIENT");
        System.out.println("------ Inputs from IHM ------");

        String firstname = "John",
                lastname = "Doe",
                phoneNumber = "06 25 25 65 65",
                email = "john.doe@carameil.fr",
                gender = "M",
                address = "2 rue raspail 69100 Villeurbanne",
                password = "pass",
                dob = "1997-05-11T22:00:00.000Z";

        System.out.println("firstname: " + firstname);
        System.out.println("lastname: " + lastname);
        System.out.println("phoneNumber: " + phoneNumber);
        System.out.println("email: " + email);
        System.out.println("gender: " + gender);
        System.out.println("address: " + address);
        System.out.println("password: " + password);
        System.out.println("dob: " + dob);


        // ---------------- IHM backend

        Client client = new Client(new Address(address), phoneNumber, email, lastname, firstname, gender, password, Date.from(Instant.parse(dob)));

        boolean status = Services.registerClient(client);

        // ---------------- Front end feedback

        System.out.println("\n\n------ Output to IHM ------");

        System.out.println(status ? "Enregistrement ok" : "Enregistrement pas ok");


        try{new BufferedReader(new InputStreamReader( System.in)).readLine();} catch (Exception e){}
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
     * A client is able to login with is credentials
     */
    public static void loginClientOk(){

        // ---------------- Prerequisite

        Demo.registerClientOk();

        // ---------------- Input from front end

        String email = "john.doe@carameil.fr",
                password = "pass";

        // ---------------- IHM backend

        Person person = Services.checkCredentials(email, password);

        // ---------------- Front end feedback

        System.out.println(person != null ? "Login ok" : "Login pas ok");
    }

    /**
     * A client is able to login with is credentials
     */
    public static void loginClientFailed(){

        // ---------------- Prerequisite

        Demo.registerClientOk();

        // ---------------- Input from front end

        String email = "john.doe@carameil.fr",
                password = "paszefzsfqsdfqfzqfzqes";

        // ---------------- IHM backend

        Person person = Services.checkCredentials(email, password);

        // ---------------- Front end feedback

        System.out.println(person != null ? "Login ok" : "Login pas ok");
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

        System.out.println("\n\n >> CREATION CONSULTATION");
        System.out.println("------ Inputs from IHM ------");

        Long mediumID = 2L;
        Long clientID = 1L; // Ou stockage en session

        System.out.println("mediumID: " + mediumID);
        System.out.println("clientID: " + clientID);

        // ---------------- IHM backend

        Medium medium = Services.getMedium(mediumID);
        Client client = (Client) Services.getPerson(clientID);

        boolean status = Services.initConsultation(client, medium);

        // ---------------- Front end feedback

        System.out.println("------ Output to IHM ------");

        System.out.println(medium);

        System.out.println(status ? "Demande de consultation envoyé." : "Erreur lors de la demande de consultation.");
        try{new BufferedReader(new InputStreamReader( System.in)).readLine();} catch (Exception e){}
    }

    /**
     * Un employee accepte la demande de consultation émise par le client
     */
    public static void acceptConsultation(){

        // ---------------- Prerequisite

        Demo.createConsultation();

        // ---------------- Input from front end

        System.out.println("\n\n >> ACCEPT CONSULTATION");
        System.out.println("------ Inputs from IHM ------");

        Long consultationID = 46L;

        System.out.println("consultationID: " + consultationID);

        // ---------------- IHM backend

        Consultation consultation = Services.getConsultation(consultationID);
        Services.acceptConsultation(consultation);

        // ---------------- Front end feedback

        System.out.println("------ Output to IHM ------");

        System.out.println("\n\nConsultation acceptée. " + consultation);
        try{new BufferedReader(new InputStreamReader( System.in)).readLine();} catch (Exception e){}
    }

    /**
     * Un employee termine la consultation precedement ouverte
     */
    public static void closeConsultation(){

        // ---------------- Prerequisite

        Demo.acceptConsultation();

        // ---------------- Input from front end

        System.out.println("\n\n >> CLOSE CONSULTATION");
        System.out.println("------ Inputs from IHM ------");

        Long consultationID = 46L;
        String comment = "La consultation s'est tres bien passé.";
        String endDate = "2019-05-11T13:15:00.000Z";

        System.out.println("consultationID: " + consultationID);
        System.out.println("comment: " + comment);
        System.out.println("endDate: " + endDate);

        // ---------------- IHM backend

        Consultation consultation = Services.getConsultation(consultationID);

        Services.closeConsultation(consultation, comment, Date.from(Instant.parse(endDate)));

        // ---------------- Front end feedback

        System.out.println("------ Output to IHM ------");

        System.out.println("Consultation fermée. " + consultation);
        try{new BufferedReader(new InputStreamReader( System.in)).readLine();} catch (Exception e){}
    }

    public static void getHistoriqueClient(){

        // ---------------- Prerequisite

        Demo.closeConsultation();

        System.out.println("\n\n >> GET HISTORIQUE");

        // ---------------- Input from front end

        System.out.println("------ Inputs from IHM ------");

        Long clientID = 1L; // Ou stockage en session
        System.out.println("clientID: " + clientID);

        // ---------------- IHM backend

        Client client = (Client) Services.getPerson(clientID);
        //List<Consultation> consultations = Services.getConsultations(client);

        // ---------------- Front end feedback

        System.out.println("------ Output to IHM ------");

        //System.out.println(consultations);

        try{new BufferedReader(new InputStreamReader( System.in)).readLine();} catch (Exception e){}
    }

    /**
     *
     */
    public static void getStatistics(){

        // ---------------- Input from front end


        Demo.getHistoriqueClient();

        // ---------------- IHM backend
        System.out.println("\n\n >> STATISTICS");

        Map<Employee, Long> counts = Services.getClientCountByEmployee();

        // ---------------- Front end feedback

        System.out.println("------ Output to IHM ------");


        System.out.println("Length: " + counts.size());

        for (Map.Entry<Employee, Long> entry : counts.entrySet()) {
            System.out.println(entry.getKey().getFirstname() + " : " + entry.getValue().toString());
        }

    }



}
