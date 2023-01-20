package stepdefinitions;

import java.io.IOException;

import commonUtilities.GenericMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ReactionTimeTestPage;

public class ReactionTimeTest_Stepdef {

	ReactionTimeTestPage reactionTimeTestPage = new ReactionTimeTestPage();
	GenericMethods genericMethods = new GenericMethods();
	
	@When("user starts Reaction Time Test")
	public void userStartsReactionTimeTest() throws IOException, InterruptedException {
		reactionTimeTestPage.startReactionTimeTest();
	}
	
	@Then("user clicks when screen turns green")
	public void userClicksWhenScreenTurnsGreen() throws IOException, InterruptedException {
		reactionTimeTestPage.clickWhenScreenTurnsGreen();
	}
	
	@Then("user clicks while screen is still red")
	public void userClicksWhileScreenIsStillRed() throws IOException, InterruptedException {
		reactionTimeTestPage.clickWhenScreenIsRed();
	}
}
