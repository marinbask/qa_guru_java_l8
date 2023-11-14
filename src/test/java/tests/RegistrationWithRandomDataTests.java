package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

public class RegistrationWithRandomDataTests extends TestBase {
    StudentRegistrationPage registrationPage = new StudentRegistrationPage();
    TestData testData = new TestData();

    @Test
    //Проверка на ввод всех полей
    void checkFormRegistrationTest() {


        registrationPage.openPage()
                .closeAd()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayBirth, testData.monthBirth, testData.yearBirth)
                .setSubjectsInput(testData.subjects)
                .setHobbiesCheckbox(testData.hobbies)
                .loadPictureInput(testData.picture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .setClickButton()
                .tableVisible()
                .resultCheck("Student Name", testData.firstName + " " + testData.lastName)
                .resultCheck("Student Email", testData.userEmail)
                .resultCheck("Gender", testData.gender)
                .resultCheck("Mobile", testData.userNumber)
                .resultCheck("Date of Birth", testData.dayBirth+ " " +testData.monthBirth+ "," +testData.yearBirth)
                .resultCheck("Subjects", testData.subjects)
                .resultCheck("Hobbies", testData.hobbies)
                .resultCheck("Picture", testData.picture)
                .resultCheck("Address", testData.currentAddress)
                .resultCheck("State and City", testData.state + " " + testData.city);

    }

    @Test
    //Проверка на ввод обязательных полей
    void checkFormRegistrationRequiredFieldsTest() {

        registrationPage.openPage()
                .closeAd()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setSubjectsInput(testData.subjects)
                .setHobbiesCheckbox(testData.hobbies)
                .setCurrentAddress(testData.currentAddress)
                .setClickButton()
                .tableVisible()
                .resultCheck("Student Name", testData.firstName + " " + testData.lastName)
                .resultCheck("Gender", testData.gender)
                .resultCheck("Mobile", testData.userNumber)
                .resultCheck("Subjects", testData.subjects)
                .resultCheck("Hobbies", testData.hobbies)
                .resultCheck("Address", testData.currentAddress);

    }

    @Test
    //Проверка отправки пустой формы
    void checkFormRegistrationEmptyFieldsTest() {
        registrationPage.openPage()
                .closeAd()
                .setClickButton()
                .tableHidden();

    }

}