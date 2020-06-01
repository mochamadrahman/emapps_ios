package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.BaseClass;
import pages.ChangePassPage;
import pages.HomeScreenPage;
import pages.ProfilePage;
import pages.SignInPage;

public class CancelChangePassword extends BaseClass {

	public static ExtentTest parentTest;

	@Test(priority = 1)
	public void cancelChangePassword() {

		System.out.println("\n-------CancelChangePasswordScenarioTest---------");
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInPageDisplayed()) {
			return;
		}

		signinpage.login("mrahmanh@gmail.com", "ccgl0618");

		HomeScreenPage homescreenpage = new HomeScreenPage(driver);
		if (!homescreenpage.isloginSuccessfulyDisplayed()) {
			return;
		}

		homescreenpage.clickMore();

		ProfilePage profilepage = new ProfilePage(driver);
		profilepage.clickPasswordChange();

		System.out.println("\nStarting Cancel Change Password Test");

		ChangePassPage changepasspage = new ChangePassPage(driver);
		changepasspage.cancelChangePassword();

		if (!profilepage.isWelcomeBackDisplayed()) {
			return;
		}

		System.out.println("Cancel Change Password Test successfully");
		System.out.println("\n");

	}
}
