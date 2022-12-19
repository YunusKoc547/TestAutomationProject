package commonUtilities;

import java.io.File;





import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.Scenario;

public class AbstractPage {

	public static WebDriver driver;
	
	public static ExtentSparkReporter reporter;
	
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest logger;
	public static ExtentTest test= extent.createTest("Test Start");
	
	public static Properties prop;
	public static FileInputStream fileInput;
	
	public static ExtentTest feature;
//	public static ExtentTest scenario;
	public Scenario scenario;
	
//	static Scenario scenario = new Scenario();
	 
	GenericMethods genericMethods;
	
	public WebDriver initialize() throws IOException, InterruptedException, ClassNotFoundException {	
		genericMethods = new GenericMethods();
		
			    					
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmm");  
		LocalDateTime now = LocalDateTime.now();  
				
		reporter = new ExtentSparkReporter("Reports/AutomationReport"+dtf.format(now)+".html");
		
		
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
					
					
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
					
		System.out.println(prop.getProperty("browser"));
		if(browserName.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/main/java//drivers//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
				driver.manage().window().setSize(new Dimension(1920,1080));
			}
			
			driver = new ChromeDriver(options);
		}else if(browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//src/main/java//drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
					
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		genericMethods.navigateTo(prop.getProperty("url"), prop.getProperty("url"), true);
		
		return driver;
		

	}
}

