package les01SetDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainSetDriver {
    public static void main(String[] args) {

        System.out.println("Подключить chromedriver к классу");
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Ruslan\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");

        System.out.println("Открыть сайт https://www.demoblaze.com/");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");


    }
    public static void setDriver(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Ruslan\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
    }
}
