package pages;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;
import commonUtilities.Screenshot;

public class VerbalMemoryPage extends AbstractPage{	
	
	By startButton = By.xpath("//button[text()='Start']");
	By livesLocator = By.xpath("//span[@class='item lives']");	
	By scoreLocator = By.xpath("//span[@class='item score']");
	By displayedWord = By.xpath("//div[@class='word']");
	By seenButton = By.xpath("//button[text()='SEEN']");
	By newButton = By.xpath("//button[text()='NEW']");
	By tryAgainButton = By.xpath("//button[text()='Try again']");
	
	public void startVerbalMemoryTest() throws IOException, InterruptedException {
		genericMethods.clickElement(startButton,"Start button",true);
		genericMethods.isDisplayed(livesLocator,"Verbal Memory Test lives",true);
	}
	
	public void completeVerbalMemoryTest() throws IOException, InterruptedException {
		int desiredScore = 200;
		try {
			Set<String> words = new HashSet<>();
			
//			IF YOU WANT TO TEST USING LIVES, USE BELOW CODE 
//			int lives = Integer.parseInt(genericMethods.getText(livesLocator).substring(genericMethods.getText(livesLocator).length()-1));
//			while(lives > 0) {
//			lives = Integer.parseInt(genericMethods.getText(livesLocator).substring(genericMethods.getText(livesLocator).length()-1));
			
			for(int i = 1; i <= desiredScore; i++) {

				int before = words.size();
				words.add(genericMethods.getText(displayedWord));
				int after = words.size();
				
				if(before == after) {
					genericMethods.clickElement(seenButton,true);
				}else {
					genericMethods.clickElement(newButton, true);
				}
			}
			
			String[] split = genericMethods.getText(scoreLocator).split(" ");
			int score = Integer.parseInt(split[2]);
			feature.info("score is " + score);
			feature.pass("Verbal Memory Test reached " + score + " Successfully");
		}catch(Exception e) {
			Screenshot.logFail("ERROR: Verbal Memory Test DID NOT Reach score of " + desiredScore, true, true);
		}			
	}
	
	
	
	public void failVerbalMemoryTest() throws IOException, InterruptedException {
		
		try {
			Set<String> words = new HashSet<>();
			
			int lives = Integer.parseInt(genericMethods.getText(livesLocator).substring(genericMethods.getText(livesLocator).length()-1));
			while(lives > 1) {
				lives = Integer.parseInt(genericMethods.getText(livesLocator).substring(genericMethods.getText(livesLocator).length()-1));
				int before = words.size();
				words.add(genericMethods.getText(displayedWord));
				int after = words.size();
				if(before == after) {
					genericMethods.clickElement(newButton,true);
				}else {
					genericMethods.clickElement(seenButton, true);
				}
			}
			genericMethods.isDisplayed(tryAgainButton,"post-test screen",true);
		}catch(Exception e) {
			Screenshot.logFail("ERROR: post-test screen not displayed", true, true);
		}
	}
	
}
