package tests;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.SignInPage;
import pages.SignUpPage;

public class Registration extends BaseClass {

	@Test(priority = 1)
	public void RegisterFirstNameMaxLengthChar() {

		System.out.println("\n-------NegativeRegistration----------");
		System.out.println("\nStarting  firstNameMaxLengthChar test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);

		signinpage.signup();
		SignUpPage signuppage = new SignUpPage(driver);
		if (!signuppage.isSignUpHeaderDisplayed()) {
			return;
		}

		signuppage.firstname("qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvb");
		if (!signuppage.ismaxLength50FirstNameDisplayed()) {
			return;
		}

		System.out.println("firstNameMaxLengthChar Test successfully");
	}

	@Test(priority = 2)
	public void RegisterLastNameMaxLengthChar() {

		System.out.println("\nStarting  laststNameMaxLengthChar test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		SignInPage signinpage = new SignInPage(driver);

		signinpage.signup();
		SignUpPage signuppage = new SignUpPage(driver);
		if (!signuppage.isSignUpHeaderDisplayed()) {
			return;
		}
	

		signuppage.lastname("qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvb");
		if (!signuppage.ismaxLength50LastNameDisplayed()) {
			return;
		}

		System.out.println("lastNameMaxLengthChar Test successfully");

	}

	@Test(priority = 3)
	public void RegisterInvalidEmailFormat() {

		System.out.println("\nStarting  invalidEmailFormat test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);

		signinpage.signup();
		SignUpPage signuppage = new SignUpPage(driver);
		if (!signuppage.isSignUpHeaderDisplayed()) {
			return;
		}

		signuppage.email("1234addgmail.com");
		if (!signuppage.isinvalidEmailFormatDisplayed()) {
			return;
		}

		System.out.println("invalidEmailFormat Test successfully");

	}

	@Test(priority = 4)
	public void RegisterPasswordLess6Characters() {

		System.out.println("\nStarting  passwordLess6Characters test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);

		signinpage.signup();
		SignUpPage signuppage = new SignUpPage(driver);
		if (!signuppage.isSignUpHeaderDisplayed()) {
			return;
		}

		signuppage.password("12345");
		if (!signuppage.isoutOfRangePasswordCharDisplayed()) {
			return;
		}

		System.out.println("passwordLess6Characters Test successfully");

	}
	
	@Test(priority = 5)
	public void RegisterPasswordMore20Characters() {

		System.out.println("\nStarting  passwordMore20Characters test");
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SignInPage signinpage = new SignInPage(driver);

		signinpage.signup();
		SignUpPage signuppage = new SignUpPage(driver);
		if (!signuppage.isSignUpHeaderDisplayed()) {
			return;
		}

		signuppage.password("1234567890123456789012");
		if (!signuppage.isoutOfRangePasswordCharDisplayed()) {
			return;
		}

//		System.out.println("passwordMore20Characters Test successfully");
		System.out.println("\n");

	}

}
