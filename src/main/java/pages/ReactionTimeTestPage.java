package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;

public class ReactionTimeTestPage extends AbstractPage{

	By reactionTimeTestStart = By.xpath("//div[@class='view-splash e18o0sx0 css-saet2v e19owgy77']");
	By redScreen = By.xpath("view-waiting e18o0sx0 css-saet2v e19owgy77");
	By waitForGreenMessage = By.xpath("//div[text()='Wait for green']");
	By greenScreen = By.xpath("//div[text()='Click!']");
	By score = By.xpath("//div[@class='css-1qvtbrk e19owgy78']//div");
	By tooSoonMessage = By.xpath("//div[text()='Too soon!']");
	
	public void startReactionTimeTest() throws IOException, InterruptedException {
		genericMethods.clickElement(reactionTimeTestStart, "Reaction Time Test", true);
		genericMethods.isDisplayed(waitForGreenMessage,"\"Wait for green\" message",true);
	}
	
	public void clickWhenScreenTurnsGreen() throws IOException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(greenScreen));
		genericMethods.clickElement(greenScreen, "\"Click!\" screen", true);
		genericMethods.isDisplayed(score,"reaction time",true);
		
		feature.info("Your reaction time was: " + genericMethods.getText(score));
	}
	
	public void clickWhenScreenIsRed() throws IOException, InterruptedException {

		genericMethods.clickElement(waitForGreenMessage, "\"Wait for green\" screen", true);
		genericMethods.isDisplayed(tooSoonMessage,"\"Too soon!\" message",true);
		
	}
}
