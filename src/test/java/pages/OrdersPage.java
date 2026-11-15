package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class OrdersPage {

    private final SelenideElement orderHistoryTitle = $(".co-checkout-title");

    @Step("Проверка перехода на страницу заказов после регистрации")
    public OrdersPage checkOpenedAfterRegistration() {
        webdriver().shouldHave(urlContaining("/client_account/orders?auth_triggered=sign_up"));
        return this;
    }

    @Step("Проверка заголовка истории заказов: {value}")
    public OrdersPage checkOrderHistory(String value) {
        orderHistoryTitle.shouldBe(visible).shouldHave(text(value));
        return this;
    }
}
