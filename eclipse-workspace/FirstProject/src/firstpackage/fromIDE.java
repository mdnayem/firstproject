package firstpackage;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class fromIDE {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "/Users/nayemulchowdhury/Downloads/geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "http://www.teksplash.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTC1() throws Exception {
    driver.get(baseUrl + "/");
    Thread.sleep(5000);
    driver.findElement(By.linkText("Services")).click();
    Thread.sleep(5000);
    driver.findElement(By.linkText("Features")).click();
    Thread.sleep(5000);
    driver.findElement(By.linkText("Contact")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("img.custom-logo")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    System.out.println("Browser closed all passsed");
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}

