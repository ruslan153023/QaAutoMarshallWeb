package les19PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static java.time.Duration.ofSeconds;

public class PageObjects {

    public static final String CART = "//a[contains(@href, 'cart')]";
    public static final String LOGIN = "//a[@id='login2']";
    public static final String SINGUP = "//a[@id='signin2']";

    public static final String PHONES = "//a[@onclick=\"byCat('phone')\"]";
    public static final String NOTEBOOKS = "//a[@onclick=\"byCat('notebook')\"]";
    public static final String MONITORS = "//a[@onclick=\"byCat('monitor')\"]";

    public static final String SONY_XPERIA_Z5 = "//a[text() = 'Sony xperia z5']";
    public static final String SONY_VAIO_I5 = "//a[text()='Sony vaio i5']";
    public static final String APPLE_MONITOR_24 = "//h4/a[@href='prod.html?idp_=10']";

    public static final String BUTTON_ADD = "//a[contains(text(),'Add')]";

    public static final String LOGIN_USER_NAME = "//input[@id='loginusername']";
    public static final String LOGIN_PASSWORD = "//input[@id='loginpassword']";
    public static final String LOGIN_BUTTON_LOGIN = "button.btn.btn-primary[onclick='logIn()']";

    public static final String SINGUP_USER_NAME = "//input[@id='sign-username']";
    public static final String SINGUP_PASSWORD = "//input[@id='sign-password']";
    public static final String SINGUP_BUTTON_SINGUP = "button.btn.btn-primary[onclick='register()']";

    private final int SECONDS = 10;

    private String baseUrl;

    public PageObjects(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static void main(String[] args) {

        PageObjects.setDriver();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(ofSeconds(10)); //ждать появления элемента 10сек
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10)); //ждать загрузки страницы 10сек

        driver.get("https://www.demoblaze.com/");

        driver.findElement(By.xpath(PageObjects.LOGIN)).click();
        driver.findElement(By.xpath(PageObjects.SINGUP)).click();

        driver.findElement(By.xpath(PageObjects.PHONES)).click();
        driver.findElement(By.xpath(PageObjects.NOTEBOOKS)).click();
        driver.findElement(By.xpath(PageObjects.MONITORS)).click();

        driver.findElement(By.xpath(PageObjects.SONY_VAIO_I5)).click();
        driver.findElement(By.xpath(PageObjects.APPLE_MONITOR_24)).click();

        driver.findElement(By.xpath(PageObjects.BUTTON_ADD)).click();


        driver.findElement(By.xpath(PageObjects.LOGIN_USER_NAME)).sendKeys();
        driver.findElement(By.xpath(PageObjects.LOGIN_PASSWORD)).sendKeys();
        driver.findElement(By.cssSelector(PageObjects.LOGIN_BUTTON_LOGIN)).click();

        driver.findElement(By.xpath(PageObjects.SINGUP_USER_NAME)).sendKeys();
        driver.findElement(By.xpath(PageObjects.SINGUP_PASSWORD)).sendKeys();
        driver.findElement(By.cssSelector(PageObjects.SINGUP_BUTTON_SINGUP)).click();

        PageObjects.mySleep();
        driver.quit();
    }

    public static void mySleep() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setDriver() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Ruslan\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
    }

    public void login(WebDriver driver, String login, String password) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SECONDS));

        driver.findElement(By.xpath(PageObjects.LOGIN)).click();
        driver.findElement(By.xpath(LOGIN_USER_NAME)).sendKeys(login);
        driver.findElement(By.xpath(LOGIN_PASSWORD)).sendKeys(password);
        driver.findElement(By.cssSelector(LOGIN_BUTTON_LOGIN)).click();

    }

    public void openWeb(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    public void addPhoneToCart(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SECONDS));
        driver.findElement(By.xpath(PageObjects.PHONES)).click();
        List<WebElement> list = driver.findElements(By.xpath("//a/img"));

        Random random = new Random();
        int r = random.nextInt(8) + 2;

        list.get(r).click();
        driver.findElement(By.xpath(PageObjects.BUTTON_ADD)).click();
        mySleep();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

    }

    public int getSECONDS() {
        return SECONDS;
    }
}
