package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithFakerDataTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    FakeData fakeData = new FakeData();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    @DisplayName("Registration Test")
    void fillFormTest() {

        registrationFormPage.openPage()
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
                .checkResult("Date of Birth", fakeData.dateOfBirthResult)
                .checkResult("Subjects", fakeData.subject)
                .checkResult("Hobbies", fakeData.hobbiesResult)
                .checkResult("Picture", fakeData.imagePath)
                .checkResult("Address", fakeData.address)
                .checkResult("State and City", fakeData.stateAndCityResult);
    }
}
