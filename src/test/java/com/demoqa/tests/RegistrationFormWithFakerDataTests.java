package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithFakerDataTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    FakeData fakeData = new FakeData();

    @Test
    @DisplayName("Registration Test")
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(fakeData.firstName)
                .setLastName(fakeData.lastName)
                .setEmail(fakeData.email)
                .setGender(fakeData.gender)
                .setNumber(fakeData.number)
                .setBirthDate("30", "July", "2008")
                .setSubjects("English")
                .setHobbies("Sports")
                .setImage("C:\\Users\\79518\\Java_projects\\qa_guru_hw7_PageObject\\src\\test\\resources\\Circle-icon.png")
                .setAddress(fakeData.address)
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", fakeData.firstName + " " + fakeData.lastName)
                .checkResult("Student Email", fakeData.email)
                .checkResult("Gender", fakeData.gender)
                .checkResult("Mobile", fakeData.number)
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Circle-icon.png")
                .checkResult("Address", fakeData.address)
                .checkResult("State and City", "Haryana Karnal");
    }
}
