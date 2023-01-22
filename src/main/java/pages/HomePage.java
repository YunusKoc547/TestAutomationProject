package pages;

import java.io.IOException;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;

public class HomePage extends AbstractPage{	
	
	By humanBenchMarkModule = By.xpath("//div[@class='css-o34a3t e19owgy75']//a[text()='HUMAN BENCHMARK']");
	
	// Reaction Time module locators
	By reactionTimeModuleHeader = By.xpath("//h1[text()='Reaction Time Test']");
	By reactionTimeModule = By.xpath("//a//h3[text()='Reaction Time']");
	
	// Aim Test module locators
	By aimTrainerModule = By.xpath("//a//h3[text()='Aim Trainer']");
	By aimTrainerModuleTitle = By.xpath("//h2[text()='Aim Trainer']");
	
	
	public void navigateToReactionTimeModule() throws IOException, InterruptedException {
		genericMethods.clickElement(reactionTimeModule,"Reaction Time module",true);
		genericMethods.isDisplayed(reactionTimeModuleHeader, "Reaction Time page header",true);
	}
	
	public void navigateToHomePage() throws IOException, InterruptedException {
		genericMethods.clickElement(humanBenchMarkModule, "HUMAN BENCHMARK module", true);
	}
	
	public void navigateToAimTrainerModule() throws IOException, InterruptedException {
		genericMethods.clickElement(aimTrainerModule, "Aim Trainer module", true);
		genericMethods.isDisplayed(aimTrainerModuleTitle, "Aim Trainer page", true);
	}
	

	
	
	
}
