package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.ContextMenuPage;

public class ContextMenuSteps {
    private WebDriver driver;


    public ContextMenuSteps(WebDriver driver) {

        this.driver = driver;
    }

    public String alertContext() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver, true);
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuPage.alert()).perform();

        Alert alert = driver.switchTo().alert();
        final String text = alert.getText();
        alert.accept();
        return text;
    }
}
