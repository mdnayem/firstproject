package firstpackage;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Calculator2 {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
 

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "/Users/nayemulchowdhury/Downloads/geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "https://www.mortgagecalculator.org/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  }

  @Test
  public void Mytest1() throws Exception {
    driver.get(baseUrl + "/");
    WebElement loanamount;
    loanamount = driver.findElement(By.id("loanamt"));
    loanamount.clear();
    loanamount.sendKeys("250000");
    driver.findElement(By.id("intrstsrate")).clear();
    driver.findElement(By.id("intrstsrate")).sendKeys("4.5");
    driver.findElement(By.id("loanterm")).clear();
    driver.findElement(By.id("loanterm")).sendKeys("30");
    new Select(driver.findElement(By.name("param[start_month]"))).selectByVisibleText("Feb");
    driver.findElement(By.id("pptytax")).clear();
    driver.findElement(By.id("pptytax")).sendKeys("1");
    driver.findElement(By.id("pmi")).clear();
    driver.findElement(By.id("pmi")).sendKeys("0");
    driver.findElement(By.id("hoi")).clear();
    driver.findElement(By.id("hoi")).sendKeys("1200");
    driver.findElement(By.id("hoa")).clear();
    driver.findElement(By.id("hoa")).sendKeys("0");
    driver.findElement(By.name("cal")).click();
    System.out.println("My @Test");
  }
  @Test
  public void mytest2() throws Exception {
	  System.out.println("Nothing in this test");
	  System.out.println("My @Test2");
	  
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
