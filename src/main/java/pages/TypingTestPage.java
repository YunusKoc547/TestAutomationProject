package pages;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;

public class TypingTestPage extends AbstractPage{	
	
	GenericMethods genericMethods = new GenericMethods();
	Actions action = new Actions(driver);
	
	By letters = By.xpath("//div[@class='letters notranslate']//span");
	By score = By.xpath("//h1[@class='css-0']");
	public void completeTypingTest() throws IOException, InterruptedException {		
	
		
		
		List<WebElement> list = driver.findElements(letters);
		
		for(WebElement currentLetter : list) {
			if(genericMethods.getText(currentLetter).trim().equals("")) {
				action.sendKeys(Keys.SPACE).perform();
				continue;
			}
			action.sendKeys(currentLetter.getText()).perform();
		}
		
		genericMethods.isDisplayed(score,"Typing Test score",true);
		feature.info("SUCCESSFULLY PASSED TYPING TEST WITH A SCORE OF " + genericMethods.getText(score));
	} 
	
}
