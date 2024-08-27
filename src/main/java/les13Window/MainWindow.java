package les13Window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import les19PageObjects.PageObjects;

import java.util.Set;

import static java.time.Duration.ofSeconds;

public class MainWindow {
    public static void main(String[] args) {

        PageObjects.setDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(ofSeconds(10)); //ждать появления элемента 10сек
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10)); //ждать загрузки страницы 10сек

        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://www.demoblaze.com/");
        PageObjects.mySleep();

        String window1 = driver.getWindowHandle();
        js.executeScript("window.open()");

        Set<String> currentWindows = driver.getWindowHandles();

        String window2 = null;

        for (String current: currentWindows){
            if(!current.equals(window1)){
                window2 = current;
                break;
            }
        }

        driver.switchTo().window(window2);
        driver.get("https://mail.ru/");

        driver.close();
        driver.switchTo().window(window1);

        driver.findElement(By.xpath(PageObjects.NOTEBOOKS)).click();
        js.executeScript("document.querySelector('#navbarExample').setAttribute('style', 'display:none')");
        PageObjects.mySleep();
        PageObjects.mySleep();
        driver.quit();
        
    }
}
