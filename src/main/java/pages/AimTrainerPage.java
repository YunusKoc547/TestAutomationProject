package pages;

import java.io.IOException;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;

public class AimTrainerPage extends AbstractPage{	
	
	By aimTrainerStartTarget = By.xpath("//div[@class='css-z6vxiy e6yfngs3']");
	By remainingDisplay = By.xpath("//span[text()='Remaining']");
	By targetsRemaining = By.xpath("//span[@class='css-dd6wi1']//span[2]");
	By averageTimePerTargetScore = By.xpath("//h1[@class='css-0']");
	
	public void startAimTrainerTest() throws IOException, InterruptedException {
		genericMethods.clickElementUsingActionClass(aimTrainerStartTarget, "Aim Trainer start target", true);
		genericMethods.isDisplayed(remainingDisplay,"\"Remaining\" display",true);
	}
	
	public void completeAimTrainerTest() throws IOException, InterruptedException {
		int remaining = Integer.parseInt(driver.findElement(targetsRemaining).getText());
		while(remaining != 0) {
			genericMethods.clickElementUsingActionClass(aimTrainerStartTarget, "Aim Trainer target: " + remaining, true); 
			remaining--;
		}
		
		feature.info("Average time per target: " + genericMethods.getText(averageTimePerTargetScore));
	}
	
}
