package baseEntities;

import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public WebDriver driver;
    public ReadProperties readProperties;
    public String Base_URL;

    protected abstract void openPage();
    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        this.readProperties = new ReadProperties();
        this.Base_URL = readProperties.getURL();
        if (openPageByUrl) {
            openPage();
            waitForOpen();
        }

    }

    private void waitForOpen() {
    }


}
