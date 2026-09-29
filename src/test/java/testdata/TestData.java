package testdata;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    public  String fullName = faker.name().fullName();
    public  String email = faker.internet().emailAddress();
    public  String errorEmail = faker.name().name();
    public  String phone = faker.phoneNumber().subscriberNumber(11);
    public  String language = faker.options().option("English", "Русский(Russian)");
    public  String password = faker.internet().password();
    public  String passwordLength = faker.internet().password(1, 5);
    public static final  String TEXT_SUCCESSFUL_REGISTRATION_FORM = "История заказов";
    public static final  String TEXT_ERROR_REGISTRATION_FORM = "Поле не заполнено";
    public static final  String TEXT_ERROR_PASSWORD_LENGTH = "Пароль должен быть не меньше 6 символов";
    public static final  String TEXT_ERROR_MAIL = "Адрес электронной почты указан неверно";

}