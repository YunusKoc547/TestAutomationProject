package commonUtilities;

import io.cucumber.java.After;

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

	@After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
        driver.quit();
		extent.flush();
    }
	
//	@After
//    public void tearDown() {
//		
//		driver.quit();
//		extent.flush();	
//                 
//    }
}
