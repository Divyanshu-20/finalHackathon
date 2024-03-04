package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(features = ".//Features", // providing location of feature file in
																				// "features"
		glue = "com.IdentifyCourses.stepDefinitions" // specifying stepDefinition package name
		, plugin = { "pretty", // plugins to generate cucumber report
				"html:reports/myreport.html", // for cucumber report
				"rerun:target/rerun.txt", // capturing failure scenarios
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
		
		// Generating
		// extent
		// report

		dryRun = false, // checks mapping between scenario steps and step definition methods
		publish = true,
		monochrome = true) // To avoid junk characters in output
public class testRun extends AbstractTestNGCucumberTests {

}
