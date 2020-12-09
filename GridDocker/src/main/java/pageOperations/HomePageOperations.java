package pageOperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import pages.HomePage;
import utils.BasePage;

public class HomePageOperations extends HomePage {
	
	public BasePage basePage = new BasePage();
	
	public void getMenuCount() {
		try {
			int menuCount = driver.findElements(By.xpath("//ul[@class='ubermenu-nav']/li")).size();
			System.out.println("Menu Count is: "+menuCount);
			extentTest.log(Status.PASS, "Menu item Count is: "+menuCount);
		}
		catch(Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Failed to Menu item List count ");
		}
	}
	
	public void printMenuItems() {
		try {
			System.out.println("Menu Item List are:");
			for (int i=1; i <= getMenuTabs().size(); i++) {
				String menuItemText = driver.findElement(By.xpath("//ul[@class='ubermenu-nav']/li["+i+"]/a/span")).getText();
				System.out.println(menuItemText);
				extentTest.log(Status.PASS, "Menu item List Are: "+menuItemText);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Failed to Menu item List "+e.getMessage());
		}
	}
	
	public void verifyHomePageTitle() {
		try {
			String expectedTitle = "Healthcare Marketing and Medical Advertising for Doctors, Hospitals, Healthcare Networks & Pharmaceuticals";
			Assert.assertEquals(driver.getTitle(), expectedTitle);
		}
		catch(Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Title don't matched ");
		}
	}
	
	public void compareScreenshots() {
		
		try {
			String expectedSS = System.getProperty("user.dir")+"/src/test/resources/original.jpg";
			getScreenshot();
			String actualSS = System.getProperty("user.dir")+"/src/test/resources/actual.jpg";
			String diffSS = System.getProperty("user.dir")+"/src/test/resources/Difference.jpg";
			
			
			//ImageComparison imageComparison = new ImageComparison(10,10,0.05);
			
//			if(imageComparison.fuzzyEqual(expectedSS, actualSS, diffSS))
//			System.out.println("Images are Matched");
//			else
//			System.out.println("Images are not Matched");
		}
		
		catch(Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Failed to Capture screenshots");
		}
	}
	
	public void navigateToBranding() {
		try {
			basePage.mouseHover(getSerivceTab());
			Thread.sleep(2000);
			getBrandingOption().click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void captureBrandingHeadAndPara() {
		try {
			basePage.brandingHead.add(getBrandingHeadOne().getText());
			basePage.brandingHead.add(getBrandingHeadTwo().getText());
			basePage.brandingHead.add(getBrandingHeadThree().getText());
			
			basePage.brandingHeadPara.add(getParaOne().getText());
			basePage.brandingHeadPara.add(getParaTwo().getText());
			basePage.brandingHeadPara.add(getParaThree().getText());
		}
		catch(Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Failed to the extractioninto excel from barnding page");
		}
	}
	
	public void writeBrandingDateToExcel() {
		
		try {
			String Path = System.getProperty("user.dir")+"/src/test/resources/BrandingData.xlsx";
			FileInputStream fis = new FileInputStream(Path);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			Row row;
			Cell cell;
			
			for(int j=0; j<2; j++) {
				for(int i=0; i<basePage.brandingHead.size(); i++) {
					row = sheet.createRow(i);
					cell = row.createCell(j);
					if(j == 0) {
						cell.setCellType(CellType.STRING);
						cell.setCellValue(basePage.brandingHead.get(i));
					}
					else {
						cell.setCellType(CellType.STRING);
						cell.setCellValue(basePage.brandingHeadPara.get(i));
					}
				}
			}
			
			FileOutputStream fos = new FileOutputStream(Path);
			workbook.write(fos);
			fos.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterBuildDetails() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].scrollIntoView();", getFirstNameTxtBox());
			getFirstNameTxtBox().sendKeys("Vikas");
			getLastNameTxtBox().sendKeys("NK");
			getOrgNameTxtBox().sendKeys("ACC");
			getPhoneTxtBox().sendKeys("123456789");
			getEmailTxtBox().sendKeys("vikas@test.com");
			//getMessageTxtBox().sendKeys("Nothing");
		}
		
		catch(Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Failed to Enter the details");
		}
	}
	
	public void navigateToTestimonial() {
		try {
			Thread.sleep(3000);
			basePage.mouseHover(getAboutUsTab());
			Thread.sleep(3000);
			getTestimonialOption().click();
		}
		catch(Exception e) {
			e.printStackTrace();
			extentTest.log(Status.FAIL, "Failed to get Testimonial ");
		}
	}
	
	public void writeDataToTxtFile() {
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.dir")+"/src/test/resources/Review.txt");
			BufferedWriter br = new BufferedWriter(fw);
			br.write(getcustomerOne().getText().split(",")[0]);
			br.newLine();
			br.write(getcustomerOnereview().getText());
			br.newLine();
			br.newLine();
			br.write(getcustomerTwo().getText().split(",")[0]);
			br.newLine();
			br.write(getcustomerTworeview().getText());
			br.newLine();
			br.newLine();
			br.write(getcustomerThree().getText().split(",")[0]);
			br.newLine();
			br.write(getcustomerThreereview().getText());
			br.newLine();
			br.newLine();
			br.write(getcustomerFour().getText().split(",")[0]);
			br.newLine();
			br.write(customerFourreview().getText());
			br.newLine();
			br.newLine();
			br.write(getcustomerFive().getText().split(",")[0]);
			br.newLine();
			br.write(customerFivereview().getText());
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void witetoExcel() {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
		      		      
		      XSSFSheet spreadsheet = workbook.createSheet("Brand");
		      
		      XSSFRow row;
		      System.out.println(basePage.brandingHead);
		      System.out.println(basePage.brandingHeadPara);
		      Map < String, String > brandinfo = new TreeMap < String, String >();
		      brandinfo.put( basePage.brandingHead.get(0), basePage.brandingHeadPara.get(0));
		      brandinfo.put( basePage.brandingHead.get(1), basePage.brandingHeadPara.get(1));
		      brandinfo.put( basePage.brandingHead.get(2), basePage.brandingHeadPara.get(2));
		     
		      Set < String > keyid = brandinfo.keySet();
		      int rowid = 0;
		      
		      for (String key : keyid) {
		         row = spreadsheet.createRow(rowid++);
		         int cellid = 0;
		         Cell cell = row.createCell(cellid++);
		         cell.setCellValue(key);	
		         String objectArr = brandinfo.get(key);		        
		         cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr);		         
		      }
		      FileOutputStream out = new FileOutputStream(
		         new File(System.getProperty("user.dir")+"/src/test/resources/BrandingData.xlsx"));
		      
		      workbook.write(out);
		      out.close();
		      System.out.println("Writesheet.xlsx written successfully");
		   }
		
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	

}
