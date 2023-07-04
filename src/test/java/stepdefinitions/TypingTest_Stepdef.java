package stepdefinitions;

import java.io.IOException;

import commonUtilities.AbstractPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AimTrainerPage;
import pages.ChimpTestPage;
import pages.TypingTestPage;

public class TypingTest_Stepdef extends AbstractPage{

	TypingTestPage typingTestPage = new TypingTestPage();

	@Then("user completes Typing Test")
	public void userCompleteChimpTest() throws IOException, InterruptedException {
		typingTestPage.completeTypingTest();
	}
	
	
}
