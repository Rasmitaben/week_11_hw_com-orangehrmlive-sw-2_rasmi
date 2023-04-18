package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    /*
    1. userSholdLoginSuccessfullyWithValidCredentials
* Enter “Admin” username
* Enter “admin123 password
* Click on ‘LOGIN’ button
* Verify the ‘Welcome’ text is display
     */
    public void  userShouldLoginSuccessfullyWithValidCredentials(){
     // Enter “Admin” username
 driver.findElement(By.name("username")).sendKeys("Admin");
    //Enter “admin123 password
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the ‘Welcome’ text is display
        String expectedMessage = "Dashboard";
        WebElement actualTestElement = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
        String actualMessage = actualTestElement.getText();
        Assert.assertEquals("message not displayed correctly",expectedMessage,actualMessage);
    }
    @After
    public void teardown(){
        //closeBrowser
        //driver.close();
    }
}
