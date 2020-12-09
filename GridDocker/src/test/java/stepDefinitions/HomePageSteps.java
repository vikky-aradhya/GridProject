package stepDefinitions;

import com.aventstack.extentreports.Status;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageOperations.HomePageOperations;
import utils.BasePage;

public class HomePageSteps extends BasePage {
	
	public HomePageOperations homePageOperations = new HomePageOperations();
	
	@Given("^Login page is loaded$")
	public void login_page_is_loaded() throws Throwable {
		create_extentTest("Use Case One");
		homePageOperations.verifyHomePageTitle();
		extentTest.log(Status.PASS, "Home Page Title Matched");
	}

	@Given("^user take the count of menu items$")
	public void user_take_the_count_of_menu_items() throws Throwable {
		homePageOperations.getMenuCount();		
	}

	@Given("^Reterview the menu items$")
	public void reterview_the_menu_items() throws Throwable {
		homePageOperations.printMenuItems();
	}

	@Then("^user compare the actual and expected screenshots$")
	public void user_compare_the_actual_and_expected_screenshots() throws Throwable {
		homePageOperations.compareScreenshots();
		extentTest.log(Status.PASS, "Screenshot matched");
	}
	
	@Given("^Branding page loaded scuessfully$")
	public void branding_page_loaded_scuessfully() throws Throwable {
		create_extentTest("Use Case Two");
	    homePageOperations.navigateToBranding();
	    extentTest.log(Status.PASS, "Navigated to Branding Page successfully");
	}

	@And("^Extract the Header and pargraphs and write into excel$")
	public void extract_the_Header_and_pargraphs_and_write_into_excel() throws Throwable {
		homePageOperations.captureBrandingHeadAndPara();
		//homePageOperations.writeBrandingDateToExcel();
		homePageOperations.witetoExcel();
		extentTest.log(Status.PASS, "Branding data writen to excel successfully " + "<a href='C:\\Users\\vikky\\CucumberPOMFramework\\src\\test\\resources\\BrandingData.xlsx'>Click Here</a>");
	}

	@And("^Enter the value for required fields$")
	public void enter_the_value_for_required_fields() throws Throwable {
		homePageOperations.enterBuildDetails();
		extentTest.log(Status.PASS, "All user details eneterd successfully");
	}
	
	@Given("^Testimonials page loaded scuessfully$")
	public void testimonials_page_loaded_scuessfully() throws Throwable {
		create_extentTest("Use Case Three");
		homePageOperations.navigateToTestimonial();
		extentTest.log(Status.PASS, "Navigated to Testimonials Page successfully");
	}

	@And("^Extract the client name and testimonials and write to file$")
	public void extract_the_client_name_and_testimonials() throws Throwable {
		homePageOperations.writeDataToTxtFile();
		extentTest.log(Status.PASS, "All Client Testimony are extracted successfully " + "<a href='C:\\Users\\vikky\\CucumberPOMFramework\\src\\test\\resources\\Review.txt'>Click Here</a>");
	}



}
