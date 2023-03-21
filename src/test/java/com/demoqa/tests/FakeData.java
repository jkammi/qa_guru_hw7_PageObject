package com.demoqa.tests;

import com.github.javafaker.Faker;

import static com.demoqa.utils.RandomUtils.*;

public class FakeData extends TestBase {

    Faker faker = new Faker();

    String[] genders = {"Male", "Female", "Other"};

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomItemFromArray(genders),
            number = faker.phoneNumber().toString(),
            address = faker.address().toString(),
            dayOfBirth = random.nextInt(max - min + 1) + min

}
