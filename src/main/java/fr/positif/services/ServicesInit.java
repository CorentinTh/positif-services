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
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "ct@example.com", "thomasset", "corentin", "M", "ct", Date.from( Instant.parse( "1993-06-03T21:55:54Z" ))));

        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "lucas.richard@example.com", "lucas", "richard", "M", "catdog", Date.from( Instant.parse("1977-07-10T10:21:22Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "thomas.blanc@example.com", "thomas", "blanc", "M", "australi", Date.from( Instant.parse("1965-10-12T21:48:29Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "norah.dasilva@example.com", "norah", "da silva", "F", "travis", Date.from( Instant.parse("1974-05-23T01:53:07Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "marilou.caron@example.com", "marilou", "caron", "F", "dookie", Date.from( Instant.parse("1990-08-08T16:12:10Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "mathilde.girard@example.com", "mathilde", "girard", "F", "animated", Date.from( Instant.parse("1991-11-26T09:49:21Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "fabien.perrin@example.com", "fabien", "perrin", "M", "barney", Date.from( Instant.parse("1970-01-05T21:35:22Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "lucien.girard@example.com", "lucien", "girard", "M", "monster", Date.from( Instant.parse("1956-11-09T20:12:02Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "gaëtan.riviere@example.com", "gaëtan", "riviere", "M", "holein1", Date.from( Instant.parse("1983-12-23T22:31:42Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "célestin.meyer@example.com", "célestin", "meyer", "M", "radar", Date.from( Instant.parse("1946-03-09T15:02:27Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "thomas.guillaume@example.com", "thomas", "guillaume", "M", "katrin", Date.from( Instant.parse("1948-10-04T05:26:37Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "lucile.hubert@example.com", "lucile", "hubert", "F", "robin", Date.from( Instant.parse("1981-06-26T19:45:07Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "flora.moreau@example.com", "flora", "moreau", "F", "cooldude", Date.from( Instant.parse("1982-08-12T02:35:13Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "gauthier.roche@example.com", "gauthier", "roche", "M", "dianne", Date.from( Instant.parse("1985-12-30T17:58:36Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "margaux.caron@example.com", "margaux", "caron", "F", "124038", Date.from( Instant.parse("1945-03-12T17:29:24Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "maxence.francois@example.com", "maxence", "francois", "M", "temp123", Date.from( Instant.parse("1996-03-27T09:53:40Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "matthieu.leclerc@example.com", "matthieu", "leclerc", "M", "7654321", Date.from( Instant.parse("1957-06-24T12:56:21Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "fabio.joly@example.com", "fabio", "joly", "M", "generic", Date.from( Instant.parse("1976-02-14T18:45:18Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "line.henry@example.com", "line", "henry", "F", "racing", Date.from( Instant.parse("1984-11-11T06:39:14Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "fabien.meyer@example.com", "fabien", "meyer", "M", "zone", Date.from( Instant.parse("1984-10-26T07:46:02Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "charline.clement@example.com", "charline", "clement", "F", "monarch", Date.from( Instant.parse("1987-02-07T00:13:39Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "jade.robert@example.com", "jade", "robert", "F", "oooo", Date.from( Instant.parse("1964-05-14T15:11:09Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "charly.olivier@example.com", "charly", "olivier", "M", "1q2w3e4r", Date.from( Instant.parse("1964-02-23T09:10:53Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "ava.martinez@example.com", "ava", "martinez", "F", "monkeybo", Date.from( Instant.parse("1972-04-28T07:59:29Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "alizee.legall@example.com", "alizee", "le gall", "F", "felipe", Date.from( Instant.parse("1987-08-11T12:59:26Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "faustine.dasilva@example.com", "faustine", "da silva", "F", "selena", Date.from( Instant.parse("1955-01-03T20:34:46Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "lilian.dufour@example.com", "lilian", "dufour", "M", "young", Date.from( Instant.parse("1965-11-04T19:12:17Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "hanaé.noel@example.com", "hanaé", "noel", "F", "stuart", Date.from( Instant.parse("1983-05-20T00:02:22Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "romain.gautier@example.com", "romain", "gautier", "M", "1943", Date.from( Instant.parse("1969-03-25T19:49:28Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "anaëlle.giraud@example.com", "anaëlle", "giraud", "F", "1977", Date.from( Instant.parse("1947-03-31T05:42:38Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "côme.barbier@example.com", "côme", "barbier", "M", "gman", Date.from( Instant.parse("1958-10-13T07:23:03Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.JUNIOR, "simon.roche@example.com", "simon", "roche", "M", "chandra", Date.from( Instant.parse("1990-10-26T05:51:13Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "alicia.brunet@example.com", "alicia", "brunet", "F", "federal", Date.from( Instant.parse("1965-12-29T08:21:11Z"))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "flora.louis@example.com", "flora", "louis", "F", "case", Date.from( Instant.parse("1958-01-18T03:40:22Z"))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "thomas.lopez@example.com", "thomas", "lopez", "M", "beatle", Date.from( Instant.parse("1980-03-02T07:18:52Z"))));

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }

    public static void insertMediums(){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        MediumDao.persist(new Medium("Gwenaël", TalentType.FORTUNE_TELLER, "Spécialiste des grandes conversatons au-delà de TOUTES les frontrres.", VoiceType.MASCULINE, ExperienceType.JUNIOR).setSpeciality("Boule de Cristal"));
        MediumDao.persist(new Medium("Professeur Maxwell", TalentType.FORTUNE_TELLER, "Votre avenir est devant vous : regardons-le ensemble !", VoiceType.MASCULINE, ExperienceType.SENIOR).setSpeciality("Marc de Café"));
        MediumDao.persist(new Medium("Mme Irma", TalentType.TAROT_READER, "Comprenez votre entourage grâce à mes cartes ! Résultats rapides.", VoiceType.FEMININE, ExperienceType.SENIOR));
        MediumDao.persist(new Medium("Endora", TalentType.TAROT_READER, "Mes cartes répondront à toutes vos questons personnelles.", VoiceType.FEMININE, ExperienceType.JUNIOR));
        MediumDao.persist(new Medium("Serena", TalentType.ASTROLOGIST, "Basée à Champigny-sur-Marne, Serena vous révrlera votre avenir pour éclairer votre passé.", VoiceType.FEMININE, ExperienceType.SENIOR).setTrainig("École Normale Supérieure d’Astrologie (ENS-Astro)").setSchoolYear(2006));
        MediumDao.persist(new Medium("Mr M. Histaire-Hyeux", TalentType.ASTROLOGIST, "Avenir, avenir, que nous réserves-tu? N'atendez plus, demandez à me consulter!", VoiceType.FEMININE, ExperienceType.JUNIOR).setTrainig("Insttut des Nouveaux Savoirs Astrologiques").setSchoolYear(2010));

        MediumDao.persist(new Medium("Mr Potiron", TalentType.TAROT_READER, "Mes cartes devoilleront votre avenir!", VoiceType.MASCULINE, ExperienceType.JUNIOR));
        MediumDao.persist(new Medium("Mr Pierre Edouard Pidou", TalentType.TAROT_READER, "Je vous prédirai votre chemin optimal", VoiceType.MASCULINE, ExperienceType.JUNIOR));
//        MediumDao.persist(new Medium("Mme Loupicka", TalentType.ASTROLOGIST, "", VoiceType.FEMININE, ExperienceType.SENIOR));
//        MediumDao.persist(new Medium("Professeur Soko", TalentType.FORTUNE_TELLER, "Grand voyant médium", VoiceType.MASCULINE, ExperienceType.SENIOR));

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }
}
