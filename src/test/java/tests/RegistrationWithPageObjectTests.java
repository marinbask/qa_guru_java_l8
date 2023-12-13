package tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;
import static io.qameta.allure.Allure.step;

public class RegistrationWithPageObjectTests extends TestBase{

    StudentRegistrationPage registrationPage = new StudentRegistrationPage();

    @Test



    @DisplayName("�������� ����� �� ���� ���� �����")
    @Tag("WEB")
    void checkFormRegistrationTest() {
        step("��������� ��������", () -> {
                registrationPage.openPage();
            });
            step("��������� ��� ����", () -> {
                registrationPage
                        .closeAd()
                        .setFirstName("Marina")
                        .setLastName("Baskova")
                        .setEmail("testqagurujava@test.com")
                        .setGender("Female")
                        .setUserNumber("1234567890")
                        .setDateOfBirth("14", "June", "1989")
                        .setSubjectsInput("English")
                        .setHobbiesCheckbox("Sports")
                        .loadPictureInput("1.png")
                        .setCurrentAddress("Russia.Moscow")
                        .setState("Haryana")
                        .setCity("Karnal")
                        .setClickButton()
                        .tableVisible();
            });
    step("��������� ������������ ����������� �����", () -> {
            registrationPage
                .resultCheck("Student Name", "Marina Baskova")
                .resultCheck("Student Email", "testqagurujava@test.com")
                .resultCheck("Gender", "Female")
                .resultCheck("Mobile", "123456789")
                .resultCheck("Date of Birth", "14 June,1989")
                .resultCheck("Subjects", "English")
                .resultCheck("Hobbies", "Sports")
                .resultCheck("Picture", "1.png")
                .resultCheck("Address", "Russia.Moscow")
                .resultCheck("State and City", "Haryana Karnal");

    });


        void checkFormRegistrationRequiredFieldsTest() {
             step("��������� ��������", () -> {
                     registrationPage.openPage();
        });

        step("��������� �������", () -> {

        registrationPage.closeAd();
        registrationPage.setFirstName("Marina")
                .setLastName("Baskova")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setSubjectsInput("English")
                .setHobbiesCheckbox("Sports")
                .setCurrentAddress("Russia.Moscow")
                .setClickButton()
                .tableVisible();
        });

        step("��������� ������������ ����������� �����", () -> {
            registrationPage.tableVisible();
        });
            registrationPage
                .resultCheck("Student Name", "Marina Baskova")
                .resultCheck("Gender", "Female")
                .resultCheck("Mobile", "123456789")
                .resultCheck("Subjects", "English")
                .resultCheck("Hobbies", "Sports")
                .resultCheck("Address", "Russia.Moscow");
    }

    @Test
    @DisplayName("�������� �������� ������ �����")
    @Tag("WEB")
        void checkFormRegistrationEmptyFieldsTest() {

            step("��������� ��������", () -> {
                registrationPage.openPage();
            });

            step("��������� �������", () -> {

                registrationPage.closeAd();
            });

            step("��������� ��� ���� ������, �������� ������ submit", () -> {

                registrationPage.setClickButton()
                        .tableHidden();
            });
        }
    }