import automation.drivers.DriverSingleton;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.ShopPage;
import automation.pages.SignInPage;
import automation.utils.constantes;
import org.openqa.selenium.WebDriver;
import automation.utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) throws Exception {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty(constantes.BROWSER));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://bitheap.tech");
        CheckoutPage checkoutPage = new CheckoutPage();
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        ShopPage shopPage = new ShopPage();
        //homePage.clickRegisterButton();
        homePage.clickSignInButton();
        signInPage.logIn(frameworkProperties.getProperty("email"), frameworkProperties.getProperty("password"));
        if(homePage.getUsername().equals("Hello, ahcene")){
            System.out.println("Test Passed");
        }else
            System.out.println("Test failed");

        shopPage.clickShopButton();
        shopPage.refuserCookies();
        shopPage.refuserSite();
        shopPage.allerAutrePage();
        shopPage.ajouterProduit();

        shopPage.PasserAuPaiement();

        checkoutPage.proceedToCheckout();
        checkoutPage.billingDetails();

        checkoutPage.getTotalAmount();
        checkoutPage.placeOrder();
//        if(checkoutPage.getOrderStatus().trim().equals("Order received")) {
//            System.out.println("Test Passed");
//        }else{
//            System.out.println("Test KO");
//            }
        DriverSingleton.closeObjectInstance();

    }

    }

