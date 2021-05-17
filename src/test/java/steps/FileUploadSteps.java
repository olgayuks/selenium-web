package steps;

import org.openqa.selenium.WebDriver;
import pages.FileUploadPage;

import java.io.File;

public class FileUploadSteps {
    private WebDriver driver;

    public FileUploadSteps(WebDriver driver) {

        this.driver = driver;
    }

    public void upload() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver, true);
        fileUploadPage.getUploadInput().sendKeys("C:/Users/user/Downloads/Telegram Desktop/Screenshot_1.png");
//        String fileName = getClass().getClassLoader().getResource("config.properties").getPath() + File.separator + "Screenshot_1.png";
        fileUploadPage.clickUploadButton().click();
    }
}
