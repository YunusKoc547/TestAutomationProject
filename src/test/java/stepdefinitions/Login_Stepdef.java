package stepdefinitions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;


import commonUtilities.AbstractPage;
import commonUtilities.DatabaseMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import pages.LoginPage;


public class Login_Stepdef extends AbstractPage{

	LoginPage loginPage = new LoginPage();
	
	@Given("connected to database")
	public void connectToDatabase() throws SQLException, ClassNotFoundException {
		loginPage.connectToDatabase();	
	}
	
	@Given("user logged in with valid credentials")
	public void userLoggedInWithValidCredentials() throws SQLException, IOException, InterruptedException {
		loginPage.loginWithValidCredentials();
	}
	
	@And("User logged out successfully")
	public void userLoggedOutSuccessfully() throws IOException, InterruptedException {
		loginPage.logout();
	}
}
