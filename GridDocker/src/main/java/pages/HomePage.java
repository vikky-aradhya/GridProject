package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(xpath = "//span[text()='Services']")
	private WebElement serivceTab;
	
	@FindBy(xpath = "//span[text()='Branding']")
	private WebElement brandingOption;
	
	@FindBy(xpath = "//h2[text()='Your brand is who you are. Be your best.']")
	private WebElement brandingHeadOne;
	
	@FindBy(xpath = "//h2[text()='Developing and communicating how and why you’re different.']")
	private WebElement brandingHeadTwo;
	
	@FindBy(xpath = "//h2[text()='Experienced professionals who have created thousands of brands.']")
	private WebElement brandingHeadThree;
	
	@FindBy(xpath = "//h2[text()='Your brand is who you are. Be your best.']/following-sibling::p")
	private WebElement paraOne;
	
	@FindBy(xpath = "//h2[text()='Developing and communicating how and why you’re different.']/following-sibling::p")
	private WebElement paraTwo;
	
	@FindBy(xpath = "//h2[text()='Experienced professionals who have created thousands of brands.']/following-sibling::p")
	private WebElement paraThree;
	
	@FindBy(xpath = "(//input[@name='firstname'])[3]")
	private WebElement firstNameTxtBox;
	
	@FindBy(xpath = "(//input[@name='lastname'])[3]")
	private WebElement lastNameTxtBox;
	
	@FindBy(xpath = "(//input[@name='company'])[3]")
	private WebElement organizationTxtBox;
	
	@FindBy(xpath = "(//input[@name='phone'])[2]")
	private WebElement phoneTxtBox;
	
	@FindBy(xpath = "(//input[@name='email'])[3]")
	private WebElement emailTxtBox;
	
	@FindBy(xpath = "(//textarea[@name='message'])")
	private WebElement messageTxtBox;
	
	@FindBy(xpath = "//span[text()='About Us']")
	private WebElement aboutUsTab;
	
	@FindBy(xpath = "//span[text()='Testimonials']")
	private WebElement testimonialsOption;
	
	@FindBy(xpath = "//article/section/div/p[2]/strong")
	private WebElement customerOne;
	
	@FindBy(xpath = "//article/section/div/p[4]/strong")
	private WebElement customerTwo;
	
	@FindBy(xpath = "//article/section/div/p[6]/strong")
	private WebElement customerThree;
	
	@FindBy(xpath = "(//article/section/div[4]/p/strong)[1]")
	private WebElement customerFour;
	
	@FindBy(xpath = "(//article/section/div[4]/p/strong)[2]")
	private WebElement customerFive;
	
	@FindBy(xpath = "//article/section/div/p[1]/em")
	private WebElement customerOnereview;
	
	@FindBy(xpath = "//article/section/div/p[2]/em")
	private WebElement customerTworeview;
	
	@FindBy(xpath = "//article/section/div/p[3]/em")
	private WebElement customerThreereview;
	
	@FindBy(xpath = "//article/section/div/p[4]/em")
	private WebElement customerFourreview;
	
	@FindBy(xpath = "//article/section/div/p[5]/em")
	private WebElement customerFivereview;
	
	private List<WebElement> menutabs = driver.findElements(By.xpath("//ul[@class='ubermenu-nav']/li"));
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getMenuTabs() {
		return menutabs;
	}
	
	public WebElement getSerivceTab() {
		return serivceTab;
	}
	
	public WebElement getBrandingOption() {
		return brandingOption;
	}
	
	public WebElement getBrandingHeadOne() {
		return brandingHeadOne;
	}
	
	public WebElement getBrandingHeadTwo() {
		return brandingHeadTwo;
	}
	
	public WebElement getBrandingHeadThree() {
		return brandingHeadThree;
	}
	
	public WebElement getParaOne() {
		return paraOne;
	}
	
	public WebElement getParaTwo() {
		return paraTwo;
	}
	
	public WebElement getParaThree() {
		return paraThree;
	}
	
	public WebElement getFirstNameTxtBox() {
		return firstNameTxtBox;
	}
	
	public WebElement getLastNameTxtBox() {
		return lastNameTxtBox;
	}
	
	public WebElement getOrgNameTxtBox() {
		return organizationTxtBox;
	}
	
	public WebElement getPhoneTxtBox() {
		return phoneTxtBox;
	}
	
	public WebElement getEmailTxtBox() {
		return emailTxtBox;
	}
	
	public WebElement getMessageTxtBox() {
		return messageTxtBox;
	}
	
	public WebElement getAboutUsTab() {
		return aboutUsTab;
	}
	
	public WebElement getTestimonialOption() {
		return testimonialsOption;
	}
	
	public WebElement getcustomerOne() {
		return customerOne;
	}
	
	public WebElement getcustomerTwo() {
		return customerTwo;
	}
	
	public WebElement getcustomerThree() {
		return customerThree;
	}
	
	public WebElement getcustomerFour() {
		return customerFour;
	}
	
	public WebElement getcustomerFive() {
		return customerFive;
	}
	
	public WebElement getcustomerOnereview() {
		return customerOnereview;
	}
	
	public WebElement getcustomerTworeview() {
		return customerTworeview;
	}
	
	public WebElement getcustomerThreereview() {
		return customerThreereview;
	}
	
	public WebElement customerFourreview() {
		return customerFourreview;
	}
	
	public WebElement customerFivereview() {
		return customerFivereview;
	}
	
	

}
