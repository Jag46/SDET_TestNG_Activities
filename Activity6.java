package testNGActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity6 {
	WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/login-form");
  }
  
  @Test
  @Parameters({"username", "password"})
  public void parameterTest(String username, String password) {
	  WebElement usernameField = driver.findElement(By.id("username"));
      WebElement passwordField = driver.findElement(By.id("password"));
      usernameField.sendKeys(username);
      passwordField.sendKeys(password);
      driver.findElement(By.cssSelector("button[type='submit']")).click();
      String actualtext = driver.findElement(By.id("action-confirmation")).getText();
      Assert.assertEquals(actualtext, "Welcome Back, admin");  
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
