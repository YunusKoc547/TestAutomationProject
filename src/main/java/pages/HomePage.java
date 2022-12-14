package pages;

import java.io.IOException;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;

public class HomePage extends AbstractPage{

	GenericMethods genericMethods = new GenericMethods();
	
	By allDropdownButton = By.xpath("//a//span[text()='All']");
	By menuCustomerName = By.xpath("//div[@id='hmenu-customer-profile-right']//b[contains(text(),'Hello')]");
	By bestSellersLinkOnLeftPanel = By.xpath("//ul//a[text()='Best Sellers']");
	By bestSellersTitle = By.xpath("//span[@id='zg_banner_text' and contains(text(),'Best Sellers')]");
	By backToTopButton = By.xpath("//span[@class='navFooterBackToTopText']");
	By amazonLogo = By.xpath("//a[@id='nav-logo-spritess']");
	
	public void clickOnAllDropdownButton() throws IOException, InterruptedException, ClassNotFoundException {	
		genericMethods.clickElement(allDropdownButton,"\"All\" dropdown button",true);
		genericMethods.isDisplayed(menuCustomerName, "All Modules panel", true);
	}
	
	public void clickOnBestSellersLink() throws IOException, InterruptedException {		
		genericMethods.clickElement(bestSellersLinkOnLeftPanel,"\"Best Sellers\" link",true);	
		genericMethods.isDisplayed(bestSellersTitle, "\"Amazon Best Sellers\" title", true);
	}
	
	public void clickOnModuleLink(String moduleName) throws IOException, InterruptedException {	
		By moduleLinkOnLeftPanel = By.xpath("//ul[@class='hmenu hmenu-visible']//a[text()='"+moduleName+"']");
		By moduleTitle = By.xpath("//span[@id='zg_banner_text' and contains(text(),'"+moduleName+"')]");
		genericMethods.clickElement(moduleLinkOnLeftPanel,"\""+moduleName+"\" link",true);	
		genericMethods.isDisplayed(moduleTitle, "\""+moduleName+"\" title", true);
	}
	
	public void clickOnBackToTopButton() throws IOException, InterruptedException {			
		genericMethods.scrollIntoView(backToTopButton, "Back-to-top button");
		genericMethods.clickElement(backToTopButton, "\"Back-to-top\" button", true);
		genericMethods.isDisplayed(amazonLogo,"\"Amazon\" logo",true);
	}
}
