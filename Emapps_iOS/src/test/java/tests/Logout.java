package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.HomeScreenPage;
import pages.ProfilePage;
import pages.SignInPage;

public class Logout extends BaseClass {

	@Test(priority = 1)
	public void testLogout() {

		System.out.println("\nStarting Logout test");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInDisplayed()) {
			return;
		}

		signinpage.login("mrahmanh@gmail.com", "ccgl0618");
		HomeScreenPage homescreenpage = new HomeScreenPage(driver);
		if (!homescreenpage.isFavoritesDisplayed()) {
			return;
		}

		homescreenpage.clickMore();

		ProfilePage profilepage = new ProfilePage(driver);
		if (!profilepage.welcomeBack()) {
			return;
		}

		profilepage.clickSignOut();

		if (!signinpage.isSignInDisplayed()) {
			return;
		}

		System.out.println("Logout Test successfully");
		System.out.println("\n");
	}

}
