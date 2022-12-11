package commonUtilities;

import java.io.File;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class AbstractPage {

	public static WebDriver driver;
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTest test;
	public static ExtentSparkReporter reporter;
	public static Properties prop;
	public static FileInputStream fileInput;
	
//	static Scenario scenario = new Scenario();
	
	
	GenericMethods genericMethods;
	public void initialize() {	
		
//		try {driver.getTitle(); 
//		}catch(Exception  t) {
		
		
//			if(driver.toString().equals(null) || driver.toString().isEmpty() || driver.equals(null) || driver==null || driver.getTitle().isEmpty() || driver.getTitle().equals(null)) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmm");  
			LocalDateTime now = LocalDateTime.now();  
			genericMethods = new GenericMethods();
			reporter = new ExtentSparkReporter("Reports/AutomationReport"+dtf.format(now)+".html");
		//  reporter.config().setDocumentTitle("Project Name");
			    
			extent = new ExtentReports();
		    extent.attachReporter(reporter);
			test = extent.createTest("Automation Execution report");
			   
			
					
				File file = new File(System.getProperty("user.dir") + "//src//test//resources//config.properties");
					
					
				try {
					fileInput = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
					
				prop = new Properties();
					
				//load properties file
				try {
					prop.load(fileInput);
				} catch (IOException e) {
					e.printStackTrace();
				}
					
					
					
				System.out.println(prop.getProperty("browser"));
				if(prop.getProperty("browser").equals("Chrome")) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/main/java//drivers//chromedriver.exe");
					driver = new ChromeDriver();
				}else if(prop.getProperty("browser").equals("Edge")) {
					System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//drivers//msedgedriver.exe");
					driver = new EdgeDriver();
				}
					
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				genericMethods.navigateTo(prop.getProperty("url"), prop.getProperty("url"), true);

		//		pageObjectManager = new PageObjectManager(driver);
			
//		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}

