/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.services;

import com.ifa.b03.positif.dao.JpaUtil;
import com.ifa.b03.positif.dao.MediumDao;
import com.ifa.b03.positif.dao.PersonDao;
import com.ifa.b03.positif.entities.*;

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
//                        const voice = user.name.gender == 'male' ? 'VoiceType.MASCULINE' : 'VoiceType.FEMININE';
//                        const experience = Math.random() > 0.5 ? 'ExperienceType.SENIOR' : 'ExperienceType.JUNIOR';
//                        const gender = user.name.gender == 'male' ? 'M' : 'F';
//
//                    acc += `PersonDao.persist(new Employee(${voice}, ${experience}, "${user.email}", "${user.name.first}", "${user.name.last}", "${gender}", "${user.login.password}", Date.from( Instant.parse("${user.dob.date}"))));\n`
//
//                    return acc;
//                    }, ''));
//                });


        // Loop is for pussies
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "bf@example.com", "frolin", "balthazar", "M", "bf", Date.from( Instant.parse( "1993-06-03T21:55:54Z" ))));
        PersonDao.persist(new Employee(VoiceType.MASCULINE, ExperienceType.SENIOR, "ct@example.com", "thomasset", "corentin", "M", "ct", Date.from( Instant.parse( "1993-06-03T21:55:54Z" ))));

        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "marius.gautier@example.com", "marius", "gautier", "F", "panther", Date.from( Instant.parse( "1993-06-03T21:55:54Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "marilou.faure@example.com", "marilou", "faure", "F", "runaway", Date.from( Instant.parse( "1986-07-26T09:30:04Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "sarah.caron@example.com", "sarah", "caron", "F", "gofast", Date.from( Instant.parse( "1975-11-24T14:04:13Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "loris.picard@example.com", "loris", "picard", "F", "clevelan", Date.from( Instant.parse( "1972-10-18T20:01:36Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "raphaël.richard@example.com", "raphaël", "richard", "F", "mian", Date.from( Instant.parse( "1969-05-09T22:49:40Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "aurélien.legall@example.com", "aurélien", "le gall", "F", "bizkit", Date.from( Instant.parse( "1944-10-03T07:05:16Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "livio.philippe@example.com", "livio", "philippe", "F", "stock", Date.from( Instant.parse( "1953-02-26T08:37:02Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "basile.roussel@example.com", "basile", "roussel", "F", "elway", Date.from( Instant.parse( "1979-01-07T11:00:33Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "adrien.aubert@example.com", "adrien", "aubert", "F", "blake", Date.from( Instant.parse( "1981-12-03T16:21:56Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "olivia.denis@example.com", "olivia", "denis", "F", "bullet", Date.from( Instant.parse( "1992-06-07T17:03:54Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "clarisse.louis@example.com", "clarisse", "louis", "F", "song", Date.from( Instant.parse( "1978-01-11T06:40:47Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "paul.rousseau@example.com", "paul", "rousseau", "F", "imperial", Date.from( Instant.parse( "1996-09-26T14:02:57Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "maëlle.colin@example.com", "maëlle", "colin", "F", "elvira", Date.from( Instant.parse( "1951-03-25T19:40:16Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "léonie.clement@example.com", "léonie", "clement", "F", "emerson", Date.from( Instant.parse( "1972-01-24T20:15:34Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "bérénice.legall@example.com", "bérénice", "le gall", "F", "insomnia", Date.from( Instant.parse( "1975-11-19T11:50:48Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "lise.arnaud@example.com", "lise", "arnaud", "F", "nike", Date.from( Instant.parse( "1996-05-26T00:52:00Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "johan.lopez@example.com", "johan", "lopez", "F", "magician", Date.from( Instant.parse( "1982-02-02T10:26:02Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "gaspard.picard@example.com", "gaspard", "picard", "F", "shania", Date.from( Instant.parse( "1984-07-03T18:39:09Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "aubin.brunet@example.com", "aubin", "brunet", "F", "groovy", Date.from( Instant.parse( "1945-05-29T07:33:04Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "hector.lecomte@example.com", "hector", "lecomte", "F", "yyyyy", Date.from( Instant.parse( "1980-12-28T02:31:10Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "clémence.renard@example.com", "clémence", "renard", "F", "aisan", Date.from( Instant.parse( "1966-09-04T06:44:48Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "eden.deschamps@example.com", "eden", "deschamps", "F", "whales", Date.from( Instant.parse( "1957-06-03T13:12:44Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "hanaé.brunet@example.com", "hanaé", "brunet", "F", "cooler", Date.from( Instant.parse( "1995-03-21T13:34:37Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "nicolas.david@example.com", "nicolas", "david", "F", "lara", Date.from( Instant.parse( "1994-02-04T19:12:15Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "johan.jean@example.com", "johan", "jean", "F", "xian", Date.from( Instant.parse( "1956-08-05T21:21:31Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "apolline.michel@example.com", "apolline", "michel", "F", "rufus", Date.from( Instant.parse( "1966-11-23T16:45:30Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "alix.colin@example.com", "alix", "colin", "F", "horn", Date.from( Instant.parse( "1963-03-05T16:05:56Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "ewen.clement@example.com", "ewen", "clement", "F", "chai", Date.from( Instant.parse( "1967-05-26T10:46:37Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "marine.roux@example.com", "marine", "roux", "F", "minnie", Date.from( Instant.parse( "1963-08-31T08:41:15Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "héloïse.roche@example.com", "héloïse", "roche", "F", "dawg", Date.from( Instant.parse( "1975-09-22T13:33:55Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "fabio.mercier@example.com", "fabio", "mercier", "F", "nasty1", Date.from( Instant.parse( "1959-11-27T07:23:49Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "mila.sanchez@example.com", "mila", "sanchez", "F", "151nxjmt", Date.from( Instant.parse( "1974-07-15T21:42:46Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "daphné.renaud@example.com", "daphné", "renaud", "F", "kittys", Date.from( Instant.parse( "1952-03-06T06:05:34Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "charly.legall@example.com", "charly", "le gall", "F", "3ip76k2", Date.from( Instant.parse( "1992-12-30T05:06:34Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "axelle.marie@example.com", "axelle", "marie", "F", "aries", Date.from( Instant.parse( "1965-11-23T16:48:08Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "noah.roussel@example.com", "noah", "roussel", "F", "goforit", Date.from( Instant.parse( "1953-05-09T00:37:10Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "ezio.marie@example.com", "ezio", "marie", "F", "362436", Date.from( Instant.parse( "1945-05-13T16:53:59Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "kiara.gonzalez@example.com", "kiara", "gonzalez", "F", "lantern", Date.from( Instant.parse( "1947-05-25T22:37:10Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "ana.renard@example.com", "ana", "renard", "F", "cleopatr", Date.from( Instant.parse( "1948-06-09T13:10:58Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "méline.rodriguez@example.com", "méline", "rodriguez", "F", "terrapin", Date.from( Instant.parse( "1986-07-22T10:04:10Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "david.morin@example.com", "david", "morin", "F", "wilson", Date.from( Instant.parse( "1986-09-08T15:54:19Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "matéo.faure@example.com", "matéo", "faure", "F", "bigbig", Date.from( Instant.parse( "1984-07-13T05:30:52Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "thibault.fournier@example.com", "thibault", "fournier", "F", "zhen", Date.from( Instant.parse( "1954-03-19T07:50:48Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "célia.lambert@example.com", "célia", "lambert", "F", "goldberg", Date.from( Instant.parse( "1955-03-23T15:56:21Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "elouan.sanchez@example.com", "elouan", "sanchez", "F", "modelsne", Date.from( Instant.parse( "1981-02-06T05:38:21Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "luna.rey@example.com", "luna", "rey", "F", "megadeth", Date.from( Instant.parse( "1987-08-19T18:27:38Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "diane.duval@example.com", "diane", "duval", "F", "444444", Date.from( Instant.parse( "1965-06-22T12:16:09Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "thiago.charles@example.com", "thiago", "charles", "F", "saturn", Date.from( Instant.parse( "1963-05-22T21:42:55Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.SENIOR, "thibaut.gonzalez@example.com", "thibaut", "gonzalez", "F", "molly", Date.from( Instant.parse( "1948-12-10T21:11:19Z" ))));
        PersonDao.persist(new Employee(VoiceType.FEMININE, ExperienceType.JUNIOR, "julia.francois@example.com", "julia", "francois", "F", "marianne", Date.from( Instant.parse( "1952-08-10T11:38:57Z" ))));

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }

    public static void insertMedium(){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        MediumDao.persist(new Medium("gwenaël", TalentType.FORTUNE_TELLER, "Spécialiste des grandes conversatons au-delà de TOUTES les frontrres.", VoiceType.MASCULINE, ExperienceType.JUNIOR, 10L));
        MediumDao.persist(new Medium("gwenaël", TalentType.FORTUNE_TELLER, "Spécialiste des grandes conversatons au-delà de TOUTES les frontrres.", VoiceType.MASCULINE, ExperienceType.JUNIOR, 10L));


        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }
}
