package stepDefinitions;

import utils.BasePage;

public class LoginPage extends BasePage {

	public void user_opens_browser(String browserName) throws Throwable {
		try {
			openBrowser(browserName);
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			navigateToUrl();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
