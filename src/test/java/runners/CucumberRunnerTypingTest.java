package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@TypingTest", features = {"src/test/java/features/"},
				plugin = {"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				dryRun=false,
				monochrome=true,
				glue = {"stepdefinitions.Hooks","stepdefinitions"})
public class CucumberRunnerTypingTest extends AbstractTestNGCucumberTests{

	
}
