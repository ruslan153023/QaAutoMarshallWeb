package les20Retry;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage extends BasePage {
    SelenideElement cartTab = $x("//a[@id='cartur']");
    SelenideElement placeOrderButton = $x("//button[@class='btn btn-success']");
    SelenideElement inputName = $x("//input[@id='name']");
    SelenideElement inputCountry = $x("//input[@id='country']");
    SelenideElement inputCity = $x("//input[@id='city']");
    SelenideElement inputCard = $x("//input[@id='card']");
    SelenideElement inputMonth = $x("//input[@id='month']");
    SelenideElement inputYear = $x("//input[@id='year']");
    SelenideElement purchaseOrderButton = $x("//button[@onclick='purchaseOrder()']");
    SelenideElement orderInfoAlert = $x("//p[@class='lead text-muted ']");
    SelenideElement okButton = $x("//button[@class='confirm btn btn-lg btn-primary']");
    SelenideElement logo = $x("//a[@class='navbar-brand']");

    int s = 10;

    @Step("заполнить форму заказа")
    public void placeOrder(String name, String country, String city, String card, String month, String year){
        cartTab.click();
        placeOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(s)).click();
        inputName
                .shouldBe(Condition.visible, Duration.ofSeconds(s))
                .setValue(name)
                .shouldHave(Condition.exactValue(name));
        inputCountry
                .setValue(country)
                .shouldHave(Condition.exactValue(country));
        inputCity
                .setValue(city)
                .shouldHave(Condition.exactValue(city));
        inputCard
                .setValue(card)
                .shouldHave(Condition.exactValue(card));
        inputMonth
                .setValue(month)
                .shouldHave(Condition.exactValue(month));
        inputYear
                .setValue(year)
                .shouldHave(Condition.exactValue(year));
        purchaseOrderButton.click();
        orderInfoAlert.shouldBe(Condition.visible, Duration.ofSeconds(s));
        okButton.click();
        logo.shouldBe(Condition.visible, Duration.ofSeconds(s));

    }

}
