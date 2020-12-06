package steps;


import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainPageSteps {
    private WebDriver driver;


    public MainPageSteps(WebDriver driver) {

        this.driver = driver;
    }

    public void main() {
        MainPage mainPage = new MainPage(driver, true);
        mainPage.getEndOfPage().isDisplayed();


    }
}
