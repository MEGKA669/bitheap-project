package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements strategieConducteur{
    @Override
    public WebDriver setNavigateur() {
        //System.setProperty("webdriver.chrome.driver" , "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension",false);//ici c'est on met l'éxtension a faux
        //on l'utilise afin d'éviter certains probleme
        options.addArguments("--no-sandbox");

        return new ChromeDriver(options);
    }
}
