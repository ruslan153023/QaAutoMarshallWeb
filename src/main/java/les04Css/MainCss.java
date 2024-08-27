package les04Css;

import les01SetDriver.MainSetDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainCss {
    public static void main(String[] args) {
        MainSetDriver.setDriver();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com");

        driver.findElement(By.xpath("//a[@id='itemc'][2]")).click();

        System.out.println(
                "Кликнуть по логотипу с помощью css селектора id");
        driver.findElement(By.cssSelector("#nava")).click();

        driver.findElement(By.xpath("//a[@id='cartur']")).click();

        System.out.println(
                "Кликнуть по Cart с помощью css селектора class");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        driver.findElement(By.cssSelector("[onclick='showcart()']")).click();
        driver.findElement(By.cssSelector("[onclick*='ow']")).click(); // по части атрибута в середине
        driver.findElement(By.cssSelector("[onclick^='sh']")).click(); // по части атрибута в начале
        driver.findElement(By.cssSelector("[onclick$='rt()']")).click(); // по части атрибута в конце

        System.out.println(
                "Кликнуть по Phone с помощью сборного css селектора");
        driver.findElement(By.cssSelector("a#nava")).click();
        driver.findElement(By.cssSelector("a.list-group-item[onclick*='phone']")).click();
        driver.findElement(By.cssSelector("div#tbodyid.row a.hrefch[href='prod.html?idp_=1']")).click();
        driver.findElement(By.cssSelector("div.row > div.col-sm-12.col-md-6.col-lg-6")).click();
        driver.findElement(By.cssSelector("tbody > tr.success:last-child > td:last-child")).click();

        //a:not(#nava) - для примера найти ссылки без id = nava
        //tbody > tr.success:last-child > td:first-child - для примера найти первого ребенка
        //tbody > tr.success:last-child > td:ntc-child(2) - для примера найти ребенка по порядковому номеру



    }
}
