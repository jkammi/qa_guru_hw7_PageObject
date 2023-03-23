package com.demoqa.tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.demoqa.utils.RandomUtils.*;

public class FakeData extends TestBase {

    Faker faker = new Faker();

    String imagePath = "Circle-icon.png";
    String[] gendersList = {"Male", "Female", "Other"};
    String[] subjectsList = {"Hindi", "English", "Maths", "Physics",
            "Chemistry", "Biology", "Computer Science", "Commerce",
            "Accounting", "Economics", "Arts", "Social Studies",
            "History", "Civics"};
    String[] hobbiesList = {"Sports", "Reading", "Music"};
    String[] statesList = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

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
    String dateOfBirth = day + " " + month + "," + year;
    String[] citiesNCR = {"Delhi", "Gurgaon", "Noida"};
    String[] citiesUttarPradesh = {"Agra", "Lucknow", "Merrut"};
    String[] citiesHaryana = {"Karnal", "Parnipat"};
    String[] citiesRajasthan = {"Jaipur", "Jaiselmer"};

    String state = getRandomItemFromArray(statesList);
    String city = "";

    public Object chooseRandomCityOfState() {
        if (state.equals("NCR")) {
            city = getRandomItemFromArray(citiesNCR);
        } else if (state.equals("Uttar Pradesh")) {
            city = getRandomItemFromArray(citiesUttarPradesh);
        } else if (state.equals("Haryana")) {
            city = getRandomItemFromArray(citiesHaryana);
        } else if (state.equals("Rajasthan")) {
            city = getRandomItemFromArray(citiesRajasthan);
        }
        return city;
    }

    public String getStateAndCity() {
        String stateAndCity = state + " " + city;
        return stateAndCity;
    }
}
