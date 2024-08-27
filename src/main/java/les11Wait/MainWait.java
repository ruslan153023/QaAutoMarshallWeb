package les11Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import les19PageObjects.PageObjects;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class MainWait {
    public static void main(String[] args) {
        
        PageObjects.setDriver();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.manage().timeouts().implicitlyWait(ofSeconds(10)); //ждать появления элемента 10сек
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10)); //ждать загрузки страницы 10сек

        driver.get("https://www.demoblaze.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> categories = driver.findElements(By.xpath("//a[@id='itemc']"));

        categories.get(1).click();
        categories.get(2).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PageObjects.APPLE_MONITOR_24))).click();
        js.executeScript("document.querySelector('#navbarExample').setAttribute('style', 'display:none')");
        PageObjects.mySleep();
        driver.quit();

    }
}
