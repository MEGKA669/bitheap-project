package automation.colle;

import automation.config.RunFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.ShopPage;
import automation.pages.SignInPage;
import automation.utils.FrameworkConfiguration;
import automation.utils.constantes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import io.cucumber.spring.CucumberContextConfiguration ;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@CucumberContextConfiguration
@ContextConfiguration(classes = RunFrameworkConfiguration.class)
public class StepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private CheckoutPage checkoutPage;
    private ShopPage shopPage;

@Autowired
    FrameworkConfiguration frameworkConfiguration;

@Before
    public void initializeObject(){
    DriverSingleton.getInstance(frameworkConfiguration.getBrowser());
    driver = DriverSingleton.getDriver();
    homePage = new HomePage();
    signInPage = new SignInPage();
    checkoutPage = new CheckoutPage();
    shopPage = new ShopPage();
}
@Given("^utilisateur doit se trouver sur le site Bitheap")
public void utilisateur_doit_se_trouver_sur_le_site_Bitheap(){
    driver.get(constantes.URL);
}
@When("utilisateur clique sur le bouton login \\(sur la page d'accueil)")
    public void utilisateur_clique_sur_le_bouton_login_sur_la_page_d_accueil(){
    homePage.clickSignInButton();
}
@And("^utilisateur saisit le username et le mot de passe")
    public void utilisateur_saisit_le_username_et_le_mot_de_passe(){
    signInPage.logIn(frameworkConfiguration.getEmail() , frameworkConfiguration.getPassword());
    }
@And("utilisateur clique sur le bouton login \\(sur la page de connexion)")
    public void utilisateur_clique_sur_le_bouton_login_sur_la_page_de_connexion(){
    signInPage.clickLoginButton();
}
@Then("^utilisateur est connecté sur le site")
    public void utilisateur_est_connecte_sur_le_site(){
    System.out.println(frameworkConfiguration.getLoginUsername());
    assertEquals(frameworkConfiguration.getLoginUsername() , homePage.getUsername());
}

@When("utilisateur clique sur le bouton shop")
    public void utilisateur_clique_sur_le_bouton_shop(){
    shopPage.refuserSite();
    shopPage.refuserCookies();
    shopPage.clickShopButton();
}
@And("utilisateur ajoute un produit dans le panier")
    public void utilisateur_ajoute_un_produit_dans_le_panier(){
    shopPage.allerAutrePage();
    shopPage.ajouterProduit();
}
@Then("le panier est mis a jour avec le nouveau article")
    public void le_panier_est_mis_a_jour_avec_le_nouveau_article(){
    assertTrue(shopPage.nombreDeArticles());
    shopPage.PasserAuPaiement();
    shopPage.arreterTest();
}



}
