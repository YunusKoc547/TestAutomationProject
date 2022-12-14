package pages;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;

import commonUtilities.AbstractPage;
import commonUtilities.DatabaseMethods;
import commonUtilities.GenericMethods;
import commonUtilities.Screenshot;

public class LoginPage extends AbstractPage{
	
	GenericMethods genericMethods = new GenericMethods();

	By accountsAndListsButton = By.xpath("//a[@id='nav-link-accountList']");
	By signInTextbox = By.xpath("//input[@id='ap_email']");
	By continueButton = By.xpath("//input[@id='continue']");
	By passwordTextbox = By.xpath("//input[@id='ap_password']");
	By signInButton = By.xpath("//input[@id='signInSubmit']");
	By userAccountInfoUnlogged = By.xpath("//span[@id='nav-link-accountList-nav-line-1' and text()='Hello, sign in']");
	By passwordIncorrectMessage = By.xpath("//span[contains(text(),'Your password is incorrect')]");
	
	
	public void connectToDatabase() throws SQLException, ClassNotFoundException {
		DatabaseMethods.databaseConnection();
//		DatabaseMethods.emailAndPasswordPair();
	}
	
	public void loginWithValidCredentials() throws SQLException, IOException, InterruptedException { //genericMethods.isDisplayed(userAccountInfoUnlogged)

		try {
			if(genericMethods.isDisplayed(userAccountInfoUnlogged)); 
			}catch(Exception e) {
				try {
					if(genericMethods.isDisplayed(accountsAndListsButton)) {
						feature.info("user already logged in");
						return;
					}
				}catch(Exception t) {
					Screenshot.logFail("ERROR: Sign in button not displayed", true,true);
				}
			}
				
			String email = DatabaseMethods.userInformation()[0];
			String password = DatabaseMethods.userInformation()[1];
			String firstName = DatabaseMethods.userInformation()[2];
			String lastName = DatabaseMethods.userInformation()[3];
				
			By userFirstName = By.xpath("//span[@id='nav-link-accountList-nav-line-1' and contains(text(),'"+firstName+"')]");
			System.out.println("email: " + email);
			System.out.println("password: " + "<PASSWORD>");
				
			genericMethods.clickElement(accountsAndListsButton,"Accounts and Lists button",true);
			genericMethods.setInputValue(signInTextbox, email, "Email Address textbox field", true);
				
			genericMethods.clickElement(continueButton, "Continue button", true);
			genericMethods.setInputValue(passwordTextbox, password, "Password field",true,true);
				
			genericMethods.clickElement(signInButton, "Sign in button", true);
//			if(genericMethods.isDisplayed(passwordIncorrectMessage))
			genericMethods.isNotDisplayed(passwordIncorrectMessage, "Password Incorrect message", true);
			genericMethods.isDisplayed(userFirstName, "User Name " + DatabaseMethods.userInformation()[2], true);
			
	}
			

	
}
