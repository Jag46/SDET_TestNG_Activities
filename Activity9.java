package testNGActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;

   
    @BeforeMethod
    public void beforeMethod() {
    	driver = new FirefoxDriver();
        Reporter.log("Starting Test |");
        //open browser URL
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened Browser |");
        Reporter.log("Page title is " + driver.getTitle() + " |");
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlertTestCase() throws InterruptedException {
        Reporter.log("simpleAlertTestCase() started |");
        //Click the button to open a simple alert
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |");
        Thread.sleep(5000);
        //Switch to alert window
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
        
        //Get text in the alert box and print it
        String alertText = simpleAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");
        
        //Assertion
        Assert.assertEquals("This is a JavaScript Alert!", alertText);

        simpleAlert.accept();
        Reporter.log("Alert closed");

        Reporter.log("Test case ended |");
    }

    @Test(priority = 1)
    public void confirmAlertTestCase() throws InterruptedException {
        Reporter.log("confirmAlertTestCase() started |");
        //Click the button to open a simple alert
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Confirm Alert opened |");
        Thread.sleep(5000);
        //Switch to alert window
        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");

        //Get text in the alert box and print it
        String alertText = confirmAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");
        
        //Assertion
        Assert.assertEquals("This is a JavaScript Confirmation!", alertText);

        confirmAlert.accept();
        Reporter.log("Alert closed |");

        Reporter.log("Test case ended |");
    }

    @Test(priority = 2)
    public void promptAlertTestCase() throws InterruptedException {
        Reporter.log("promptAlertTestCase() started |");
        //Click the button to open a simple alert
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened |");
        Thread.sleep(5000);
        //Switch to alert window
        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");

        //Get text in the alert box and print it
        String alertText = promptAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");

        promptAlert.sendKeys("Awesome!");
        Reporter.log("Text entered in prompt alert |");
        
 
        Assert.assertEquals("This is a JavaScript Prompt!", alertText);

        promptAlert.accept();
        Reporter.log("Alert closed |");

        Reporter.log("Test case ended |");
    }

    @AfterMethod
    public void tearDown() {
    	Reporter.log("Ending Test |");
        //Close the driver
        driver.close();
    }
}
