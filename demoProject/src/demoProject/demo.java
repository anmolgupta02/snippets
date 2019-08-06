package demoProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class demo {

	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver;
		String baseURL;
		
			System.setProperty("webdriver.chrome.driver", "/home/appventurez/Documents/seljars/chromedriver");
			driver = new ChromeDriver();
			
			//Dukkan Admin Panel. 
			baseURL = "http://13.233.216.107:9091/";
			
		
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.get(baseURL);	
			driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("admin@dukkan.com");
			driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/app-root/app-public/div/div/div/div[2]/div/div/app-login/form/div[3]/div/div[2]/button")).click();
			
			System.out.println("Logged In Successfully");
			
			Thread.sleep(3000);
			
			//Triggering a drop-down
			WebElement drop = driver.findElement(By.xpath("/html/body/app-root/app-secure/div/div/app-header/header/div[3]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(drop).click().build().perform();
			
			
			
			//Choosing a option of logout
			WebElement Logout = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/button[3]"));
			Actions actionLog = new Actions(driver);
			actionLog.moveToElement(Logout).click().build().perform();
			
			//Confirming Logout. 
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/app-confirm-dialog/div/div/ul/li[1]/button")).click();
			
			System.out.println("Logged out successfully");
			
			Thread.sleep(3000);
		System.out.println("Script run Successfully");
		
		driver.quit();	}
	
	}

