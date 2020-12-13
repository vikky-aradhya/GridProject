package runner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class SuiteRunner {

	public void runTestNGTests(String[] chromeTagList, String[] firefoxTagList) throws IOException {

		List<XmlSuite> suiteList = new ArrayList<XmlSuite>();
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("Test Suite");
		xmlSuite.setParallel(ParallelMode.TESTS);
		xmlSuite.setThreadCount(Integer.parseInt(System.getProperty("threadCount")));

		List<XmlTest> listTest = new ArrayList<XmlTest>();
		List<XmlClass> listClass = new ArrayList<XmlClass>();
		listClass.add(new XmlClass(CucumberRunner.class));

		if(!chromeTagList[0].isEmpty()) {
			for (int i = 1; i <= chromeTagList.length; i++) {
				Map<String, String> chromeTags = new LinkedHashMap<String, String>();
				chromeTags.put("browserName", "chrome");
				chromeTags.put("tagsToRun", chromeTagList[i - 1]);
				XmlTest xmlTest = new XmlTest(xmlSuite);
				xmlTest.setName("AutomationChromeTest_" + i);
				xmlTest.setParameters(chromeTags);
				xmlTest.setXmlClasses(listClass);
				listTest.add(xmlTest);
			}
		}

		if(!firefoxTagList[0].isEmpty()) {
			for (int i = 1; i <= firefoxTagList.length; i++) {
				Map<String, String> firefoxTags = new LinkedHashMap<String, String>();
				firefoxTags.put("browserName", "firefox");
				firefoxTags.put("tagsToRun", firefoxTagList[i - 1]);
				XmlTest xmlTest = new XmlTest(xmlSuite);
				xmlTest.setName("AutomationFirefoxTest_" + i);
				xmlTest.setParameters(firefoxTags);
				xmlTest.setXmlClasses(listClass);
				listTest.add(xmlTest);
			}
		}

		xmlSuite.setTests(listTest);
		suiteList.add(xmlSuite);
		
		FileWriter writer = new FileWriter(new File(System.getProperty("user.dir")+"/testng.xml"));
		writer.write(xmlSuite.toXml());
		writer.flush();
		writer.close();

		TestNG testNG = new TestNG();
		testNG.setXmlSuites(suiteList);

		testNG.run();
	}

	public static void main(String[] args) throws IOException {
		
		String[] chromeTags = System.getProperty("chromeTags").split(",");
		String[] firefoxTags = System.getProperty("firefoxTags").split(",");
		SuiteRunner runner = new SuiteRunner();
		runner.runTestNGTests(chromeTags, firefoxTags);

	}

}
