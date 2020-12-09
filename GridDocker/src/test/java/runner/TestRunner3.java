package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepDefinitions.LoginPage;
import utils.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty","html:target/cucumber"},
		features = {"src/test/resources/features"},
		glue = {"stepDefinitions/"},
		tags = {"@TestimonialsPage"},
		monochrome = true,
		dryRun = false
		)

public class TestRunner3 extends AbstractTestNGCucumberTests {
		
	@BeforeSuite
	public void setUp() throws Throwable {
		new LoginPage().user_opens_browser("firefox");
		BasePage.init_extentReport();
	}
	
	@AfterSuite
	public void tearDown() {
        BasePage.driver.quit();
        BasePage.generateExtentReport();
	}
	

}