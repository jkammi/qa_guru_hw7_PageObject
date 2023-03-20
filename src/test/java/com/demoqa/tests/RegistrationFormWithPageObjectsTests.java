package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

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
        registrationFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("30", "July", "2008");

//        sleep(500);

        registrationFormPage.openPage()
                .setSubjects("Biology");
//                .setHobbies("Sports");

//        $("#uploadPicture").setValue("src\\test\\resources\\Circle-icon.png");
//        $("#currentAddress").setValue("my address 123");
//        $("#state").scrollTo().click();
//        $("#stateCity-wrapper").$(byText("Haryana")).click();
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").scrollIntoView(false).click();
//        sleep(500);

//        assertions

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Alex Egorov")
                .checkResult("Student Email", "alex@egorov.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008");

    }
    }

