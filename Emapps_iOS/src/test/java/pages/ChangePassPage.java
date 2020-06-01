package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ChangePassPage extends BaseClass {

	public ChangePassPage() {

	}

	public ChangePassPage(IOSDriver<IOSElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(id = "Create New Password")
	private IOSElement createNewPasswordElement;

	@iOSXCUITFindBy(id = "Old Password")
	private IOSElement oldPasswordElement;

	@iOSXCUITFindBy(id = "Old Password, Error: Password is less than 6 Characters")
	private IOSElement oldPasswordErrorElement;

	@iOSXCUITFindBy(id = "New Password")
	private IOSElement newPasswordElement;

	@iOSXCUITFindBy(id = "New Password, Error: Password is less than 6 Characters")
	private IOSElement newPasswordErrorElement;

	@iOSXCUITFindBy(id = "Repeat New Password")
	private IOSElement repeatNewPasswordElement;

	@iOSXCUITFindBy(id = "Repeat New Password, Error: Password is less than 6 Characters")
	private IOSElement repeatNewPasswordErrorElement;

	@iOSXCUITFindBy(id = "Confirm Password Changes")
	private IOSElement confirmPasswordChangesButtonElement;

	@iOSXCUITFindBy(id = "Toolbar Done Button")
	private IOSElement hideKeyboard;

	@iOSXCUITFindBy(id = "Repeat New Password, Error: Re-Enter Password did not match with New Password")
	private IOSElement errorRepeatNewPasswordElement;

	@iOSXCUITFindBy(id = "Please input the correct old password")
	private IOSElement invalidOldPasswordElement;

	@iOSXCUITFindBy(id = "Your password is successfully changed.")
	private IOSElement successChangePasswordElement;

	@iOSXCUITFindBy(id = "Back")
	private IOSElement backButtonElement;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Clear text\"])[1]")
	private IOSElement clearText1Element;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Clear text\"])[2]")
	private IOSElement clearText2Element;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Clear text\"])[3]")
	private IOSElement clearText3Element;

	/************************************************************/

	public boolean iscreateNewPasswordDisplayed() {
		return createNewPasswordElement.isDisplayed();
	}

	public boolean iserrorRepeatNewPasswordDisplayed() {
		return errorRepeatNewPasswordElement.isDisplayed();
	}

	public boolean isInvalidOldPasswordDisplayed() {
		return invalidOldPasswordElement.isDisplayed();
	}

	public boolean isSuccessChangePasswordDisplayed() {
		return successChangePasswordElement.isDisplayed();
	}

	public void typeOldPassword(String oldpassword) {
		oldPasswordElement.sendKeys(oldpassword);
	}

	public void typeOldPassword1(String oldpassword) {
		oldPasswordErrorElement.sendKeys(oldpassword);
	}

	public void typeNewPassword(String newpassword) {
		newPasswordElement.sendKeys(newpassword);
	}

	public void typeNewPassword1(String newpassword) {
		newPasswordErrorElement.sendKeys(newpassword);
	}

	public void typeRepeatNewPassword(String repeatnewpassword) {
		repeatNewPasswordElement.sendKeys(repeatnewpassword);
	}

	public void typeRepeatNewPassword1(String repeatnewpassword) {
		repeatNewPasswordErrorElement.sendKeys(repeatnewpassword);
	}

	public void clickOldPassword() {
		oldPasswordElement.click();
	}

	public void clickNewPassword() {
		newPasswordElement.click();
	}

	public void clickRepeatNewPasswordError() {
		repeatNewPasswordErrorElement.click();
	}

	public void clickRepeatNewPassword() {
		repeatNewPasswordElement.click();
	}

	public void clickDoneButtonKeyboard() {
		hideKeyboard.click();
	}

	public void clickBackButton() {
		backButtonElement.click();
	}

	public void clickClearTextOldPassword() {
		clearText1Element.click();
	}

	public void clickClearTextNewPassword() {
		clearText2Element.click();
	}

	public void clickClearTextRepeatNewPassword() {
		clearText3Element.click();
	}

	public void clickConfirmPasswordChanges() {
		confirmPasswordChangesButtonElement.click();
	}

	/***********************************************************/

	public void changePassword(String oldpassword, String newpassword, String repeatnewpassword) {

		typeOldPassword(oldpassword);
		clickDoneButtonKeyboard();
		typeNewPassword(newpassword);
		clickDoneButtonKeyboard();
		typeRepeatNewPassword(repeatnewpassword);
		clickDoneButtonKeyboard();
		clickConfirmPasswordChanges();
	}

	public void loginWithNewPassword(String oldpassword, String newpassword, String repeatnewpassword) {

		typeOldPassword(oldpassword);
		clickDoneButtonKeyboard();
		typeNewPassword(newpassword);
		clickDoneButtonKeyboard();
		typeRepeatNewPassword(repeatnewpassword);
		clickDoneButtonKeyboard();
		clickConfirmPasswordChanges();
	}

	public void differentNewPassword(String oldpassword, String newpassword, String repeatnewpassword) {

		typeOldPassword(oldpassword);
		clickDoneButtonKeyboard();
		typeNewPassword(newpassword);
		clickDoneButtonKeyboard();
		typeRepeatNewPassword(repeatnewpassword);
		clickDoneButtonKeyboard();
	}

	public void invalidOldPassword(String oldpassword, String newpassword, String repeatnewpassword) {

		clickOldPassword();
		clickClearTextOldPassword();
		typeOldPassword1(oldpassword);
		clickDoneButtonKeyboard();
		clickNewPassword();
		clickClearTextNewPassword();
		typeNewPassword1(newpassword);
		clickDoneButtonKeyboard();
		clickRepeatNewPassword();
		clickClearTextRepeatNewPassword();
		typeRepeatNewPassword1(repeatnewpassword);
		clickDoneButtonKeyboard();
		clickConfirmPasswordChanges();

	}

	public void cancelChangePassword() {
		clickBackButton();
	}

}
