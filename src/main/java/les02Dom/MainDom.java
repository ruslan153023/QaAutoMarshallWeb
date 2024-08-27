package les02Dom;

import les01SetDriver.MainSetDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainDom {
    public static void main(String[] args) {

        System.out.println("Кликнуть по элементам laptops и monitors двумя способами");

        MainSetDriver.setDriver();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/");
        WebElement element = driver.findElement(By.xpath("//a[text()='Laptops']"));
        element.click();

        driver.findElement(By.xpath("//a[text()='Monitors']")).click();
    }
}
