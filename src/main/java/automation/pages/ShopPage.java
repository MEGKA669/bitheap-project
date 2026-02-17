package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.utils.Utils;
import automation.utils.constantes;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class ShopPage {
    private WebDriver driver;

    public ShopPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }



    //@FindBy(css = "#main > ul > li.product.type-product.post-1040.status-publish.first.instock.product_cat-ebook.has-post-thumbnail.sale.downloadable.virtual.purchasable.product-type-simple > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart")
    @FindBy(css = "#main > ul > li.product.type-product.post-211.status-publish.instock.product_cat-uncategorized.purchasable.product-type-simple > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart")
    private WebElement ajoutProduit;

    @FindBy(css = "span.wb4wp-wc-cart-item-count")
    private WebElement nombreArticle;

    @FindBy(css = "a[href*='cart']") //a[href='/cart']     /* Exact match */
    private WebElement goToPanier; //a[href*='cart']     /* Contient 'cart' */

    @FindBy(css = "a.page-numbers[href*='page/2']")
    private WebElement PageDeux;

    @FindBy(css = "body > div.cky-consent-container.cky-box-bottom-left > div > div > div > div.cky-notice-btn-wrapper > button.cky-btn.cky-btn-reject")
    private WebElement refuserCookies;
    @FindBy(css = "#menu-item-1310 > a")
    private WebElement ShopButton;

    public WebElement getRefuserSite() {
        return refuserSite;
    }

    @FindBy(css = "body > p > a.woocommerce-store-notice__dismiss-link")
    private WebElement refuserSite;

    public void refuserCookies(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(constantes.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(refuserCookies));
        refuserCookies.click();
    }
    public void refuserSite(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(constantes.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(refuserSite));
        refuserSite.click();
    }
    public void clickShopButton(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ShopButton));
        ShopButton.click();
    }

    public void allerAutrePage(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", PageDeux);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(constantes.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(PageDeux));
        PageDeux.click();
    }
    public void ajouterProduit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(constantes.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(ajoutProduit));
        ajoutProduit.click();
        wait.until(ExpectedConditions.visibilityOf(nombreArticle));
        //wait.until(ExpectedConditions.textToBePresentInElement(nombreArticle, constantes.PANIER_QUANTITE));
        if (nombreArticle.isDisplayed()) {
            System.out.println("Panier mis a jour avec un produit :" + nombreArticle.getText() + " articles");
        } else {
            System.out.println("PANIER non mis a jour");
            //byte[] screenshot = Utils.screenShot();
            //Allurttachment("Erreur -- panier non mis a jour", new ByteArrayInputStream(screenshot));
        }
    }
    public boolean nombreDeArticles(){
        if(nombreArticle.isDisplayed()){
            return true;
        }
        return false;
    }
//Probleme avec cette méthode je passe pas au panier
     public void PasserAuPaiement(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(constantes.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(goToPanier));
        goToPanier.click();
     }

     public void arreterTest(){
        if (DriverSingleton.getDriver()!= null){
            DriverSingleton.getDriver().quit();
        }
     }





}
