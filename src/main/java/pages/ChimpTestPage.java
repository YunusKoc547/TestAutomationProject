package pages;

import java.io.IOException;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;

public class ChimpTestPage extends AbstractPage{	
	
	By startTestButton = By.xpath("//button[text()='Start Test']");
	By allNumberTiles = By.xpath("//div[@class='css-19b5rdt']");
	By continueButton = By.xpath("//button[text()='Continue']");
	
	public void startChimpTest() throws IOException, InterruptedException {		
		genericMethods.clickElement(startTestButton, "Start Test button", true);
	} 
	
	public void completeChimpTest() throws IOException, InterruptedException {
				
		int level = 0;
		while (level < 10000) {
		int size = driver.findElements(allNumberTiles).size();
		
		System.out.println("size = " + size);
		
			for (int i = 1; i <= size; i++) {
				System.out.println(i);
				genericMethods.clickElement(By.xpath("//div[@data-cellnumber='"+i+"']"), true);
			}
			level++;
			genericMethods.clickElement(continueButton, true);
		}
		
		feature.pass("Chimp Test got to level " + level  + " Successfully");
	}
}
