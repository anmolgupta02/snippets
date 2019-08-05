package demoProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngDemo {

	WebDriver driver;
	
	@Test
	public void test() {
		driver.get("https://www.google.com");
	}
	
	
	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver","/home/appventurez/Documents/seljars/chromedriver");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
