package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    protected By EndOfPage = By.xpath("//*[@style='text-align: center;']");

    public MainPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);

    }

    @Override
    protected void openPage() {
        driver.get(Base_URL);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return driver.findElement(By.xpath("//*[@style='text-align: center;']")).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    public WebElement getEndOfPage(){
return driver.findElement(EndOfPage);
    }

}
