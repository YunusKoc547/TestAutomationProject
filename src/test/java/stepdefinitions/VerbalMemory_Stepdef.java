package stepdefinitions;

import java.io.IOException;


import commonUtilities.AbstractPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AimTrainerPage;
import pages.VerbalMemoryPage;

public class VerbalMemory_Stepdef extends AbstractPage{

	VerbalMemoryPage verbalMemoryPage = new VerbalMemoryPage();
	
	@And("user starts Verbal Memory Test")
	public void userStartVerbalMemoryTest() throws IOException, InterruptedException {
		verbalMemoryPage.startVerbalMemoryTest();
	}
	
	@Then("user fail Verbal Memory Test")
	public void userFailVerbalMemoryTest() throws IOException, InterruptedException {
		verbalMemoryPage.failVerbalMemoryTest();
	}
	
	@Then("user complete Verbal Memory Test")
	public void userCompleteVerbalMemoryTest() throws IOException, InterruptedException {
		verbalMemoryPage.completeVerbalMemoryTest();
	}
	
	
}
