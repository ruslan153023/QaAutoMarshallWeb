package les17Dependency;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    WebDriver driver;
    int seconds = 10;
    String url = "https://www.demoblaze.com/";

    By loginTab = By.xpath("//a[@id='login2']");
    By loginInput = By.xpath("//input[@id='loginusername']");
    By passwordInput = By.xpath("//input[@id='loginpassword']");
    By loginButton = By.xpath("//button[@onclick='logIn()']");
    By phonesTab = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    By listPhones = By.xpath("//a/img");
    By addCartButton = By.xpath("//a[contains(text(),'Add')]");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void openWeb() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
        driver.get(url);
    }


    public void login(String login, String password) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.findElement(loginTab).click();
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        mySleep();

    }

    public void addPhoneToCart() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.findElement(phonesTab).click();

        List<WebElement> list = driver.findElements(listPhones);
        Random random = new Random();
        int r = random.nextInt(8) + 2;
        list.get(r).click();

        driver.findElement(addCartButton).click();
        mySleep();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        driver.quit();

    }

    void mySleep() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //как возвращать элемент
    //как создать явное ожидание
    //как подключить алюр
}
