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
	
	// Number Memory module locators
	By verbalMemoryModule = By.xpath("//a//h3[text()='Verbal Memory']");
	By verbalMemoryModuleHeader = By.xpath("//h1[text()='Verbal Memory Test']");
	
	// Chimp Test module locators
	By chimpTestModule = By.xpath("//a//h3[text()='Chimp Test']");
	By chimpTestModuleHeader = By.xpath("//span[text()='Are You Smarter Than a Chimpanzee?']");
	
	// Typing Test module locators
	By typingTestModule = By.xpath("//h3[text()='Typing']");
	By typingTestModuleHeader = By.xpath("//h1[text()='Typing Test']");
			
			
	
	public void navigateToModule(String module) throws IOException, InterruptedException {
		
		switch(module) {
		case "Reaction Time":
			genericMethods.clickElement(reactionTimeModule,"Reaction Time module",true);
			genericMethods.isDisplayed(reactionTimeModuleHeader, "Reaction Time page header",true);
			break;
		case "Aim Trainer":
			genericMethods.clickElement(aimTrainerModule, "Aim Trainer module", true);
			genericMethods.isDisplayed(aimTrainerPageHeader, "Aim Trainer page", true);
			break;
		case "Sequence Memory":
			genericMethods.clickElement(sequenceMemoryModule, "Sequence Memory module", true);
			genericMethods.isDisplayed(sequenceMemoryPageHeader,"Sequence Memory Test",true);
			break;
		case "Number Memory":
			genericMethods.clickElement(numberMemoryModule, "Number Memory module", true);
			genericMethods.isDisplayed(numberMemoryModuleHeader,"Number Memory Test",true);
			break;
		case "Verbal Memory":
			genericMethods.clickElement(verbalMemoryModule, "Verbal Memory module", true);
			genericMethods.isDisplayed(verbalMemoryModuleHeader,"Verbal Memory Test",true);
			break;
		case "Chimp Test":
			genericMethods.clickElement(chimpTestModule, "Chimp Test module", true);
			genericMethods.isDisplayed(chimpTestModuleHeader, "Chimp Test page", true);
			break;
		case "Typing Test":
			genericMethods.clickElement(typingTestModule, "Typing Test module" ,false);
			genericMethods.isDisplayed(typingTestModuleHeader, "Typing Test page", true);
			break;
		}
	}
	
	
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
