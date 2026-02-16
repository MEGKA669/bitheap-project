package automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import automation.utils.constantes;
import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(css = "#billing_country_field span.select2-selection")
    private WebElement selectCountry;

    @FindBy(css = "input.select2-search__field")
    private WebElement inputCountry;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_city")
    private WebElement City;

    @FindBy(id ="select2-billing_state-container")
    private WebElement selectState;
    @FindBy(css = "input.select2-search__field")
    private WebElement inputState;

    @FindBy(id ="billing_postcode")
    private WebElement CodePostal;

    @FindBy(id = "billing_email")
    private WebElement emailField;

    @FindBy(css = "#order_review > table > tfoot > tr.order-total > td > strong > span > bdi")
    private WebElement totalAmount;
    @FindBy(id ="place_order")
    private WebElement placeOrder;

    @FindBy(css = "h1.entry-title")
    private WebElement orderStatus;

    @FindBy(css = "a.checkout-button[href*='checkout']")
    private WebElement Checkout;


    public void proceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(constantes.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(Checkout));
        Checkout.click();
    }
    public void billingDetails() {
    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(constantes.TIMEOUT));
    //Firstname
    wait.until(ExpectedConditions.visibilityOf(firstName));
    firstName.clear();
    firstName.sendKeys(constantes.FIRSTNAME);
    //LastName
     wait.until(ExpectedConditions.visibilityOf(lastName));
     lastName.clear();
     lastName.sendKeys(constantes.LASTNAME);
    // ===== COUNTRY =====
    wait.until(ExpectedConditions.elementToBeClickable(selectCountry)).click();
    WebElement countryInput = wait.until(ExpectedConditions.visibilityOf(inputCountry));
    countryInput.sendKeys(constantes.COUNTRY);

    WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class,'select2-results__option') and text()='" + constantes.COUNTRY + "']")));
    countryOption.click();

    // ===== ADDRESS =====
    wait.until(ExpectedConditions.visibilityOf(address));
    address.clear();
    address.sendKeys(constantes.ADDRESS);

    // ===== CITY =====
    wait.until(ExpectedConditions.visibilityOf(City));
    City.clear();
    City.sendKeys(constantes.CITY);

    // ===== STATE =====
    wait.until(ExpectedConditions.elementToBeClickable(selectState)).click();
    WebElement stateInput = wait.until(ExpectedConditions.visibilityOf(inputState));
    stateInput.sendKeys(constantes.STATE);

    WebElement stateOption = wait.until(
            ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[contains(@class,'select2-results__option') and text()='" + constantes.STATE + "']")
            )
    );
    stateOption.click();

    // ===== POSTCODE =====
    wait.until(ExpectedConditions.visibilityOf(CodePostal));
    CodePostal.clear();
    CodePostal.sendKeys(constantes.CODE_POSTAL);

    //EMAIL
    wait.until(ExpectedConditions.visibilityOf(emailField));
    emailField.clear();
    emailField.sendKeys(constantes.EMAIL_FIELD);


}


    public String getTotalAmount(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(constantes.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        return totalAmount.getText();
    }
    public void placeOrder(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(constantes.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
        try {
            placeOrder.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrder);
        }
    }
    public boolean getOrderStatus(){
    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(constantes.TIMEOUT));
    wait.until(ExpectedConditions.textToBePresentInElement(orderStatus,"Order received"));

        //return orderStatus.getText();
        return true;
    }
}
