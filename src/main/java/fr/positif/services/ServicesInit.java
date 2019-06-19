/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.services;

import fr.positif.dao.JpaUtil;
import fr.positif.dao.MediumDao;
import fr.positif.dao.PersonDao;
import fr.positif.entities.*;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author cthomasset
 */
public class ServicesInit {
    public static void insertEmployees(){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();


// Javascript pour generer des employés, à copier coller dans la console d'un navigateur
//
//        fetch('https://randomuser.me/api/?nat=fr&results=50')
//                .then(data => data.json())
//                .then(json => {
//                            console.log(json.results.reduce((acc, user) => {
//
//                        const voice = user.gender == 'male' ? 'VoiceType.MASCULINE' : 'VoiceType.FEMININE';
//                        const experience = Math.random() > 0.5 ? 'ExperienceType.SENIOR' : 'ExperienceType.JUNIOR';
//                        const gender = user.gender == 'male' ? 'M' : 'F';
//
//                    acc += `PersonDao.persist(new Employee(${voice}, ${experience}, "${user.email}", "${user.name.first}", "${user.name.last}", "${gender}", "${user.login.password}", Date.from( Instant.parse("${user.dob.date}"))));\n`
//
//                    return acc;
//                    }, ''));
//                });


        // Loop is for pussies
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "bf@example.com", "frolin", "balthazar", "M", "bf", Date.from( Instant.parse( "1993-06-03T21:55:54Z" ))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "admin@positif.fr", "thomasset", "corentin", "M", "admin", Date.from( Instant.parse( "1993-06-03T21:55:54Z" ))));

        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "lucas.richard@positif.fr", "lucas", "richard", "M", "lucas.richard@positif.fr", Date.from( Instant.parse("1977-07-10T10:21:22Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "thomas.blanc@positif.fr", "thomas", "blanc", "M", "thomas.blanc@positif.fr", Date.from( Instant.parse("1965-10-12T21:48:29Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "norah.dasilva@positif.fr", "norah", "dasilva", "F", "norah.dasilva@positif.fr", Date.from( Instant.parse("1974-05-23T01:53:07Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "marilou.caron@positif.fr", "marilou", "caron", "F", "marilou.caron@positif.fr", Date.from( Instant.parse("1990-08-08T16:12:10Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "mathilde.girard@positif.fr", "mathilde", "girard", "F", "mathilde.girard@positif.fr", Date.from( Instant.parse("1991-11-26T09:49:21Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "fabien.perrin@positif.fr", "fabien", "perrin", "M", "fabien.perrin@positif.fr", Date.from( Instant.parse("1970-01-05T21:35:22Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "lucien.girard@positif.fr", "lucien", "girard", "M", "lucien.girard@positif.fr", Date.from( Instant.parse("1956-11-09T20:12:02Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "gaëtan.riviere@positif.fr", "gaëtan", "riviere", "M", "gaëtan.riviere@positif.fr", Date.from( Instant.parse("1983-12-23T22:31:42Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "célestin.meyer@positif.fr", "célestin", "meyer", "M", "célestin.meyer@positif.fr", Date.from( Instant.parse("1946-03-09T15:02:27Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "thomas.guillaume@positif.fr", "thomas", "guillaume", "M", "thomas.guillaume@positif.fr", Date.from( Instant.parse("1948-10-04T05:26:37Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "lucile.hubert@positif.fr", "lucile", "hubert", "F", "lucile.hubert@positif.fr", Date.from( Instant.parse("1981-06-26T19:45:07Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "flora.moreau@positif.fr", "flora", "moreau", "F", "flora.moreau@positif.fr", Date.from( Instant.parse("1982-08-12T02:35:13Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "gauthier.roche@positif.fr", "gauthier", "roche", "M", "gauthier.roche@positif.fr", Date.from( Instant.parse("1985-12-30T17:58:36Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "margaux.caron@positif.fr", "margaux", "caron", "F", "margaux.caron@positif.fr", Date.from( Instant.parse("1945-03-12T17:29:24Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "maxence.francois@positif.fr", "maxence", "francois", "M", "maxence.francois@positif.fr", Date.from( Instant.parse("1996-03-27T09:53:40Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "matthieu.leclerc@positif.fr", "matthieu", "leclerc", "M", "matthieu.leclerc@positif.fr", Date.from( Instant.parse("1957-06-24T12:56:21Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "fabio.joly@positif.fr", "fabio", "joly", "M", "fabio.joly@positif.fr", Date.from( Instant.parse("1976-02-14T18:45:18Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "line.henry@positif.fr", "line", "henry", "F", "line.henry@positif.fr", Date.from( Instant.parse("1984-11-11T06:39:14Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "fabien.meyer@positif.fr", "fabien", "meyer", "M", "fabien.meyer@positif.fr", Date.from( Instant.parse("1984-10-26T07:46:02Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "charline.clement@positif.fr", "charline", "clement", "F", "charline.clement@positif.fr", Date.from( Instant.parse("1987-02-07T00:13:39Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "jade.robert@positif.fr", "jade", "robert", "F", "jade.robert@positif.fr", Date.from( Instant.parse("1964-05-14T15:11:09Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "charly.olivier@positif.fr", "charly", "olivier", "M", "charly.olivier@positif.fr", Date.from( Instant.parse("1964-02-23T09:10:53Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "ava.martinez@positif.fr", "ava", "martinez", "F", "ava.martinez@positif.fr", Date.from( Instant.parse("1972-04-28T07:59:29Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "alizee.legall@positif.fr", "alizee", "legall", "F", "alizee.legall@positif.fr", Date.from( Instant.parse("1987-08-11T12:59:26Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "faustine.dasilva@positif.fr", "faustine", "dasilva", "F", "faustine.dasilva@positif.fr", Date.from( Instant.parse("1955-01-03T20:34:46Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "lilian.dufour@positif.fr", "lilian", "dufour", "M", "lilian.dufour@positif.fr", Date.from( Instant.parse("1965-11-04T19:12:17Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "hanaé.noel@positif.fr", "hanaé", "noel", "F", "hanaé.noel@positif.fr", Date.from( Instant.parse("1983-05-20T00:02:22Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "romain.gautier@positif.fr", "romain", "gautier", "M", "romain.gautier@positif.fr", Date.from( Instant.parse("1969-03-25T19:49:28Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "anaëlle.giraud@positif.fr", "anaëlle", "giraud", "F", "anaëlle.giraud@positif.fr", Date.from( Instant.parse("1947-03-31T05:42:38Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "côme.barbier@positif.fr", "côme", "barbier", "M", "côme.barbier@positif.fr", Date.from( Instant.parse("1958-10-13T07:23:03Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "simon.roche@positif.fr", "simon", "roche", "M", "simon.roche@positif.fr", Date.from( Instant.parse("1990-10-26T05:51:13Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "alicia.brunet@positif.fr", "alicia", "brunet", "F", "alicia.brunet@positif.fr", Date.from( Instant.parse("1965-12-29T08:21:11Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "flora.louis@positif.fr", "flora", "louis", "F", "flora.louis@positif.fr", Date.from( Instant.parse("1958-01-18T03:40:22Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "thomas.lopez@positif.fr", "thomas", "lopez", "M", "thomas.lopez@positif.fr", Date.from( Instant.parse("1980-03-02T07:18:52Z"))));

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }

    public static void insertMediums(){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        MediumDao.persist(new Medium("Gwenaël", TalentType.FORTUNE_TELLER, "Spécialiste des grandes conversatons au-delà de TOUTES les frontrres.", VoiceType.MASCULINE, ExperienceType.JUNIOR).setSpeciality("Boule de Cristal").setPicturePath("https://react.semantic-ui.com/images/avatar/large/matthew.png"));
        MediumDao.persist(new Medium("Professeur Maxwell", TalentType.FORTUNE_TELLER, "Votre avenir est devant vous : regardons-le ensemble !", VoiceType.MASCULINE, ExperienceType.SENIOR).setSpeciality("Marc de Café").setPicturePath("https://semantic-ui.com/images/avatar2/large/mark.png"));
        MediumDao.persist(new Medium("Mme Irma", TalentType.TAROT_READER, "Comprenez votre entourage grâce à mes cartes ! Résultats rapides.", VoiceType.FEMININE, ExperienceType.SENIOR).setPicturePath("https://semantic-ui.com/images/avatar2/large/kristy.png"));
        MediumDao.persist(new Medium("Endora", TalentType.TAROT_READER, "Mes cartes répondront à toutes vos questons personnelles.", VoiceType.FEMININE, ExperienceType.JUNIOR).setPicturePath("https://semantic-ui.com/images/avatar2/large/elyse.png"));
        MediumDao.persist(new Medium("Serena", TalentType.ASTROLOGIST, "Basée à Champigny-sur-Marne, Serena vous révrlera votre avenir pour éclairer votre passé.", VoiceType.FEMININE, ExperienceType.SENIOR).setTrainig("École Normale Supérieure d’Astrologie (ENS-Astro)").setSchoolYear(2006).setPicturePath("https://react.semantic-ui.com/images/avatar/large/stevie.jpg"));
        MediumDao.persist(new Medium("Mr M. Histaire-Hyeux", TalentType.ASTROLOGIST, "Avenir, avenir, que nous réserves-tu? N'atendez plus, demandez à me consulter!", VoiceType.FEMININE, ExperienceType.JUNIOR).setTrainig("Insttut des Nouveaux Savoirs Astrologiques").setSchoolYear(2010).setPicturePath("https://react.semantic-ui.com/images/avatar/large/steve.jpg"));

        MediumDao.persist(new Medium("Mr Potiron", TalentType.TAROT_READER, "Mes cartes devoilleront votre avenir!", VoiceType.MASCULINE, ExperienceType.JUNIOR).setPicturePath("https://react.semantic-ui.com/images/avatar/large/molly.png"));
        MediumDao.persist(new Medium("Mr Pierre Edouard Pidou", TalentType.TAROT_READER, "Je vous prédirai votre chemin optimal", VoiceType.MASCULINE, ExperienceType.JUNIOR).setPicturePath("http://smtb.cbl-web.com/images/avatar/big/elliot.jpg"));
        MediumDao.persist(new Medium("Mme Loupicka", TalentType.ASTROLOGIST, "", VoiceType.FEMININE, ExperienceType.SENIOR).setPicturePath("http://smtb.cbl-web.com/images/avatar/big/jenny.jpg"));
        MediumDao.persist(new Medium("Professeur Soko", TalentType.FORTUNE_TELLER, "Grand voyant médium", VoiceType.MASCULINE, ExperienceType.SENIOR).setPicturePath("https://semantic-ui.com/images/avatar/large/joe.jpg"));

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }
}
