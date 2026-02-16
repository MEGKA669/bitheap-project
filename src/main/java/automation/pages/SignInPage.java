package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.utils.Utils;
import automation.utils.constantes;

import java.time.Duration;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > div.xoo-el-fields-cont > div.xoo-aff-group.xoo-aff-cont-text.one.xoo-aff-cont-required.xoo-el-username_cont > div > input")
    private WebElement signInEmail;

    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > div.xoo-el-fields-cont > div.xoo-aff-group.xoo-aff-cont-password.one.xoo-aff-cont-required.xoo-el-password_cont > div > input")
    private WebElement password;

    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > button")
    private WebElement signInButton;

    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > div > div.xoo-aff-group.xoo-aff-cont-email.one.xoo-aff-cont-required.xoo_el_reg_email_cont > div > input")
    private WebElement signUpEmail;
    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > div > div.xoo-aff-group.xoo-aff-cont-text.onehalf.xoo-aff-cont-required.xoo_el_reg_fname_cont > div > input")
    private WebElement firstName;
    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > div > div.xoo-aff-group.xoo-aff-cont-text.onehalf.xoo-aff-cont-required.xoo_el_reg_lname_cont > div > input")
    private WebElement lastName;
    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > div > div.xoo-aff-group.xoo-aff-cont-password.one.xoo-aff-cont-required.xoo_el_reg_pass_cont > div > input")
    private WebElement passwordfield;
    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > div > div.xoo-aff-group.xoo-aff-cont-password.one.xoo-aff-cont-required.xoo_el_reg_pass_again_cont > div > input")
    private WebElement passwordfieldConfirm;
    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > div > div.xoo-aff-group.xoo-aff-cont-checkbox_single.one.xoo-aff-cont-required.xoo_el_reg_terms_cont > div > label > input")
    private WebElement AcceptTerm;
    @FindBy(css = "body > div.xoo-el-container.xoo-el-style-popup.xoo-el-popup-active > div.xoo-el-modal > div > div > div.xoo-el-srcont > div > div > div.xoo-el-section.xoo-el-active > div > form > button")
    private WebElement buttonSignUp;

    public void logIn(String email , String password){
        signInEmail.sendKeys(email);
        this.password.sendKeys(Utils.decode64(password));
    }
    public void clickLoginButton(){
        signInButton.click();
    }
    public void signUp(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(constantes.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(signUpEmail));
        signUpEmail.sendKeys(constantes.SIGNUP_EMAIL);

        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(constantes.SIGNUP_FIRSTNAME);

        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys(constantes.SIGNUP_LASTNAME);


        wait.until(ExpectedConditions.visibilityOf(passwordfield));
        passwordfield.sendKeys(constantes.SIGNUP_PASSWORD);

        wait.until(ExpectedConditions.visibilityOf(passwordfieldConfirm));
        passwordfieldConfirm.sendKeys(constantes.SIGNUP_PASSWORDCONFIRM);

        wait.until(ExpectedConditions.visibilityOf(AcceptTerm));
        AcceptTerm.click();

        wait.until(ExpectedConditions.visibilityOf(buttonSignUp));
        buttonSignUp.click();
    }
}
