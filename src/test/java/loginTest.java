import automation.drivers.DriverSingleton;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import automation.pages.HomePage;
import automation.pages.SignInPage;
import automation.utils.FrameworkProperties;
import automation.utils.constantes;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class loginTest {
        FrameworkProperties frameworkProperties;
        WebDriver driver;
        HomePage homePage;
        SignInPage signInPage;

@BeforeAll
public void initialiseObject(){
    frameworkProperties = new FrameworkProperties();
    DriverSingleton.getInstance(frameworkProperties.getProperty(constantes.BROWSER));
    driver = DriverSingleton.getDriver();
    homePage = new HomePage();
    signInPage = new SignInPage();
}
@Description("Verification que l'utilisateur peut se connecter sur le Site Bitheap")
@Test
    public void TestAuthentification(){
    Allure.step("L'utilisateur arrive sur le site Bitheap");
    driver.get(constantes.URL);
    Allure.step("L'utilisateur arrive sur la page de connexion");
    homePage.clickSignInButton();
    Allure.step("L'utilisateur renseigne son Email et mot de passe");
    signInPage.logIn(frameworkProperties.getProperty(constantes.EMAIL) , frameworkProperties.getProperty(constantes.PASSWORD));
    Allure.step("L'utilisateur clique sur le bouton se connecter  ");
    signInPage.clickLoginButton();
    Allure.step("Vérification que l'utilisateur est bien connecté");
    assertEquals(frameworkProperties.getProperty(constantes.USERNAME) , homePage.getUsername());
    }

//@AfterAll
public void fermerObjet(){
driver.quit();
    }

}
