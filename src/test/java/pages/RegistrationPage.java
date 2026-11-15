package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {

    private final SelenideElement nameInput = $("#client_contact_name");
    private final SelenideElement phoneInput = $("#client_phone");
    private final SelenideElement emailInput = $("#client_email");
    private final SelenideElement languageInput = $("#client_language_id");
    private final SelenideElement passwordInput = $("#client_password");
    private final SelenideElement passwordConfirmationInput = $("#client_password_confirmation");
    private final SelenideElement checkboxPersonalData = $(".co-input--consent_to_personal_data");
    private final SelenideElement submitButton = $(".js-co-login-submit");
    private final SelenideElement registrationWindow = $("#new_client");
    private final SelenideElement errorField = $(".co-notice--danger");
    private final SelenideElement errorMessage = $(".co-notice--danger.co-notice--flash");


    @Step("Открытие страницы регистрации /client_account/contacts/new")
    public RegistrationPage openPage() {
        open("/client_account/contacts/new");
        return this;
    }

    @Step("Ввод имени \"{value}\"")
    public RegistrationPage typeName(String value) {
        nameInput.setValue(value);
        return this;
    }

    @Step("Ввод номера телефона \"{value}\"")
    public RegistrationPage typePhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    @Step("Ввод email \"{value}\"")
    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Выбор языка \"{value}\"")
    public RegistrationPage typeLanguage(String value) {
        languageInput.$(byText(value)).click();
        return this;
    }

    @Step("Ввод пароля \"{value}\"")
    public RegistrationPage typePassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Повторный ввод пароля \"{value}\"")
    public RegistrationPage typePasswordConfirmation(String value) {
        passwordConfirmationInput.setValue(value);
        return this;
    }

    @Step("Согласие с правилами")
    public RegistrationPage typePersonalData() {
        checkboxPersonalData.click();
        return this;
    }

    @Step("Нажатие кнопки регистрации ")
    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    @Step("Окно регистрации НЕ отображается")
    public RegistrationPage notVisibleRegistrationWindow() {
        registrationWindow.shouldNotBe(visible);
        return this;
    }

    @Step("Окно регистрации отображается")
    public RegistrationPage visibleRegistrationWindow() {
        registrationWindow.shouldBe(visible);
        return this;
    }

    @Step("Вывод ошибки регистрации с текстом \"{value}\"")
    public RegistrationPage chekErrorField(String value) {
        errorField.shouldHave(text(value));
        return this;
    }

    @Step("Проверка ошибки обязательного поля имени")
    public RegistrationPage checkNameRequired(String value) {
        nameInput.closest(".co-input").$(".co-notice--danger")
                .shouldBe(visible).shouldHave(text(value));
        return this;
    }

    @Step("Проверка ошибки обязательного поля телефона")
    public RegistrationPage checkPhoneRequired(String value) {
        phoneInput.closest(".co-input").$(".co-notice--danger")
                .shouldBe(visible).shouldHave(text(value));
        return this;
    }

    @Step("Вывод ошибки пустого чекбокса \"{value}\"")
    public RegistrationPage chekErrorCheckbox(String value) {
        checkboxPersonalData.shouldHave(text(value));
        return this;
    }

    @Step("Вывод ошибки короткого пароля \"{value}\"")
    public RegistrationPage chekErrorPasswordLength(String value) {
        errorMessage.shouldHave(text(value));
        return this;
    }

    @Step("Вывод ошибки невалидного Email \"{value}\"")
    public RegistrationPage chekErrorInvalidMail(String value) {
        errorMessage.shouldHave(text(value));
        return this;
    }
}