package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContextMenuPage extends BasePage {

    private static String End_Point = "context_menu";
    protected By alertWindow = By.id("hot-spot");


    public ContextMenuPage(WebDriver driver, boolean openPageByUrl) {

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

    public WebElement alert(){
        return driver.findElement(alertWindow);
    }
}
