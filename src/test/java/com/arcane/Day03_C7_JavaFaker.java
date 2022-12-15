package com.arcane;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day03_C7_JavaFaker {
    //cogunlukla test için fake data kullanırız
    // JavaFaker de fake data kullanmak için olusturulmuştur
    //JAva fake dependecy i pox,xml eklemiştik

    @Test
    public void fakerTest(){
        //1. Faker data tipinde object olustur
        Faker faker = new Faker();

        //2. ardından fake data kullanabiliriz : firstname, lastname, adress, city, state, country alabiliriz

       String fName = faker.name().firstName();
       System.out.println(fName);
        String lName = faker.name().lastName();
        System.out.println(lName);
       String fullname =  faker.name().fullName();
        System.out.println(fullname);

        //TİTLE
        System.out.println(faker.name().title());

        //city
        System.out.println(faker.address().city());

        //state
        System.out.println(faker.address().state());

        //telefon
        System.out.println(faker.phoneNumber().cellPhone());

        //post  kode / zip code
        System.out.println(faker.address().zipCode());

        // rastgele email adresi alır
        System.out.println(faker.internet().emailAddress());

        // rastgele bir rakam almak istiyorum
        System.out.println(faker.number().digits(6));

        // rastgele bir karakter yazdırsın
        System.out.println(faker.lordOfTheRings().character());

        // rastgele hayvan ismi versin
        System.out.println(faker.animal().name());

        //rastgele bir resim (avatar) veriri
        System.out.println(faker.avatar().image());












    }


}
