package pages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;

public class HomePage extends AbstractPage{


	GenericMethods genericMethods = new GenericMethods();
	
	By allDropdownButton = By.xpath("//a//span[text()='All']");
	
	
	public void clickOnAllDropdownButton() throws IOException {		
		genericMethods.clickElement(allDropdownButton,"\"All\" dropdown button",true);		
	}
	
	By allDropdownButton1 = By.xpath("//a//span[text()='All1']");
	public void clickOnAllDropdownButton1() throws IOException {		
		genericMethods.clickElement(allDropdownButton1,"\"All1\" dropdown button",true);		
	}
	
	
}
