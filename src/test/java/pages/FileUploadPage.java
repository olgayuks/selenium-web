package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FileUploadPage extends BasePage {
    private static String End_Point = "upload";

    protected By uploadInput = By.xpath("//input[@type='file']");
    protected By uploadButton = By.id("file-submit");

    public FileUploadPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(Base_URL + End_Point);

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public WebElement getUploadInput(){

        return driver.findElement(uploadInput);
    }

    public WebElement clickUploadButton(){

        return driver.findElement(uploadButton);

    }
}
