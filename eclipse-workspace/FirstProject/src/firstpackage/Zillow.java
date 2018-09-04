package firstpackage;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;
//import org.junit.*;
//import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Zillow {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "/Users/nayemulchowdhury/Downloads/geckodriver");  
    driver = new FirefoxDriver();
    baseUrl = "https://www.zillow.com/mortgage-calculator/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
    //return new FirefoxDriver();
  }

  @Test
  public void Test1() throws Exception {
	  int a;
	  a = 0;
	  while (a < 1) {
    driver.get(baseUrl);
    driver.findElement(By.id("inputs-homePrice")).click();
    driver.findElement(By.id("inputs-homePrice")).clear();
   
    String mortgage = "300000";
    
    driver.findElement(By.id("inputs-homePrice")).sendKeys(mortgage);
    driver.findElement(By.cssSelector("form.zsg-form")).click();
    driver.findElement(By.id("downPayment")).click();
    driver.findElement(By.id("downPayment")).clear();
    driver.findElement(By.id("downPayment")).sendKeys("30000");
    driver.findElement(By.id("inputs-term")).click();
    new Select(driver.findElement(By.id("inputs-term"))).selectByVisibleText("15-year fixed");
    driver.findElement(By.cssSelector("option[value=\"Fixed15Year\"]")).click();
    driver.findElement(By.id("inputs-rate")).click();
    driver.findElement(By.id("inputs-rate")).click();
    driver.findElement(By.id("inputs-rate")).clear();
    driver.findElement(By.id("inputs-rate")).sendKeys("4");
    driver.findElement(By.cssSelector("div.zmm-calc-layout-bcol")).click();
    
    try {
        assertEquals("$1,289", driver.findElement(By.cssSelector("text.arc-label-value")).getText());
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
    
    a++;
	  }
	  
	
	 

  }
  @AfterTest
  public void tearDown() throws Exception {
     driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
