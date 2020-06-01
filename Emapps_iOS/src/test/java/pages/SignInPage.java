package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SignInPage extends BaseClass {

	public SignInPage() {

	}

	public SignInPage(IOSDriver<IOSElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(id = "Email")
	private IOSElement emailElement;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Email, Error: Please check your email address']")
	private IOSElement email1Element;

	@iOSXCUITFindBy(id = "Password")
	private IOSElement passwordElement;
	
	@iOSXCUITFindBy(id = "Welcome Back!")
	private IOSElement welcomeBackElement;
	
	@iOSXCUITFindBy(id = "Event Management")
	private IOSElement eventManagementElement;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sign In\"]")
	private IOSElement signInButtonElement;

	@iOSXCUITFindBy(id = "Sign Up")
	private IOSElement signUpElement;

	@iOSXCUITFindBy(id = "Forgot Password?")
	private IOSElement forgotPasswordElement;

	@iOSXCUITFindBy(id = "Toolbar Done Button")
	private IOSElement hideKeyboard;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Failed to process\"]")
	private IOSElement incorrectUserPassword;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Username or Password cannot blank\"]")
	private IOSElement blankUserPassword;

//	public boolean isSignInPageDisplayed() {
//		return eventManagementElement.isDisplayed();
//	}
	
	public boolean isSignInPageDisplayed() {
		return welcomeBackElement.isDisplayed();
	}

	public boolean incorrectUserPassDisplayed() {
		return incorrectUserPassword.isDisplayed();
	}

	public boolean blankUserPassDisplayed() {
		return blankUserPassword.isDisplayed();
	}

	public void typeEmail(String email) {
		emailElement.sendKeys(email);
	}

	public void typeEmail1(String email) {
		email1Element.sendKeys(email);
	}

	public void clearEmail() {
		emailElement.clear();
	}

	public void typePassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clearPassword() {
		passwordElement.clear();
	}

	public void clickSigIn() {
		signInButtonElement.click();
	}

	public void clickSignUp() {
		signUpElement.click();
	}

	public void clickForgotPassword() {
		forgotPasswordElement.click();
	}

	public void clickDoneButtonKeyboard() {
		hideKeyboard.click();
	}

	public void login(String name, String password) {
		
		clearEmail();
		typeEmail(name);
		clickDoneButtonKeyboard();
		typePassword(password);
		clickDoneButtonKeyboard();
		clickSigIn();
	}

	public void negatiflogin(String name, String password) {

		clearEmail();
		typeEmail(name);
		clickDoneButtonKeyboard();
		clearPassword();
		typePassword(password);
		clickDoneButtonKeyboard();
		clickSigIn();
	}

	public void negatiflogin1(String name, String password) {

		typeEmail1(name);
		clickDoneButtonKeyboard();
		clearPassword();
		typePassword(password);
		clickDoneButtonKeyboard();
		clickSigIn();
	}

	public void negatiflogin2(String name, String password) {

		clearEmail();
		clickDoneButtonKeyboard();
		clickSigIn();
	}

	public void signup() {

		clickSignUp();
	}

	/**
    *
    * @return the login message
    */
   public String getErrorMessage1() {
       return driver.findElementById("Username or Password was incorrect").getText();
   }
	
   public String getErrorMessage2() {
       return driver.findElementById("Username or Password cannot blank").getText();
   }
	
}
