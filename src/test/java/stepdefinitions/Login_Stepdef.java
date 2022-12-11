package stepdefinitions;

import org.openqa.selenium.WebDriver;


import commonUtilities.AbstractPage;
import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import pages.LoginPage;


public class Login_Stepdef extends AbstractPage{



	LoginPage loginPage;
	
	
	@Given("user launched browser and navigated to application")
	public void userLaunchedBrowser() {
		try {driver.getTitle();
		}catch(Exception e) {
			initialize();
		}
	}
}
