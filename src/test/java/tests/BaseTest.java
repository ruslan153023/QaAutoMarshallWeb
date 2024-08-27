package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import les20Retry.BasePage;
import les20Retry.CartPage;
import les20Retry.LoginPage;
import les20Retry.MonitorsPage;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    MonitorsPage monitorsPage = new MonitorsPage();
    CartPage cartPage = new CartPage();

    @BeforeTest
    public void setup() {
        SelenideLogger.addListener("", new AllureSelenide().screenshots(true));
        open("https://www.demoblaze.com/");
    }

}
