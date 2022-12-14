package commonUtilities;

import java.io.File;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Screenshot extends AbstractPage{
	
	GenericMethods generic = new GenericMethods();
		
	public static String takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) AbstractPage.driver;
		
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmm");  
		LocalDateTime now = LocalDateTime.now(); 
		String timeStamp = dtf.format(now);
		String img = "screenshot" + timeStamp + ".png";
		FileUtils.copyFile(scrFile, new File("Reports\\screenshots\\" + img));
		
		return img;
	}
	
	public static void logFail(String log, boolean screenshot, boolean fail) throws IOException, InterruptedException {
		feature.fail(log);
		if(screenshot) {
			Thread.sleep(1000);
			feature.addScreenCaptureFromPath("./screenshots/"+Screenshot.takeScreenshot(driver));
		}
		if(fail) {
			Assert.assertTrue(false);
		}
	}
	
	

}
