package runners;

import java.io.File;


import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@home", features = {"src/test/java/features/home.feature"},
				plugin = {"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				dryRun=false,
				monochrome=true,
				glue = {"stepdefinitions.Hooks","stepdefinitions"})
public class CucumberRunnerHomePage extends AbstractTestNGCucumberTests{

	
}
