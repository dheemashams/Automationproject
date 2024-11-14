package testpackage;
import basepackage.ParabankBasecls;
import pagepackage.RegisterPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;



public class ParabankTest extends ParabankBasecls{
	RegisterPage registerPage;

    @Test(priority = 1)
    public void testUserRegistration() {
        // Initialize the RegisterPage object
        registerPage = new RegisterPage(driver);

        // Ensure the user is on the registration page
        Assert.assertEquals(driver.getCurrentUrl(), "https://parabank.parasoft.com/parabank/register.htm", "Not on the Registration page");

        
        registerPage.setValues("Aadam", "Shams", "121 Street", "New York", "NY", "10011", "1234567000", "123-45-6111", "aadamshams", "shams0123");

        
        registerPage.clickRegister();
    }

        
        

    
    @Test(priority = 2, dependsOnMethods = "testUserRegistration")
    public void captureScreenshotAfterRegistration() {
        try {
            takeScreenshot("registration_success.png");
        } catch (IOException e) {
            Assert.fail("Failed to capture screenshot. Error: " + e.getMessage());
        }
    }

    
    public void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\User\\Desktop\\Selenium\\screenshot.png" + fileName);
        destFile.getParentFile().mkdirs();
        FileUtils.copyFile(srcFile, destFile);
        System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
    }
}
	