package tests;
import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEN = new Faker(new Locale("en"));
    public static Faker fakerRandomCity = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = fakerEN.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            gender = faker.options().option("Male", "Female", "Other"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            subjects = faker.options().option("English", "Maths", "Biology"),
            picture = faker.options().option("1.png", "2.png", "3.png", "4.png"),
            yearBirth = Integer.toString(faker.number().numberBetween(1950, 2010)),
            monthBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            dayBirth = String.format("0%d", faker.number().numberBetween(1, 11)),
            currentAddress = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setRandomCity(state);

    public String setRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;
        }

    }

}