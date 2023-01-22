package stepdefinitions;

import java.sql.SQLException;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtilities.AbstractPage;
import commonUtilities.GenericMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.bytebuddy.implementation.bind.annotation.Super;


//import cucumber.api.java.After;

public class Hooks extends AbstractPage{
	
	GenericMethods genericMethods = new GenericMethods();
	
	 @Before
	 public void before(Scenario scenario) throws ClassNotFoundException {
			 
		    this.scenario = scenario;
		    
		    extent.attachReporter(reporter);
		    System.out.println("HOOKS WORK");
		    
			String getname = scenario.getName();
			System.out.println(getname);
			
			
			if(!getname.equals("teardown")) {
				feature = extent.createTest(new GherkinKeyword("Feature"), getname);
			}else {
				feature = extent.createTest(new GherkinKeyword("Feature"), "Test End");
				extent.flush();
			}
		 
					
	 }
	 
//	 @After
//	 public void teardown() throws SQLException {
//		 
//		 genericMethods.tearDown();
//	 }

}
