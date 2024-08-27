package tests;

import les20Retry.Retry;
import org.testng.annotations.Test;

public class MonitorsCartOrderTest extends BaseTest{


    @Test (retryAnalyzer = Retry.class)
    public void monitorsCartOrder(){
        loginPage.login("admin", "admin");
        monitorsPage.randomAddToCart();
        cartPage.placeOrder("Rustam", "Russia", "Ivanovo", "1234", "January", "1987");
    }




}
