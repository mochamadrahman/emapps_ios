package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.HomeScreenPage;
import pages.SignInPage;

public class PositiveLogin extends BaseClass {

	@Test(priority = 1)
	public void testLogin() {

		System.out.println("\nStarting Login test");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInDisplayed()) {
			return;
		}

		signinpage.login("mrahmanh@gmail.com", "ccgl0618");
		HomeScreenPage homescreenpage = new HomeScreenPage(driver);
		if (!homescreenpage.isloginSuccessfulyDisplayed()) {
			return;
		}

		System.out.println("Login Test successfully");
		System.out.println("\n");

	}
}
