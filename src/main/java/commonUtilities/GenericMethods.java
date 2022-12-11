package commonUtilities;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.Status;




public class GenericMethods extends AbstractPage{

	
	String path;
	public void addScreenshot() throws IOException {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		path = ".//screenshot/screen.png";
		FileUtils.copyFile(screenshot, new File(path));
	}
	
	
	public void clickElement(By locator, String log, boolean flag) {
		
		try {
			driver.findElement(locator).click();
			test.pass("Click Element: " + log);
		}catch(Exception e) {
			test.fail("Could not click: " + log);
			redirectToUrlHomepage();
			if(flag) {
				Assert.assertTrue(false);
			}
		}	
	}
	
	public void clickElement(By locator, String log) {
		
		try {
			driver.findElement(locator).click();
			test.pass("Click Element: " + log);
		}catch(Exception e) {
			redirectToUrlHomepage();
			test.fail("Could not click: " + log);
		}	
	}
	
	public void navigateTo(String locator, String log, boolean flag) {
		try {
			driver.get(locator);
			test.pass("Navigated to: " + log);
		}catch(Exception e) {
			test.fail("Could not Navigate to: " + log);
			redirectToUrlHomepage();
			if(flag) {
				Assert.assertTrue(false);
			}
		}
	}
	
	public void navigateTo(String locator, boolean flag) {
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
	
	public void redirectToUrlHomepage() {
		navigateTo(prop.getProperty("url"), true);
	}
	
	
}
