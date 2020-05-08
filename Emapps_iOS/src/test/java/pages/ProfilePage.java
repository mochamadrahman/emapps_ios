package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProfilePage extends BaseClass {

	public ProfilePage() {

	}

	public ProfilePage(IOSDriver<IOSElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(id = "Welcome Back,")
	private IOSElement welcomeBackElement;

	@iOSXCUITFindBy(className = "Password")
	private IOSElement passwordProfileElement;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign Out\"]")
	private IOSElement signoutElement;

	public boolean welcomeBack() {
		return welcomeBackElement.isDisplayed();
	}

	public void clickSignOut() {
		signoutElement.click();
	}

	public void logout() {

		clickSignOut();
	}

}
