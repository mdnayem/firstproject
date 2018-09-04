package firstpackage;

import java.util.concurrent.TimeUnit;
//import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calculator {
	
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "/Users/nayemulchowdhury/Downloads/geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "http://www.mortgagecalculator.org/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void CalculatorFunction() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("param[homevalue]")).clear();
    String homeValues;
    homeValues = "400000";
    WebElement homeValueTextBox;
    homeValueTextBox = driver.findElement(By.name("param[homevalue]"));
    homeValueTextBox.sendKeys(homeValues);
    Thread.sleep(3000);
    driver.findElement(By.id("loanamt")).clear();
    driver.findElement(By.id("loanamt")).sendKeys("300000");
    writeFunction("Loan amount added 300000");
    Thread.sleep(3000);
    driver.findElement(By.id("intrstsrate")).clear();
    driver.findElement(By.id("intrstsrate")).sendKeys("5");
    Thread.sleep(3000);
    new Select(driver.findElement(By.name("param[start_month]"))).selectByVisibleText("Aug");
    driver.findElement(By.id("pptytax")).clear();
    driver.findElement(By.id("pptytax")).sendKeys("1.5");
    writeFunction("Tax rate added 1.5");
    Thread.sleep(3000);
    driver.findElement(By.id("pmi")).clear();
    driver.findElement(By.id("pmi")).sendKeys("0");
    driver.findElement(By.id("hoi")).clear();
    driver.findElement(By.id("hoi")).sendKeys("1100");
    writeFunction("HOI amount added $1100");
    Thread.sleep(3000);
    driver.findElement(By.name("cal")).click();
    Thread.sleep(3000);
    WebElement monthlyPayment;
    String monthlyPayment2;
    String oldPayment;
    oldPayment = "$2,202.13";
    writeFunction("for 400,000 loan, monthly payment was "+ oldPayment);
    monthlyPayment = driver.findElement(By.cssSelector("div.left-cell > h3"));
    monthlyPayment2 = monthlyPayment.getText();
    if (oldPayment.equals(monthlyPayment2))
    {
    System.out.println("Test Passed");}
    else
    {System.out.println("Test Failed");}
    	
    writeFunction("for 400,000 loan, monthly payment we found is "+ monthlyPayment2);
    docalculation(100,200, "Here is my total ");
    
    
    try {
      assertEquals("$2,202.13", driver.findElement(By.cssSelector("div.left-cell > h3")).getText());
      
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    }
  @Test
  public void caltest2() throws Exception {
	  int a;
	  int b;
	  a = 10;
	  b = 20;
	  int total = (a + b);
	  writeFunction("My total is " + total);	  
	  
  }
  
  public void writeFunction(String s) {
	  System.out.println(s);
  }
  
  public void docalculation(int a, int b, String s) {
	  //a = 10;
	  //b =50;
	  int total;
	  total = a + b;
	  System.out.println(s + total);
  }

  @AfterTest
  public void tearDown() throws Exception {
   // driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
