package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BasePage {
	public static WebDriver driver = null;
	public static Properties property = null;
	public List<String> brandingHead = new ArrayList<String>();
	public List<String> brandingHeadPara = new ArrayList<String>();
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReporter;
	public static ExtentTest extentTest;
	public static ThreadLocal<ExtentTest> extentTestThreadSafe = new ThreadLocal<ExtentTest>();
	
	public void openBrowser(String browserName) throws Throwable {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
			driver.manage().window().maximize();
		}
	}
	
	public void navigateToUrl() throws Exception {
		init_properties();
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public Properties init_properties() {
		property = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
			property.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return property;
	}
	
	public void mouseHover(WebElement locator) throws Exception {
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		try {
			action.moveToElement(locator).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getScreenshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/resources/actual.jpg";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
	}
	
	public static void init_extentReport() {
		try {
			File file = new File(System.getProperty("user.dir")+"//target//Extent");
			if(!file.exists()) {
				file.mkdir();
			}
			extentHtmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"//target//Extent//ExtentReport.html"));
			extentReporter = new ExtentReports();
			extentReporter.attachReporter(extentHtmlReporter);
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}

	public static ExtentTest create_extentTest(String testName) {
		extentTest = extentReporter.createTest(testName);
		return extentTest;
	}
	
	public static void generateExtentReport() {
		extentReporter.flush();
	}

	public static synchronized ExtentTest getTest() {
		return extentTestThreadSafe.get();
	}

	public static void setTest(ExtentTest tst) {
		extentTestThreadSafe.set(tst);
	}
	
	public void closeBrowser() {
		driver.quit();
	}

}
