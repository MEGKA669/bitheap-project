import automation.drivers.DriverSingleton;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.ShopPage;
import automation.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import automation.utils.FrameworkProperties;
import automation.utils.constantes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // si j'enleve ca je dois mettre en static mes Tests
public class Tests {
         FrameworkProperties frameworkProperties;
         WebDriver driver;
         HomePage homePage;
         SignInPage signInPage;
         ShopPage shopPage;
         CheckoutPage checkoutPage;

        @BeforeAll
        public void initializeObjects(){
                frameworkProperties = new FrameworkProperties();
                DriverSingleton.getInstance(frameworkProperties.getProperty(constantes.BROWSER));
                driver = DriverSingleton.getDriver();
                homePage = new HomePage();
                signInPage = new SignInPage();
                checkoutPage = new CheckoutPage();
                shopPage = new ShopPage();
        }
//        @ParameterizedTest
//        @CsvSource({
//                "megkagaming@gmail.com,TWFpc29uMTAr" ,
//                "ahceneaitidir43@gmail.com,Azerty2026+"
//        })
//        public void testingParameterizedTest(String username , String password){
//                driver.get(constantes.URL);
//                homePage.clickSignInButton();
//                signInPage.logIn(username , password);
//                assertTrue(homePage.getUsername().contains("Hello"));
//
//        }


        @Test
        @Order(1)
        public void testAuthentification(){
                driver.get(constantes.URL);
                homePage.clickSignInButton();
                signInPage.logIn(frameworkProperties.getProperty(constantes.EMAIL),frameworkProperties.getProperty(constantes.PASSWORD));
                signInPage.clickLoginButton();
                assertEquals(frameworkProperties.getProperty(constantes.USERNAME), homePage.getUsername());
        }
       // @Test
        public void testAjoutProduit(){
                driver.get(constantes.URL);
                shopPage.clickShopButton();
                shopPage.refuserCookies();
                shopPage.refuserSite();
                shopPage.allerAutrePage();
                shopPage.ajouterProduit();
                assertEquals(constantes.PANIER_QUANTITE , shopPage.nombreDeArticles());
        }
        @Test
        @Order(2)
        public void testPaiementEtCheckout(){
                driver.get(constantes.URL);
                shopPage.clickShopButton();
                shopPage.refuserCookies();
                shopPage.refuserSite();
                shopPage.allerAutrePage();
                if(shopPage.getRefuserSite().isDisplayed()){
                        shopPage.refuserSite();
                }
                shopPage.ajouterProduit();
                shopPage.PasserAuPaiement();
                checkoutPage.proceedToCheckout();
                checkoutPage.billingDetails();
                checkoutPage.getTotalAmount();
                checkoutPage.placeOrder();
                assertTrue(checkoutPage.getOrderStatus());

                //assertThat("Test" , is("Test"));
              //  assertEquals(constantes.ORDER_RECEIVED , checkoutPage.getOrderStatus());
        }


         //@AfterAll
        public void fermerDriver(){
                DriverSingleton.closeObjectInstance();
         }


}
