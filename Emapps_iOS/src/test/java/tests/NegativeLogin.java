package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.SignInPage;

public class NegativeLogin extends BaseClass {
	
	

	@Test(priority = 1)
	public void invalidUsername() {
		
		System.out.println("\n-------NegativeLogin---------");
		System.out.println("\nStarting invalidUsername test");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInDisplayed()) {
			return;
		}

		signinpage.login("mrahmanh10@gmail.com", "ccgl0618");
		if (!signinpage.incorrectUserPassDisplayed()) {
			return;
		}

		System.out.println("invalidUsername test successfully");
	}

	@Test(priority = 3)
	public void blankUsername() {

		System.out.println("\nStarting blankUsername test");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInDisplayed()) {
			return;
		}

		signinpage.negatiflogin("", "ccgl0618");
		if (!signinpage.blankUserPassDisplayed()) {
			return;
		}

		System.out.println("blankUsername test successfully");
	}

	@Test(priority = 2)
	public void invalidPassword() {

		System.out.println("\nStarting invalidPassword test");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInDisplayed()) {
			return;
		}

		signinpage.negatiflogin("mrahmanh@gmail.com", "ccgl0618+");
		if (!signinpage.incorrectUserPassDisplayed()) {
			return;
		}

		System.out.println("invalidPassword test successfully");
	}

	@Test(priority = 4)
	public void blankPassword() {

		System.out.println("\nStarting blankPassword test");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInDisplayed()) {
			return;
		}

		signinpage.negatiflogin1("mrahmanh@gmail.com", "");
		if (!signinpage.blankUserPassDisplayed()) {
			return;
		}

		System.out.println("blankPassword test successfully");
	}

	@Test(priority = 5)
	public void blankUsernameAndPassword() {

		System.out.println("\nStarting blankUsernameAndPassword test");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);
		if (!signinpage.isSignInDisplayed()) {
			return;
		}

		signinpage.negatiflogin2("", "");
		if (!signinpage.blankUserPassDisplayed()) {
			return;
		}

		System.out.println("blankUsernameAndPassword test successfully");
		System.out.println("\n");
	}

}
