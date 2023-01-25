package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;
import commonUtilities.Screenshot;

public class SequenceMemoryPage extends AbstractPage{	
	
	By startButton = By.xpath("//button[text()='Start']");
	By levelText = By.xpath("//span[text()='Level:']");
	By squares = By.xpath("//div[@class='square']");
	By activeSquares = By.xpath("//div[@class='square active']");
	By levelLocator = By.xpath("//span[@class='css-dd6wi1']//span[2]");
	
	
	public void startSequenceMemoryTest() throws IOException, InterruptedException {	
		genericMethods.clickElement(startButton, "Start button", true);
		genericMethods.isDisplayed(levelText, "\"Level\" text",true);
	}
	
	public void completeSequenceMemoryTest() throws IOException, InterruptedException {	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		try {
			List<WebElement> list = driver.findElements(squares);
			List<Integer> listInt = new ArrayList<>();
			int currentLevel = Integer.parseInt(driver.findElement(levelLocator).getText());
			
			int index = 0;
			int count = 0;
			int test = 1;
			int levelNumber = 10;
			for (int j = 0; j < levelNumber; j++) {
					
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(activeSquares));		
	
				for (int i = 0; i < list.size(); i++) {				
	
					if(list.get(i).getAttribute("class").equals("square active")) {
						listInt.add(i);	
						wait.until(ExpectedConditions.attributeToBe(list.get(i), "class", "square"));
						i = -1;
						index++;
						if(index == currentLevel) break;
						
					}
				}	
				
				System.out.println("Level: " + currentLevel);
				System.out.println("index: " + index);
			
		
				System.out.println("List for test " + test + ": " + listInt);
				test++;
				wait.until(ExpectedConditions.elementToBeClickable(squares));
				Thread.sleep(1000); // SQUARES ARE CLICKABLE BEFORE CLICKS CAN BE REGISTERED, WAIT IS REQUIRED
				while(count < listInt.size()) {
					Thread.sleep(50);
					driver.findElements(squares).get(listInt.get(count)).click();
					count++;
				}
				count = 0;
				index = 0;
				listInt.clear();
				currentLevel = Integer.parseInt(driver.findElement(levelLocator).getText());
			}	
			feature.pass("Completed Sequence Memory Test to level "+(levelNumber+1)+" Successfully");
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Failed to complete Sequence Memory Test", true, true);
		}
	}
}
