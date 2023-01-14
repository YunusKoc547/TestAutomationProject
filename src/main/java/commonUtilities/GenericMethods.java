package commonUtilities;



import java.io.IOException;


import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;





public class GenericMethods extends AbstractPage{
	
	
	
	public void clickElement(By locator, String log, boolean flag) throws IOException, InterruptedException {
		
		try {
			driver.findElement(locator).click();
			feature.pass("Click Element: " + log);
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Could not click: " + log,true,flag);
		}	
	}

	
	public void navigateTo(String locator, String log, boolean flag) throws IOException, InterruptedException {
		try {
			driver.get(locator);
			feature.pass("Navigated to: " + log);
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Could not navigate to: " + log,true,flag);
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
		extent.flush();
//		extent.removeTest("Automation Execution report");
		driver.close();
		
		try {
			DatabaseMethods.con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void redirectToUrlHomepage() {
		navigateTo(prop.getProperty("url"), true);
	}
	
	public void isDisplayed(By locator, String log, boolean flag) throws IOException, InterruptedException {
		try {
			driver.findElement(locator).isDisplayed();
			feature.pass("Element is visible: " + log);
		}catch(Exception e) {
			Screenshot.logFail("Element NOT Visible: " + log,true,flag);
		}
	}
	
	public void isNotDisplayed(By locator, String log, boolean flag) throws IOException, InterruptedException {
		
		try{
			driver.findElement(locator).isDisplayed();
			Screenshot.logFail("ERROR: " + log + " is displayed", true,flag);
		}catch(Exception e) {
			feature.info("No error messages received");
		}
	}
	
	public boolean isDisplayed(By locator) throws IOException, InterruptedException {
		
		return driver.findElement(locator).isDisplayed();
	}
	
	public void setInputValue(By locator,String keys, String field,boolean flag) throws IOException, InterruptedException {
		try {
			driver.findElement(locator).sendKeys(keys);
			feature.pass("Entered \"" + keys + "\" into " + field + " Successfully");
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Could not enter \"" + keys + "\" into " + field,true,flag);
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
				Screenshot.logFail("ERROR: Could not enter \"" + keys + "\" into " + field,true,flag);
			}else {
				Screenshot.logFail("ERROR: password not entered successfully",true,flag);

			}
			
		}
	}
	
	public void scrollIntoView(By locator, String field) throws IOException, InterruptedException {
		je = (JavascriptExecutor) driver;
		
		try {
			WebElement element = driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']"));
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			Thread.sleep(2000);
			feature.pass("Successfully scrolled " + field + " into view");
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Could not scroll " + field + " into view", true, true);
		}
	}
	
	
}
