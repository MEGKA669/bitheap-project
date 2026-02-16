package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomJs implements strategieConducteur{
    @Override
    public WebDriver setNavigateur() {
        System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();// c'est la mm chose que ChromeOptions
        WebDriver driver = new PhantomJSDriver(desiredCapabilities);

        return driver;
    }
}
