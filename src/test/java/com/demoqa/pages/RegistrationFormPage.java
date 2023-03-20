package com.demoqa.pages;

import git add .com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    // Elements
    private final static String TITLE_TEXT = "Student registration form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#userForm #firstName"),
            lastNameInput = $("#userForm #lastName"),
            emailInput = $("#userForm #userEmail"),
            genderInput = $("#genterWrapper"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            imageInput = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityInput = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit");


    // Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        $("#userForm #userNumber").setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setImage(String value) {
        imageInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        adressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        submitButton.scrollIntoView(false).click();
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.scrollTo().click();
        stateCityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.click();
        stateCityInput.$(byText(value)).click();
        return this;
    }

    // Assertions

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);
        return this;
    }

}
