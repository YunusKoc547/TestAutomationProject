package cookieClicker;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GameInit {

	static WebDriver driver;
	public static void initializeCookieClicker() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/main/java//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://orteil.dashnet.org/cookieclicker/");
		driver.findElement(selectLanguageAsEnglish).click();
		
	}
	
	public static void clickCookie() {
//		WebDriverWait wait = new WebDriverWait(driver,1);
		By unlockedProduct = By.xpath("//div[@class='product unlocked enabled']");
		By upgradeButton = By.xpath("//div[@class='crate upgrade enabled']");
		By cookie = By.xpath("//button[@id='bigCookie']");
		while(true) {
			driver.findElement(cookie).click();
			try {
				driver.findElement(unlockedProduct).click();
			}catch(Exception e) {
				driver.findElement(cookie).click();
			}
			
			try {
				driver.findElement(upgradeButton).click();
			}catch(Exception e) {
				driver.findElement(cookie).click();
			}
			
		}
	}
	
	static By selectLanguageAsEnglish = By.xpath("//div[@id='langSelect-EN']");
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
		
		try {
			initializeCookieClicker();	
		}catch(Exception e) {
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.findElement(selectLanguageAsEnglish).click();
		}
		
		Thread.sleep(5000);
		
		
		clickCookie();	

		teardown();
	}
	
	public static void teardown() {
		driver.quit();
	}
}
