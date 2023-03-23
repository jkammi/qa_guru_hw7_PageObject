package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    @Test
    @DisplayName("Registration Test")
    void fillFormTest() {
        registrationFormPage.openPage().closeAds()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("30", "July", "2008")
                .setSubjects("English")
                .setHobbies("Sports")
                .setImage("Circle-icon.png")
                .setAddress("my address 123")
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Alex Egorov")
                .checkResult("Student Email", "alex@egorov.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Circle-icon.png")
                .checkResult("Address", "my address 123")
                .checkResult("State and City", "Haryana Karnal");
    }
}
