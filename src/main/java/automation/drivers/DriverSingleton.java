package automation.drivers;

import automation.drivers.strategies.executantstrategieConducteur;
import automation.drivers.strategies.strategieConducteur;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton(String driver){
        instancier(driver);
    }


    private static WebDriver instancier(String strategie){
        strategieConducteur strategieConducteur = executantstrategieConducteur.choixStrategie(strategie);
        driver = strategieConducteur.setNavigateur();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }

    public static DriverSingleton getInstance(String driver){
        if(instance == null ){
            instance = new DriverSingleton(driver);
        }
        return instance;
    }
    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
