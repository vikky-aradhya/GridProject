package runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import stepDefinitions.LoginPage;
import utils.BasePage;

public class CucumberRunner {
	
	public String gluePackage = "stepDefinitions/";
	public String featurePackage = "src/test/resources/features";
	public String[] argv = null;
	
	public void defaultRun(String[] tagsToExecute) {
		List<String> arguments = new ArrayList<String>();
		arguments.add(featurePackage);
		String[] tags = tagsToExecute;
		for(String tag : tags) {
			arguments.add("--tags");
			arguments.add(tag);
		}
		
		arguments.add("--plugin");
		arguments.add("pretty");
		
		arguments.add("--glue");
		arguments.add(gluePackage);
		
		arguments.add("--monochrome");
		
		argv = arguments.toArray(new String[arguments.size()]);
		try {
			executeTests(argv);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public byte executeTests(final String[] argv) throws Exception {
		RuntimeOptions runtimeOptions = new RuntimeOptions(new ArrayList(Arrays.asList(argv)));
		
		MultiLoader multiLoader = new MultiLoader(this.getClass().getClassLoader());
		ResourceLoaderClassFinder classFinder = new ResourceLoaderClassFinder(multiLoader, this.getClass().getClassLoader());
		Runtime runTime = new Runtime(multiLoader, classFinder, this.getClass().getClassLoader(), runtimeOptions);
		runTime.run();
		System.out.println(runTime.exitStatus());
        return runTime.exitStatus();
	}
	
	@Parameters({"browserName", "tagsToRun"})
	@Test
	public void main(String browserName, String tags) throws Throwable {
		System.out.println("Running Cucumber Tests");
		setUp(browserName);
		CucumberRunner cucumberRunner = new CucumberRunner();
		String[] tagsToExecute = tags.split(",");
		cucumberRunner.defaultRun(tagsToExecute);
	}
	
	public static void setUp(String browserName) throws Throwable {
		new LoginPage().user_opens_browser(browserName);
		BasePage.init_extentReport();
	}
	
	@AfterSuite
	public void tearDown() {
        BasePage.driver.quit();
        BasePage.generateExtentReport();
	}

}
