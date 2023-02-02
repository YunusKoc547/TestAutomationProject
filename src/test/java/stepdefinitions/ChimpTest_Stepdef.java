package stepdefinitions;

import java.io.IOException;

import commonUtilities.AbstractPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AimTrainerPage;
import pages.ChimpTestPage;

public class ChimpTest_Stepdef extends AbstractPage{

	ChimpTestPage chimpTestPage = new ChimpTestPage();

	@And("user starts Chimp Test")
	public void userStartsChimpTest() throws IOException, InterruptedException {
		chimpTestPage.startChimpTest();
	}
	
	@Then("user completes Chimp Test")
	public void userCompleteChimpTest() throws IOException, InterruptedException {
		chimpTestPage.completeChimpTest();
	}
	
	
}
