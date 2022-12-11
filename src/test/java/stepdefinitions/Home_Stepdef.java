package stepdefinitions;

import java.io.IOException;

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
	public void userLaunchedBrowser() throws IOException {
		try {driver.getTitle();
		}catch(Exception e) {
			initialize();
		}
	}
	
	@Given("user click All button")
	public void userClickOnAllButton() throws IOException, InterruptedException {
		homePage.clickOnAllDropdownButton();	
	}
	
	@Then("user click on Best Sellers link")
	public void thenUserClickOnBestSellersLink() throws IOException {
		homePage.clickOnBestSellersLink();
	}
		
	@And("tear down")
	public void tearDown() {
		genericMethods.tearDown();
	}
}
