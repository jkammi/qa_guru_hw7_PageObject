package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    @Test
    @DisplayName("Fill simple form Test")
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Egor");
        $("#userEmail").setValue("Egor@fff.ty");
        $("#currentAddress").setValue("adress 1");
        $("#permanentAddress").setValue("adress 2");
        $("#submit").click();
        $("#output #name").shouldHave(text("Egor"));
        $("#output #email").shouldHave(text("Egor@fff.ty"));
        $("#output #currentAddress").shouldHave(text("adress 1"));
        $("#output #permanentAddress").shouldHave(text("adress 2"));
    }

    @Test
    @DisplayName("Registration Test")
    void fillPracticeForm() {
        open("/automation-practice-form");
        $("#userForm #firstName").setValue("Kamila");
        $("#userForm #lastName").setValue("Sharuykova");
        $("#userForm #userEmail").setValue("kamila@gmail.com");
        // gender
        $("#genterWrapper").$(byText("Female")).click();
        // mobile number
        $("#userForm #userNumber").setValue("7951893550");
        // birthday
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--021").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2003");
        $(".react-datepicker__week:nth-child(6) > .react-datepicker__day--006").click();
        // subjects
        $("#subjectsInput").setValue("Economics").pressEnter();
        // hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        // upload image
        $("#uploadPicture").setValue("src\\test\\resources\\Circle-icon.png");
        // address
        $("#currentAddress").setValue("my address 123");
        // state
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        // city
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        // submit
        $("#submit").pressEnter();
        // assertions
        $(".modal-dialog").shouldBe(visible);
        $(".modal-body").shouldHave(
                text("Kamila Sharuykova"),
                text("kamila@gmail.com"),
                text("Female"),
                text("7951893550"),
                text("06 March,2003"),
                text("Economics"),
                text("Sports"),
                text("Circle-icon.png"),
                text("my address 123"),
                text("Haryana Karnal")
        );
    }
}
