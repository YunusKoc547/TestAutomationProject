package stepdefinitions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtilities.AbstractPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


//import cucumber.api.java.After;

public class Hooks extends AbstractPage{
	
	

//	public static ExtentReports extent;
//	public static ExtentTest logger;
//	
//	@Before
//	public void setUp(Scenario scenario) {
//	    ExtentSparkReporter reporter = new ExtentSparkReporter("ReportsSS\\report.html");
//	    reporter.config().setDocumentTitle("Project Name");
//	    
//	   extent = new ExtentReports();
//	   extent.attachReporter(reporter);
//	}
//
	 @Before
	 public void before(Scenario scenario) throws ClassNotFoundException {
			

		 	
		 
		    this.scenario = scenario;
		    
		    extent.attachReporter(reporter);
		    System.out.println("HOOKS WORK");
		    
			String getname = scenario.getName();
			System.out.println(getname);
			
			if(!getname.equals("teardown")) {
				feature = extent.createTest(new GherkinKeyword("Feature"), getname);
			}
		 
					
	 }
//	Scenario scenario;
//
//	   @Before
//	    public void before(Scenario scenario) {
//	        this.scenario = scenario;
//	        System.out.println("HOOKS WORKS");
//	        System.out.println(scenario.getName());
//	    }
	
//	@After
//    public void tearDown() {
//		
//		driver.quit();
//		extent.flush();	
//                 
//    }
}
