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
	
	@Given("user click All button")
	public void userClickOnAllButton() throws IOException, InterruptedException, ClassNotFoundException {
		homePage.clickOnAllDropdownButton();	
	}
	
	@Then("user click on {string} link")
	public void thenUserClickOnBestSellersLink(String moduleName) throws IOException, InterruptedException, ClassNotFoundException {
		homePage.clickOnModuleLink(moduleName);
	}
	
	@Then("user scroll to Back-to-top button and click and validate")
	public void userScrollToBack_To_Top_ButtonAndClickAndValidate() throws IOException, InterruptedException {
		homePage.clickOnBackToTopButton();
	}
		
	@And("tear down")
	public void tearDown() throws SQLException {
		genericMethods.tearDown();
	}
}
