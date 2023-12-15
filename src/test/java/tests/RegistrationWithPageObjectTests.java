package tests;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты на заполнение DemoQA Registration Form")
@Tag("all-tests")
public class RegistrationWithPageObjectTests extends TestBase{

    StudentRegistrationPage registrationPage = new StudentRegistrationPage();

    @Test
    @Feature("Заполнение формы")
    @Owner("BaskovaM")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка формы на ввод всех полей")
    @Tag("positive")
    void checkFormRegistrationTest() {
        step("Открываем страницу", () -> {
            registrationPage.openPage();
        });
        step("Заполняем все поля", () -> {
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
        step("Проверяем корректность заполненных полей", () -> {
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
    }
    @Test
    @Feature("Обязательные поля")
    @Owner("BaskovaM")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка формы на ввод обязательных полей")
    @Tag("positive")
    void checkFormRegistrationRequiredFieldsTest() {
             step("Открываем страницу", () -> {
                     registrationPage.openPage();
        });

        step("Закрываем рекламу", () -> {

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

        step("Проверяем корректность заполненных полей", () -> {
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
    @Feature("Пустая форма")
    @Owner("BaskovaM")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка отправки пустой формы")
    @Tag("negative")
        void checkFormRegistrationEmptyFieldsTest() {

            step("Открываем страницу", () -> {
                registrationPage.openPage();
            });

            step("Закрываем рекламу", () -> {

                registrationPage.closeAd();
            });

            step("Проверяем что фома пустая, нажатием кнопки submit", () -> {

                registrationPage.setClickButton()
                        .tableHidden();
            });
        }
    }