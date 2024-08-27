package les20Retry;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage{
    public SelenideElement loginTab = $x("//a[@id='login2']");
    public SelenideElement loginInput = $x("//input[@id='loginusername']");
    public SelenideElement passwordInput = $x("//input[@id='loginpassword']");
    public SelenideElement loginButton = $x("//button[@onclick='logIn()']");
    public SelenideElement nameUserTab = $x("//a[@id='nameofuser']");

    @Step("авторизация")
    public void login(String login, String password){
        loginTab.click();
        loginInput.shouldBe(Condition.visible).setValue(login);
        passwordInput.setValue(password);
        loginButton.click();
        nameUserTab.shouldHave(Condition.exactText("Welcome " + login));
    }
}
