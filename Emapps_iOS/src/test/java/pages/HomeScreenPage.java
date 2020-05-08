package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomeScreenPage extends BaseClass {

	public HomeScreenPage() {

	}

	public HomeScreenPage(IOSDriver<IOSElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(id = "Favorites")
	private IOSElement favoritesElement;

	@iOSXCUITFindBy(id = "More")
	private IOSElement moreElement;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login Successfuly!\"]")
	private IOSElement loginSuccessfuly;

	public boolean isFavoritesDisplayed() {
		return favoritesElement.isDisplayed();
	}

	public boolean isloginSuccessfulyDisplayed() {
		return loginSuccessfuly.isDisplayed();
	}

	public void profile() {
		moreElement.click();
	}

	public void clickMore() {

		profile();
	}

}
