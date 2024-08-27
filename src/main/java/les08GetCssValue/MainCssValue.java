package les08GetCssValue;

import les01SetDriver.MainSetDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import les19PageObjects.PageObjects;

import static java.time.Duration.ofSeconds;

public class MainCssValue {
    public static void main(String[] args) {

        MainSetDriver.setDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(ofSeconds(10)); //ждать появления элемента 10сек
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10)); //ждать загрузки страницы 10сек

        driver.get("https://www.demoblaze.com/");

        driver.findElement(By.xpath(PageObjects.MONITORS)).click();
        driver.findElement(By.xpath(PageObjects.APPLE_MONITOR_24)).click();

        String cssValue = driver.findElement(By.xpath("//div[@class='tab-pane fade active in']/p"))
                .getCssValue("margin-top");

        System.out.println(cssValue);
    }
}
