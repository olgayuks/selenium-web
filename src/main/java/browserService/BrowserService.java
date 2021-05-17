package browserService;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;

    public BrowserService() {
        ReadProperties readProperties = new ReadProperties();
        String browserName = readProperties.getBrowserName();
        switch (browserName.toLowerCase()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setHeadless(readProperties.isHeadless());

                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
}

