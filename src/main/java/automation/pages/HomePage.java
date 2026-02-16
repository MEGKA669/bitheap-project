package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    public HomePage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#menu-item-2331 > a")
    private WebElement RegisterButton;

    @FindBy(css = "#menu-item-2330 > a")
    private WebElement LoginButton;


    @FindBy(id = "menu-item-2333")
    private WebElement username;

    public void clickRegisterButton(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(RegisterButton));
        RegisterButton.click();
    }
    public void clickSignInButton(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
        LoginButton.click();
    }

    public String getUsername(){
        return username.getText();
    }



}
