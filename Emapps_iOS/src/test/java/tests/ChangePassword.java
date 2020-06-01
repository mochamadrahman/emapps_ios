package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.BaseClass;
import pages.ChangePassPage;
import pages.HomeScreenPage;
import pages.ProfilePage;
import pages.SignInPage;

public class ChangePassword extends BaseClass {

	public static ExtentTest parentTest;

	@Test(priority = 1)
	public void successChangePassword() {

		System.out.println("\n-------ChangePasswordScenarioTest---------");

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
		if (!profilepage.isWelcomeBackDisplayed()) {
			return;
		}

		System.out.println("\nStarting Success Change Password Test");

		profilepage.clickPasswordChange();

		ChangePassPage changepasspage = new ChangePassPage(driver);
		if (!changepasspage.iscreateNewPasswordDisplayed()) {
			return;
		}
		

		changepasspage.changePassword("ccgl0618", "mrhh1975", "mrhh1975");
		if (!changepasspage.isSuccessChangePasswordDisplayed()) {
			return;
		}
	
		if (!profilepage.isWelcomeBackDisplayed()) {
			return;
		}
		profilepage.clickSignOut();

		System.out.println("Success Change Password Test successfully");
		System.out.println("\n");

	}

	@Test(priority = 2)
	public void loginWithNewPassword() {

		System.out.println("\nStarting Login with New Password Test");

		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInPageDisplayed()) {
			return;
		}

		signinpage.login("mrahmanh@gmail.com", "mrhh1975");

		HomeScreenPage homescreenpage = new HomeScreenPage(driver);

		System.out.println("Starting Login with New Password Test successfully");
		System.out.println("\n");

		homescreenpage.clickMore();

		ProfilePage profilepage = new ProfilePage(driver);
		if (!profilepage.isWelcomeBackDisplayed()) {
			return;
		}

		profilepage.clickPasswordChange();

		ChangePassPage changepasspage = new ChangePassPage(driver);
		
		changepasspage.changePassword("mrhh1975", "ccgl0618", "ccgl0618");
		
	}

	@Test(priority = 3)
	public void differentNewPassword() {
		
		ProfilePage profilepage = new ProfilePage(driver);
		profilepage.clickPasswordChange();

		System.out.println("Starting Different New Password Test");

		ChangePassPage changepasspage = new ChangePassPage(driver);

		changepasspage.differentNewPassword("ccgl0618", "mrhh1975", "mrhh19756");
		if (!changepasspage.iserrorRepeatNewPasswordDisplayed()) {
			return;
		}

		System.out.println("Different New Password Test successfully");
		System.out.println("\n");

	}

	@Test(priority = 4)
	public void invalidOldPassword() {

		System.out.println("Starting Invalid Old Password Test");

		ChangePassPage changepasspage = new ChangePassPage(driver);
		changepasspage.invalidOldPassword("ccgl06189", "mrhh1975", "mrhh1975");
		if (!changepasspage.isInvalidOldPasswordDisplayed()) {
			return;
		}

		System.out.println("Invalid Old Password Test successfully");
		System.out.println("\n");
	}


}
