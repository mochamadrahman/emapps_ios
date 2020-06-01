package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.BaseClass;
import pages.HomeScreenPage;
import pages.ProfilePage;
import pages.SignInPage;

public class LoginLogout extends BaseClass {
	
	
	public static ExtentTest parentTest;
	
	@Test(priority = 1)
	public void Login() {


		System.out.println("\n-------PositiveLogIn---------");
		System.out.println("\nStarting Login test");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

		
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInPageDisplayed()) {
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
	
	@Test(priority = 2)
	public void Logout() {
		
		
		System.out.println("\n-------LogOut---------");
		System.out.println("\nStarting Logout test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		HomeScreenPage homescreenpage = new HomeScreenPage(driver);
		if (!homescreenpage.isFavoritesDisplayed()) {
			return;
		}

		homescreenpage.clickMore();

		ProfilePage profilepage = new ProfilePage(driver);
		if (!profilepage.isWelcomeBackDisplayed()) {
			return;
		}

		profilepage.clickSignOut();
		
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInPageDisplayed()) {
			return;
		}

		System.out.println("Logout Test successfully");
		System.out.println("\n");

	}
	
	@Test(priority = 3)
	public void LoginInvalidUsername() {
		
		
		System.out.println("\n-------NegativeLogIn---------");
		System.out.println("\nStarting loginInvalidUsername test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInPageDisplayed()) {
			return;
		}

		signinpage.login("mrahmanh1@gmail.com", "password1");
		if (!signinpage.incorrectUserPassDisplayed()) {
			return;
		}

		System.out.println("loginInvalidUsername test successfully");

	}

	@Test(priority = 5)
	public void LoginBlankUsername() {
		
		
		System.out.println("\nStarting loginBlankUsername test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInPageDisplayed()) {
			return;
		}

		signinpage.negatiflogin("", "ccgl0618");
		if (!signinpage.blankUserPassDisplayed()) {
			return;
		}

		System.out.println("loginBlankUsername test successfully");

	}

	@Test(priority = 4)
	public void LoginInvalidPassword() {
		
		
		System.out.println("\nStarting loginInvalidPassword test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInPageDisplayed()) {
			return;
		}

		signinpage.negatiflogin("emapps.mitrais@gmail.com", "password2");
		if (!signinpage.incorrectUserPassDisplayed()) {
			return;
		}

		System.out.println("loginInvalidPassword test successfully");

	}

	@Test(priority = 6)
	public void LoginBlankPassword() {
		
		
		System.out.println("\nStarting loginBlankPassword test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInPageDisplayed()) {
			return;
		}

		signinpage.negatiflogin1("mrahmanh@gmail.com", "");
		if (!signinpage.blankUserPassDisplayed()) {
			return;
		}

		System.out.println("loginBlankPassword test successfully");

	}

	@Test(priority = 7)
	public void LoginBlankUsernameAndPassword() {
	
		
		System.out.println("\nStarting loginBlankUsernameAndPassword test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInPageDisplayed()) {
			return;
		}

		signinpage.negatiflogin2("", "");
		if (!signinpage.blankUserPassDisplayed()) {
			return;
		}

		System.out.println("loginBlankUsernameAndPassword test successfully");
		System.out.println("\n");

	}

}

