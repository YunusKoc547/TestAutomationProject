package commonUtilities;



import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;





public class GenericMethods extends AbstractPage{
	
	public void clickElement(By locator, String log, boolean flag) throws IOException {
		
		try {
			driver.findElement(locator).click();
			test.pass("Click Element: " + log);
		}catch(Exception e) {
			Screenshot.logFail(log,true);
			if(flag) {
				Assert.assertTrue(false);
			}
		}	
	}
	
	public void clickElement(By locator, String log) throws IOException {
		
		try {
			driver.findElement(locator).click();
			test.pass("Click Element: " + log);
		}catch(Exception e) {
			Screenshot.logFail(log,true);
			test.fail("Could not click: " + log);
		}	
	}
	
	public void navigateTo(String locator, String log, boolean flag) throws IOException {
		try {
			driver.get(locator);
			test.pass("Navigated to: " + log);
		}catch(Exception e) {
			Screenshot.logFail(log,true);
			if(flag) {
				Assert.assertTrue(false);
			}
		}
	}
	
	public static void navigateTo(String locator, boolean flag) {
		try {
			driver.get(locator);
		}catch(Exception e) {
			redirectToUrlHomepage();
			if(flag) {
				Assert.assertTrue(false);
			}
		}
	}
	
	public void tearDown() {
		extent.flush();
		driver.close();
	}
	
	public static void redirectToUrlHomepage() {
		navigateTo(prop.getProperty("url"), true);
	}
	
	public void isDisplayed(By locator, String log, boolean flag) throws IOException {
		try {
			driver.findElement(locator).isDisplayed();
			test.pass("Element is visible: " + log);
		}catch(Exception e) {
			Screenshot.logFail(log,true);
			if(flag) {
				Assert.assertTrue(false);
			}
		}
	}
	
	
}
