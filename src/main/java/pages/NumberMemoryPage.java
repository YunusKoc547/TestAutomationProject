package pages;

import java.io.IOException;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;
import commonUtilities.Screenshot;

public class NumberMemoryPage extends AbstractPage{	
	
	By startButton = By.xpath("//button[text()='Start']");
	By numberToEnter = By.xpath("//div[@class='big-number ']"); ////input[@pattern='[0-9]*']
	By numberTextbox = By.xpath("//input[@pattern='[0-9]*']");
	By submitButton = By.xpath("//button[text()='Submit']");
	By nextButton = By.xpath("//button[text()='NEXT']");
	By tryAgainButton = By.xpath("//button[text()='Try again']");
	
	public void startNumberMemoryTest() throws IOException, InterruptedException {
		genericMethods.clickElement(startButton, "Start button" , true);
	}
	
	public void completeNumberMemoryTest() throws IOException, InterruptedException {
		int level = 10;
		for(int i = 1; i < level; i++) {
			String number = genericMethods.getText(numberToEnter);
			System.out.println(number);
			wait.until(ExpectedConditions.visibilityOfElementLocated(numberTextbox));
							
			genericMethods.setInputValue(numberTextbox, number, true);
			genericMethods.clickElement(submitButton,true);
			genericMethods.clickElement(nextButton,true);
		}
		feature.pass("Completed Number Memory test to round " + level + " Successfully");
	}
	
	public void failNumberMemoryTest() throws IOException, InterruptedException {
		genericMethods.setInputValue(numberTextbox, "testfail", "text",true);
		genericMethods.clickElement(submitButton, "Submit button", true);
		genericMethods.isDisplayed(tryAgainButton, "Number Memory Test end", true);
	}
	
}
