package pages;

import java.io.IOException;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;

public class HomePage extends AbstractPage{	
	
	By humanBenchMarkModule = By.xpath("//div[@class='css-o34a3t e19owgy75']//a[text()='HUMAN BENCHMARK']");
	
	// Reaction Time module locators
	By reactionTimeModule = By.xpath("//a//h3[text()='Reaction Time']");
	By reactionTimeModuleHeader = By.xpath("//h1[text()='Reaction Time Test']");
	
	// Aim Trainer module locators
	By aimTrainerModule = By.xpath("//a//h3[text()='Aim Trainer']");
	By aimTrainerPageHeader = By.xpath("//h2[text()='Aim Trainer']");
	
	// Sequence Memory module locators
	By sequenceMemoryModule = By.xpath("//a//h3[text()='Sequence Memory']");
	By sequenceMemoryPageHeader = By.xpath("//h1[text()='Sequence Memory Test']");
	
	// Number Memory module locators
	By numberMemoryModule = By.xpath("//a//h3[text()='Number Memory']");
	By numberMemoryModuleHeader = By.xpath("//h1[text()='Number Memory']");
			
	
	
	public void navigateToReactionTimeModule() throws IOException, InterruptedException {
		genericMethods.clickElement(reactionTimeModule,"Reaction Time module",true);
		genericMethods.isDisplayed(reactionTimeModuleHeader, "Reaction Time page header",true);
	}
	
	public void navigateToHomePage() throws IOException, InterruptedException {
		genericMethods.clickElement(humanBenchMarkModule, "HUMAN BENCHMARK module", true);
	}
	
	public void navigateToAimTrainerModule() throws IOException, InterruptedException {
		genericMethods.clickElement(aimTrainerModule, "Aim Trainer module", true);
		genericMethods.isDisplayed(aimTrainerPageHeader, "Aim Trainer page", true);
	}
	
	public void navigateToSequenceMemoryModule() throws IOException, InterruptedException {
		genericMethods.clickElement(sequenceMemoryModule, "Sequence Memory module", true);
		genericMethods.isDisplayed(sequenceMemoryPageHeader,"Sequence Memory Test",true);
	}
	
	public void navigateToNumberMemoryModule() throws IOException, InterruptedException {
		genericMethods.clickElement(numberMemoryModule, "Number Memory module", true);
		genericMethods.isDisplayed(numberMemoryModuleHeader,"Number Memory Test",true);
	}
	

	
	
	
}
