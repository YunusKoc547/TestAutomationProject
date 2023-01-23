package stepdefinitions;

import java.io.IOException;

import commonUtilities.AbstractPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AimTrainerPage;

public class AimTrainer_Stepdef extends AbstractPage{

	AimTrainerPage aimTrainerPage = new AimTrainerPage();
	
	@And("user starts Aim Trainer test")
	public void userStartsAimTrainerTest() throws IOException, InterruptedException {
		aimTrainerPage.startAimTrainerTest();
	}
	
	@Then("user completes Aim Trainer test")
	public void userCompleteAimTrainerTest() throws IOException, InterruptedException {
		aimTrainerPage.completeAimTrainerTest();
	}
	
	
}
