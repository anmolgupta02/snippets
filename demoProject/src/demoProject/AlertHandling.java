package demoProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertHandling {

	WebDriver driver;
	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver","/home/appventurez/Documents/seljars/chromedriver");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test()
	public void handleAlert() throws InterruptedException {
		//driver.get(arg0);
		driver.get("file:///home/appventurez/alert.html");
		driver.manage().window().maximize();
		// This step will result in an alert on screen
		driver.findElement(By.id("button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Text is "+ alertText);
		Thread.sleep(5000);
		alert.accept();
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 2)
	public void handleConfirmpop() {
		//String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
//		
		
		//To open new tab.
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
		//End code
		
		driver.get("file:///home/appventurez/confirm.html");
		 //driver.manage().window().maximize();
		 // This step will result in an alert on screen
		 WebElement element = driver.findElement(By.id("button"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		 
		 Alert confirmationAlert = driver.switchTo().alert();
		 String alertText = confirmationAlert.getText();
		 System.out.println("Alert text is " + alertText);
		 confirmationAlert.dismiss();
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
