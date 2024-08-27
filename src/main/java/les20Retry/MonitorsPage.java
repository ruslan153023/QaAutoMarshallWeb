package les20Retry;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import les19PageObjects.PageObjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$x;

public class MonitorsPage extends BasePage{
    SelenideElement monitorsTab = $x("//a[@onclick=\"byCat('monitor')\"]");
    SelenideElement tableWithMonitors = $x("//div[@id='tbodyid']");
    By cardOfMonitor = By.xpath("//div[@class='card h-100']/a");
    SelenideElement addToCartButton = $x("//a[@onclick=\"addToCart(10)\"]");

    @Step("добавить любой монитор в корзину")
    public void randomAddToCart(){

        monitorsTab.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> list = tableWithMonitors.findElements(cardOfMonitor);

        Random random = new Random();
        int r = random.nextInt(0, list.size()-1);

        list.get(r).click();
        addToCartButton.click();
        Selenide.switchTo().alert().accept();
    }
}
