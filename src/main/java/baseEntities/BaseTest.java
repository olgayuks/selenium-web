package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public ReadProperties readProperties = new ReadProperties();

    public BaseTest() {
    }

    @BeforeClass
    public void setUp() {
        this.driver = new BrowserService().getDriver();
        driver.get(readProperties.getURL());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

