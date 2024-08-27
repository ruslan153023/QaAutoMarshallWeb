package les03Xpath;

import les01SetDriver.MainSetDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainXpath {
    public static void main(String[] args) {
        MainSetDriver.setDriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");

        System.out.println(
                "Кликнуть по категории Laptop с помощью xpath атрибута," +
                        "Кликнуть по категории Phone с помощью xpath атрибута" +
                        "Кликнуть по категории Monitors с помощью xpath атрибута"
        );
        driver.findElement(By.xpath("//a[@onclick=\"byCat('notebook')\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"list-group-item\"][last()]")).click();
        driver.findElement(By.xpath("//a[@id='itemc'][1]")).click();


        System.out.println(
                "Кликнуть по телефону с помощью xpath текста" +
                        "Добавить телефон в корзину с помощью xpath части текста");
        driver.findElement(By.xpath("//a[text() = 'Sony xperia z5']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add')]")).click();


        System.out.println(
                "Кликнуть на корзину с помощью xpath части атрибута");
        driver.findElement(By.xpath("//a[contains(@href, 'cart')]")).click();

        System.out.println(
                "Кликнуть удалить с помощью xpath вложенных элементов");
        driver.findElement(By.xpath("//div[@class='table-responsive']//td/a[@onclick]")).click();

        System.out.println(
                "Кликнуть на логотип с помощью xpath подьем к родителю");
        driver.findElement(By.xpath("//a[@data-target='#exampleModal']/../../../../a")).click();
        driver.findElement(By.xpath("//a[@data-target='#exampleModal']/parent::li/parent::ul/parent::div/parent::nav/a")).click();

        System.out.println(
                "Кликнуть на логотип с помощью xpath переход к соседу");
        driver.findElement(By.xpath("//a[@data-target='#exampleModal']/../following-sibling::li/a[1]")).click();





    }
}
