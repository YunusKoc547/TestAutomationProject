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

	
	
	public void connectToDatabase() throws SQLException, ClassNotFoundException {
		DatabaseMethods.databaseConnection();
//		DatabaseMethods.emailAndPasswordPair();
	}
	
}
