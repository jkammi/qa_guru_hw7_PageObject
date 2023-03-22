package com.demoqa.tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.demoqa.utils.RandomUtils.*;

public class FakeData extends TestBase {

    Faker faker = new Faker();

    String imagePath = "C:\\Users\\79518\\Java_projects\\qa_guru_hw7_PageObject\\src\\test\\resources\\Circle-icon.png";

    String[] gendersList = {"Male", "Female", "Other"};
    String[] subjectsList = {"Hindi", "English", "Maths", "Physics",
            "Chemistry", "Biology", "Computer Science", "Commerce",
            "Accounting", "Economics", "Arts", "Social Studies",
            "History", "Civics"};
    String[] hobbiesList = {"Sports", "Reading", "Music"};
    String[] statesList = {"NCR", "Uttar Pradesh", "Haryana", "Rajastan"};

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomItemFromArray(gendersList),
            number = String.valueOf((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L),
            address = faker.address().fullAddress(),
            subject = getRandomItemFromArray(subjectsList);
    public Date birthDateFaker = faker.date().birthday();
    public String[] hobbies = getRandomItemListFromArray(hobbiesList);
    String hobbiesResult = String.join(", ", hobbies);
    Date birthDate = new Date(birthDateFaker.getTime());
    SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    String day = dayFormat.format(birthDate);
    String month = monthFormat.format(birthDate);
    String year = yearFormat.format(birthDate);
    String dateOfBirthResult = day + " " + month + "," + year;
    String[] citiesNCR = {"Delhi", "Gurgaon", "Noida"};
    String[] citiesUttarPradesh = {"Agra", "Lucknow", "Merrut"};
    String[] citiesHaryana = {"Karnal", "Parnipat"};
    String[] citiesRajastan = {"Jaipur", "Jaiselmer"};
    String state = getRandomItemFromArray(statesList);
    String city = "";

    public void chooseRandomCityOfState() {
        if (state.equals("NCR")) {
            city = getRandomItemFromArray(citiesNCR);
        } else if (state.equals("Uttar Pradesh")) {
            city = getRandomItemFromArray(citiesUttarPradesh);
        } else if (state.equals("Haryana")) {
            city = getRandomItemFromArray(citiesHaryana);
        } else if (state.equals("Rajastan")) {
            city = getRandomItemFromArray(citiesRajastan);
        }
    }
    String stateAndCityResult = state + " " + city;
}
