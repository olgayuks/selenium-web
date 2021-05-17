package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ContextMenuSteps;
import steps.FileUploadSteps;
import steps.MainPageSteps;

import java.util.concurrent.TimeUnit;

public class MainTest extends BaseTest {
    private MainPageSteps mainPageSteps;
    private FileUploadSteps fileUploadSteps;
    private ContextMenuSteps contextMenuSteps;

    @Test
    public void MainPagePositiveTest() {
        mainPageSteps = new MainPageSteps(driver);
        mainPageSteps.main();
    }

    @Test
    public void uploadTest() {

        fileUploadSteps = new FileUploadSteps(driver);
        fileUploadSteps.upload();

    }

    @Test
    public void alertTest() {
        contextMenuSteps = new ContextMenuSteps(driver);
        Assert.assertEquals(contextMenuSteps.alertContext(),
                "You selected a context menu");
    }

    @Test
    public void frameTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/iframe");
//        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());
        driver.switchTo().parentFrame();
    }

    @Test
    public void DynamicControlsTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        //find checkbox and click
        final WebElement checkbox = driver.findElement(By.xpath("//*[@label = 'blah']"));
        checkbox.click();

        //click on button
        driver.findElement(By.xpath("//*[@autocomplete = 'off']")).click();

        WebElement messageWebElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(messageWebElement.getText(), "It's gone!");
        Assert.assertTrue(webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox)));

        //find input and assert that's disabled
        final WebElement input = driver.findElement(By.xpath("//*[@type= 'text']"));
        Assert.assertFalse(input.isEnabled());
        //click on button
        driver.findElement(By.xpath("//*[@onclick= 'swapInput()']")).click();
        //verify text exists and message is right
        messageWebElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(messageWebElement.getText(), "It's enabled!");
        //input is enabled
        Assert.assertTrue(input.isEnabled());
    }


}
