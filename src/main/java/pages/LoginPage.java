package pages;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;

import commonUtilities.AbstractPage;
import commonUtilities.DatabaseMethods;
import commonUtilities.GenericMethods;
import commonUtilities.Screenshot;

public class LoginPage extends AbstractPage{
	
	By loginButton = By.xpath("//div[@class='user-nav']//a[text()='LOGIN']");
	By usernameTextbox = By.xpath("//input[@name='username']");
	By passwordTextbox = By.xpath("//input[@name='password']");
	By loginButtonOnLoginPage = By.xpath("//input[@value='Login']");
	By logoutButton = By.xpath("//div[@class='user-nav']//a[text()='LOGOUT']");
	
	
	public void connectToDatabase() throws SQLException, ClassNotFoundException {
		DatabaseMethods.databaseConnection();
//		DatabaseMethods.emailAndPasswordPair();
	}
	
	public void loginWithValidCredentials() throws SQLException, IOException, InterruptedException, ClassNotFoundException { //genericMethods.isDisplayed(userAccountInfoUnlogged)

//		try {
//			if(genericMethods.isDisplayed(userAccountInfoUnlogged)); 
//			}catch(Exception e) {
//				try {
//					if(genericMethods.isDisplayed(accountsAndListsButton)) {
//						feature.info("user already logged in");
//						return;
//					}
//				}catch(Exception t) {
//					Screenshot.logFail("ERROR: Sign in button not displayed", true,true);
//				}
//			}
		
		connectToDatabase();
		
		try {
			if(genericMethods.isDisplayed(loginButton));
		}catch(Exception e) {
			try {
				if(genericMethods.isDisplayed(logoutButton)) {
					feature.info("a user is already logged in");
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
				
			By username = By.xpath("//div[text()='"+firstName + " " + lastName+"']");
			System.out.println("email: " + email);
			System.out.println("password: " + "<PASSWORD>");
				
			genericMethods.clickElement(loginButton,"Login button",true);
			genericMethods.setInputValue(usernameTextbox, firstName + " " + lastName, " Username field", true);
				
			genericMethods.setInputValue(passwordTextbox, password, "Password field",true,true);
				
			genericMethods.clickElement(loginButtonOnLoginPage, "Login button", true);
			
			genericMethods.isDisplayed(username, "username:  " + DatabaseMethods.userInformation()[2] + " " + DatabaseMethods.userInformation()[3], true);
			
	}
	
	public void logout() throws IOException, InterruptedException {
		
		try {
			if(genericMethods.isDisplayed(logoutButton));
		}catch(Exception e) {
			try {
				if(genericMethods.isDisplayed(loginButton)) {
					feature.info("no user is currently logged in");
					return;
				}
			}catch(Exception t) {
				Screenshot.logFail("ERROR: Logout button not displayed", true, true);
			}
		}

		genericMethods.clickElement(logoutButton, "Logout button", true);
		genericMethods.isDisplayed(loginButton);
		feature.pass("user logged out successfully");
		
	}
	
}
