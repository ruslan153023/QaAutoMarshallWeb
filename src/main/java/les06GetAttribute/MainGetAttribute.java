package les06GetAttribute;

import les01SetDriver.MainSetDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import les19PageObjects.PageObjects;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class MainGetAttribute {
    public static void main(String[] args) {

        MainSetDriver.setDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(ofSeconds(10)); //ждать появления элемента 10сек
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10)); //ждать загрузки страницы 10сек

        driver.get("https://www.demoblaze.com/"); //Открыть главную страницу

        driver.findElement(By.xpath(PageObjects.NOTEBOOKS)).click();
        driver.findElement(By.xpath(PageObjects.PHONES)).click();

        driver.findElement(By.xpath(PageObjects.SONY_XPERIA_Z5)).click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PageObjects.BUTTON_ADD))).click();

        driver.findElement(By.xpath(PageObjects.CART)).click();
        String phonePrice = driver.findElement(By.xpath("//td[text()='Sony xperia z5']/following-sibling::td[1]"))
                .getAttribute("textContent");

        System.out.println(phonePrice);

    }
}
