package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NumberMemoryPage;

public class NumberMemory_Stepdef {

	NumberMemoryPage numberMemoryPage = new NumberMemoryPage();
	
	@And("user starts Number Memory Test")
	public void userStartsNumberMemoryTest() throws IOException, InterruptedException {
		numberMemoryPage.startNumberMemoryTest();
	}
	
	@When("user completes Number Memory Test")
	public void userCompletesNumberMemoryTest() throws IOException, InterruptedException {
		numberMemoryPage.completeNumberMemoryTest();
	}
	
	@Then("user fails Number Memory Test")
	public void userFailsNumberMemoryTest() throws IOException, InterruptedException {
		numberMemoryPage.failNumberMemoryTest();
	}
	
}
