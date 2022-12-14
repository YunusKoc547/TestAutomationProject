package commonUtilities;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;





public class GenericMethods extends AbstractPage{
	
	public void clickElement(By locator, String log, boolean flag) throws IOException, InterruptedException {
		
		try {
			driver.findElement(locator).click();
			feature.pass("Click Element: " + log);
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Could not click: " + log,true);
			if(flag) {
				Assert.assertTrue(false);
			}
		}	
	}
	
	public void clickElement(By locator, String log) throws IOException, InterruptedException {
		
		try {
			driver.findElement(locator).click();
			feature.pass("Click Element: " + log);
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Could not click: " + log,true);
		}	
	}
	
	public void navigateTo(String locator, String log, boolean flag) throws IOException, InterruptedException {
		try {
			driver.get(locator);
			feature.pass("Navigated to: " + log);
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Could not navigate to: " + log,true);
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
	
	public void tearDown() throws SQLException {
//		extent.removeTest("Automation Execution report");
		extent.flush();
		driver.close();
		DatabaseMethods.con.close();
	}
	
	public static void redirectToUrlHomepage() {
		navigateTo(prop.getProperty("url"), true);
	}
	
	public void isDisplayed(By locator, String log, boolean flag) throws IOException, InterruptedException {
		try {
			driver.findElement(locator).isDisplayed();
			feature.pass("Element is visible: " + log);
		}catch(Exception e) {
			Screenshot.logFail("Element NOT Visible:" + log,true);
			if(flag) {
				Assert.assertTrue(false);
			}
		}
	}
	
	public void isNotDisplayed(By locator, String log, boolean flag) throws IOException, InterruptedException {
		
		try{
			driver.findElement(locator).isDisplayed();
			Screenshot.logFail("ERROR: " + log + " is displayed", true);
			if(flag) {
				Assert.assertFalse(true);
			}
		}catch(Exception e) {
			feature.info("No error messages received");
		}
	}
//	
//	public boolean isDisplayed(By locator, String log, boolean flag) throws IOException, InterruptedException {
//		try {
//			driver.findElement(locator).isDisplayed();
//			test.pass("Element is visible: " + log);
//		}catch(Exception e) {
//			Screenshot.logFail("ERROR: Element not displayed: " + log,true);
//			if(flag) {
//				Assert.assertTrue(false);
//			}
//		}
//	}
	
	public boolean isDisplayed(By locator) throws IOException, InterruptedException {
		
		return driver.findElement(locator).isDisplayed();
	}
	
//	public b isDisplayed(By locator) throws IOException, InterruptedException {
//		try {
//			driver.findElement(locator).isDisplayed();
//		}catch(Exception e) {
//			Screenshot.logFail("Unexpected error when trying to login",true);
//		}
//	}
	
	public void setInputValue(By locator,String keys, String field,boolean flag) throws IOException, InterruptedException {
		try {
			driver.findElement(locator).sendKeys(keys);
			feature.pass("Entered \"" + keys + "\" into " + field + " Successfully");
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Could not enter \"" + keys + "\" into " + field,true);
			if(flag) {
				Assert.assertTrue(false);	
			}
		}
	}
	
	public void setInputValue(By locator,String keys, String field,boolean flag, boolean isPassword) throws IOException, InterruptedException {
		try {
			driver.findElement(locator).sendKeys(keys);
			if(isPassword == false) {
				feature.pass("Entered \"" + keys + "\" into " + field + " Successfully");
			}else {
				feature.pass("password entered successfully");
			}
		}catch(Exception e) {
			if(isPassword == false) {
				Screenshot.logFail("ERROR: Could not enter \"" + keys + "\" into " + field,true);
			}else {
				Screenshot.logFail("ERROR: password not entered successfully",true);
				if(flag) {
					Assert.assertTrue(false);	
				}
			}
			
		}
	}
	
//	public <T> List getList() {
//		List<T> list = new ArrayList<>();
//		
//		list.add(null)
//		return list;
//		
//	}
	
	
}
