import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import automation.pages.ShopPage;
import automation.utils.FrameworkProperties;
import automation.utils.constantes;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class shopTest {
    FrameworkProperties frameworkProperties;
    WebDriver driver ;
    loginTest loginTest;
    ShopPage shopPage;

@BeforeAll
    public void setLoginTest(){
    loginTest = new loginTest();
    loginTest.initialiseObject();
    Allure.step("Vérification si l'utilisateur est authentifié");
    loginTest.TestAuthentification();
    shopPage = new ShopPage();

}
@Description("tester l'ajout d'un produit au panier par un utilisateur authentifié")
@Test
    public void ajoutProduitPanier(){
    Allure.step("l'utilisateur refuse les cookies et les popup du site Bitheap");
    shopPage.refuserSite();
    shopPage.refuserCookies();
    Allure.step("L'utilisateur clique sur la page SHOP du site Bitheap");
    shopPage.clickShopButton();
    Allure.step("L'utilisateur scroll vers le bas et choisit une page produit");
    shopPage.allerAutrePage();
    Allure.step("L'utilisateur clique sur ajouter un produit au panier");
    shopPage.ajouterProduit();
    Allure.step("Vérification que le produit est bien ajouté au panier");

    Assert.assertTrue(shopPage.nombreDeArticles());
    Allure.step("L'utilisateur passe a l'étape du paiement");
    shopPage.PasserAuPaiement();
}
@AfterAll
    public void fermerObjet(){
    Allure.step("Aprés le test on ferme le navigateur ");
    loginTest.fermerObjet();
}


}
