package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithFakerDataTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    FakeData fakeData = new FakeData();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    @Test
    @DisplayName("Registration Test")
    void fillFormTest() {

        fakeData.chooseRandomCityOfState();
        String stateAndCity = fakeData.getStateAndCity();

        registrationFormPage.openPage().closeAds()
                .setFirstName(fakeData.firstName)
                .setLastName(fakeData.lastName)
                .setEmail(fakeData.email)
                .setGender(fakeData.gender)
                .setNumber(fakeData.number)
                .setBirthDate(fakeData.day, fakeData.month, fakeData.year)
                .setSubjects(fakeData.subject)
                .setListOfHobbies(fakeData.hobbies)
                .setImage(fakeData.imagePath)
                .setAddress(fakeData.address)
                .setState(fakeData.state)
                .setCity(fakeData.city)
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", fakeData.firstName + " " + fakeData.lastName)
                .checkResult("Student Email", fakeData.email)
                .checkResult("Gender", fakeData.gender)
                .checkResult("Mobile", fakeData.number)
                .checkResult("Date of Birth", fakeData.dateOfBirth)
                .checkResult("Subjects", fakeData.subject)
                .checkResult("Hobbies", fakeData.hobbiesResult)
                .checkResult("Picture", fakeData.imagePath)
                .checkResult("Address", fakeData.address)
                .checkResult("State and City", stateAndCity);
    }
}