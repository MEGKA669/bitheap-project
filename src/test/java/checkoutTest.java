import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import automation.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class checkoutTest {
        shopTest shopTest;
        CheckoutPage checkoutPage;
//        WebDriver driver;
@BeforeAll
    public void initialiseAndajoutProduit(){

            shopTest = new shopTest();
            shopTest.setLoginTest();
            shopTest.ajoutProduitPanier();
            checkoutPage = new CheckoutPage();
}
@Test
    public void checkoutTest(){
        checkoutPage.proceedToCheckout();
        checkoutPage.billingDetails();
        checkoutPage.getTotalAmount();
        checkoutPage.placeOrder();
        assertTrue(checkoutPage.getOrderStatus());
}

@AfterAll
    public void fermerObjet(){
    shopTest.fermerObjet();
}

}
