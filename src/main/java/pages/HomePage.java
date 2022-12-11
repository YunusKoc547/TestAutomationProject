package pages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;

public class HomePage extends AbstractPage{

	GenericMethods genericMethods = new GenericMethods();
	
	By allDropdownButton = By.xpath("//a//span[text()='All']");
	By menuCustomerName = By.xpath("//div[@id='hmenu-customer-profile-right']//b[contains(text(),'Hello')]");
	By bestSellersLinkOnLeftPanel = By.xpath("//ul//a[text()='Best Sellers']");
	By bestSellersTitle = By.xpath("//span[@id='zg_banner_text' and contains(text(),'Best Sellers')]");
	
	public void clickOnAllDropdownButton() throws IOException {		
		genericMethods.clickElement(allDropdownButton,"\"All\" dropdown button",true);
		genericMethods.isDisplayed(menuCustomerName, "Menu Customer Name", true);
	}
	
	public void clickOnBestSellersLink() throws IOException {		
		genericMethods.clickElement(bestSellersLinkOnLeftPanel,"\"Best Sellers\" link",true);	
		genericMethods.isDisplayed(bestSellersTitle, "\"Amazon Best Sellers\" title", true);
	}
}
