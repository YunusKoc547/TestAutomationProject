package stepdefinitions;

import java.io.IOException;
import java.sql.SQLException;

import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pages.HomePage;

public class Home_Stepdef extends AbstractPage{


	PageObjectManager pageObjectManager;
	HomePage homePage = new HomePage();
	GenericMethods genericMethods = new GenericMethods();
	
	@Given("user launched browser and navigated to url")
	public void userLaunchedBrowser() throws IOException, InterruptedException, ClassNotFoundException {
		try {
			driver.getTitle();
			GenericMethods.redirectToUrlHomepage();
		}catch(Exception e) {
			initialize();
		}
	}
	
	@Given("user navigates to home page")
	public void userNavigateToHomePage() throws IOException, InterruptedException {
		homePage.navigateToHomePage();
	}
	
	@When("user navigates to Reaction Time module")
	public void userNavigatesToReactionTimeModule() throws IOException, InterruptedException {
		homePage.navigateToReactionTimeModule();
	}
	
	@When("user navigates to Aim Trainer module")
	public void userNavigatesToAimTestModule() throws IOException, InterruptedException {
		homePage.navigateToAimTrainerModule();
	}
	
	
		
	@And("tear down")
	public void tearDown() throws SQLException {
		genericMethods.tearDown();
	}
}
