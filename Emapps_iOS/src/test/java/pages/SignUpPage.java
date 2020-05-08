package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SignUpPage extends BaseClass {

	public SignUpPage() {

	}

	public SignUpPage(IOSDriver<IOSElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(id = "Firstname")
	private IOSElement firstNameElement;

	@iOSXCUITFindBy(id = "Lastname")
	private IOSElement lastNameElement;

	@iOSXCUITFindBy(id = "Email")
	private IOSElement emailSignUpElement;

	@iOSXCUITFindBy(id = "Password")
	private IOSElement passwordSignUpElement;

	@iOSXCUITFindBy(id = "Gender")
	private IOSElement genderElement;

	@iOSXCUITFindBy(id = "Home Address")
	private IOSElement homeAddressElement;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign Up\"]")
	private IOSElement signUpHeaderElement;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Clear text\"])[1]")
	private IOSElement clearText1Element;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Clear text\"])[2]")
	private IOSElement clearText2Element;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Clear text\"])[3]")
	private IOSElement clearText3Element;

	@iOSXCUITFindBy(id = "Firstname, Error: Maximum length is 50")
	private IOSElement maxLength50FirstNameElement;

	@iOSXCUITFindBy(id = "Lastname, Error: Maximum length is 50")
	private IOSElement maxLength50LastNameElement;

	@iOSXCUITFindBy(id = "Email, Error: Please check your email address")
	private IOSElement invalidEmailFormatElement;

	@iOSXCUITFindBy(id = "Password, Error: Password must consist of 6-20 characters")
	private IOSElement outOfRangePasswordCharElement;

	/************************************************************/

	public boolean isSignUpHeaderDisplayed() {
		return signUpHeaderElement.isDisplayed();
	}

	public boolean ismaxLength50FirstNameDisplayed() {
		return maxLength50FirstNameElement.isDisplayed();
	}

	public boolean ismaxLength50LastNameDisplayed() {
		return maxLength50LastNameElement.isDisplayed();
	}

	public boolean isinvalidEmailFormatDisplayed() {
		return invalidEmailFormatElement.isDisplayed();
	}

	public boolean isoutOfRangePasswordCharDisplayed() {
		return outOfRangePasswordCharElement.isDisplayed();
	}

	public void typeFirstname(String firstname) {
		firstNameElement.sendKeys(firstname);
	}

	public void typeLastname(String lastname) {
		lastNameElement.sendKeys(lastname);
	}

	public void typeEmailSignUp(String emailsignup) {
		emailSignUpElement.sendKeys(emailsignup);
	}

	public void typePasswordSignUp(String passwordsignup) {
		passwordSignUpElement.sendKeys(passwordsignup);
	}

	public void typeGender(String gender) {
		genderElement.sendKeys(gender);
	}

	public void typeHomeAddress(String homeAddress) {
		homeAddressElement.sendKeys(homeAddress);
	}

	public void clickFirstName() {
		firstNameElement.click();
	}

	public void clickLastName() {
		lastNameElement.click();
	}

	public void clickEmailSignUp() {
		emailSignUpElement.click();
	}

	public void clickPasswordSignUp() {
		passwordSignUpElement.click();
	}

	public void clickClearTextFirstName() {
		clearText1Element.click();
	}

	public void clickClearTextLastName() {
		clearText2Element.click();
	}

	public void clickClearTextEmail() {
		clearText3Element.click();
	}

	/***********************************************************/

	public void firstname(String firstname) {

		typeFirstname(firstname);
		clickLastName();
		clickFirstName();
		clickClearTextFirstName();
	}

	public void lastname(String lastname) {

		typeLastname(lastname);
		clickFirstName();
		clickLastName();
		clickClearTextLastName();
	}

	public void email(String emailsignup) {

		typeEmailSignUp(emailsignup);
		clickLastName();
		clickEmailSignUp();
		clickClearTextEmail();
	}

	public void password(String passwordsignup) {

		typePasswordSignUp(passwordsignup);
		clickLastName();
		clickPasswordSignUp();
	}

}
