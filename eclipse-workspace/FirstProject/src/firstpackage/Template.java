package firstpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Template {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/nayemulchowdhury/Downloads/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "http://www.teksplash.com";
		
	}
	
	@Test 	
	public void function1() throws Exception {
		
		driver.get(baseUrl);
		System.out.println("Browser opened");
		
	}
	
	
	@After
	public void closeAll() throws Exception {
		driver.quit();
		
	}
	

}
