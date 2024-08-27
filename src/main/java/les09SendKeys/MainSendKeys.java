package les09SendKeys;

import les01SetDriver.MainSetDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import les19PageObjects.PageObjects;

import static java.time.Duration.ofSeconds;

public class MainSendKeys {
    public static void main(String[] args) {
        MainSetDriver.setDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(ofSeconds(10)); //ждать появления элемента 10сек
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10)); //ждать загрузки страницы 10сек

        driver.get("https://www.demoblaze.com/");

        driver.findElement(By.xpath(PageObjects.LOGIN)).click();

        driver.findElement(By.xpath(PageObjects.LOGIN_USER_NAME)).sendKeys("MyLogin");
        driver.findElement(By.xpath(PageObjects.LOGIN_PASSWORD)).sendKeys("123");
        driver.findElement(By.cssSelector(PageObjects.LOGIN_BUTTON_LOGIN)).click();

    }
}
