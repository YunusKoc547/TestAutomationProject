package stepdefinitions;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pages.HomePage;
import pages.LoginPage;

public class Home_Stepdef extends AbstractPage{


	PageObjectManager pageObjectManager;
	HomePage homePage = new HomePage();
	GenericMethods genericMethods = new GenericMethods();
	
	@Given("user click on home button")
	public void userClickOnHomeButton() throws IOException, InterruptedException {
		homePage.clickOnAllDropdownButton();	
	}
	
	@Given("user click on home button1")
	public void userClickOnHomeButton1() throws IOException, InterruptedException {
		homePage.clickOnAllDropdownButton1();	
	}
	
	
	@And("tear down")
	public void tearDown() {
		genericMethods.tearDown();
	}
}
