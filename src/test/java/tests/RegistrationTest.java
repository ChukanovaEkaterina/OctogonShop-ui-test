package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdata.TestData;


public class RegistrationTest extends TestBase {

    TestData testData = new TestData();

    @Test
    @DisplayName("Регистрация со всеми заполненными полями валидными данными")
    void successfulRegistrationTest() {
            registrationTestPage
                    .openPage()
                    .typeName(testData.fullName)
                    .typePhone(testData.phone)
                    .typeEmail(testData.email)
                    .typeLanguage(testData.language)
                    .typePassword(testData.password)
                    .typePasswordConfirmation(testData.password)
                    .typePersonalData()
                    .submit()
                    .chekOrderHistory(testData.TEXT_SUCCESSFUL_REGISTRATION_FORM)
                    .notVisibleRegistrationWindow();
        }

    @Test
    @DisplayName("Отправка пустой формы регистрации")
    void allInputFieldsEmptyTest() {
            registrationTestPage
                    .openPage()
                    .submit()
                    .visibleRegistrationWindow()
                    .chekErrorField(testData.TEXT_ERROR_REGISTRATION_FORM);
        }

    @Test
    @DisplayName("Отправка формы регистрации c пустым Checkbox")
    void checkboxNotChecked() {
            registrationTestPage
                    .openPage()
                    .typeName(testData.fullName)
                    .typePhone(testData.phone)
                    .typeEmail(testData.email)
                    .typeLanguage(testData.language)
                    .typePassword(testData.password)
                    .typePasswordConfirmation(testData.password)
                    .submit()
                    .chekErrorCheckbox(testData.TEXT_ERROR_REGISTRATION_FORM);
        }

    @Test
    @DisplayName("Отправка формы регистрации с коротким паролем")
    void shortPasswordRegistration() {
            registrationTestPage
                    .openPage()
                    .typeName(testData.fullName)
                    .typePhone(testData.phone)
                    .typeEmail(testData.email)
                    .typeLanguage(testData.language)
                    .typePassword(testData.passwordLength)
                    .typePasswordConfirmation(testData.passwordLength)
                    .typePersonalData()
                    .submit()
                    .chekErrorPasswordLength(testData.TEXT_ERROR_PASSWORD_LENGTH);
        }

    @Test
    @DisplayName("Отправка формы регистрации с невалидным Mail")
    void invalidPasswordRegistration() {
            registrationTestPage
                    .openPage()
                    .typeName(testData.fullName)
                    .typePhone(testData.phone)
                    .typeEmail(testData.errorEmail)
                    .typeLanguage(testData.language)
                    .typePassword(testData.password)
                    .typePasswordConfirmation(testData.password)
                    .typePersonalData()
                    .submit()
                    .chekErrorInvalidMail(testData.TEXT_ERROR_MAIL);
        }
}
