package les12Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import les19PageObjects.PageObjects;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class MainAlert {
    public static void main(String[] args) {

        PageObjects.setDriver();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(ofSeconds(10)); //ждать появления элемента 10сек
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10)); //ждать загрузки страницы 10сек

        driver.get("https://www.demoblaze.com/");

        driver.findElement(By.xpath(PageObjects.NOTEBOOKS)).click();
        driver.findElement(By.xpath(PageObjects.SONY_VAIO_I5)).click();
        driver.findElement(By.xpath(PageObjects.BUTTON_ADD)).click();

        PageObjects.mySleep();

        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        driver.findElement(By.xpath(PageObjects.BUTTON_ADD)).click();
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        alert2.accept();

        PageObjects.mySleep();
        driver.quit();

    }
}
