package les10Actions;

import les01SetDriver.MainSetDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import les19PageObjects.PageObjects;

import static java.time.Duration.ofSeconds;

public class MainActions {
    public static void main(String[] args) {

        MainSetDriver.setDriver();
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(ofSeconds(10)); //ждать появления элемента 10сек
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10)); //ждать загрузки страницы 10сек

        driver.get("https://www.demoblaze.com/");

        driver.findElement(By.xpath(PageObjects.SINGUP)).click();

        WebElement element = driver.findElement(By.xpath(PageObjects.SINGUP_USER_NAME));

        element.sendKeys("MyName");
        driver.findElement(By.xpath(PageObjects.SINGUP_PASSWORD)).sendKeys("MyPassword");

        mySleep();

        element.clear();
        driver.findElement(By.xpath(PageObjects.SINGUP_PASSWORD)).clear();

        actions.click(element).sendKeys("NewName").build().perform();

        mySleep();

        driver.quit();

    }
    public static void mySleep(){
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
