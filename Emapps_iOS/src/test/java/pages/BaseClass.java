package pages;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	protected IOSDriver<IOSElement> driver;

	@BeforeTest

	public void setup() {

		try {

			DesiredCapabilities caps = new DesiredCapabilities();

			// Simulator
			caps.setCapability("platformName", "iOS");
			caps.setCapability("platformVersion", "12.2");
			caps.setCapability("deviceName", "iPhone X");
//			caps.setCapability("deviceName", "iPhone 8 Plus");
//			caps.setCapability("app", "/Users/rahman/Desktop/iOSEmapps.app");
			caps.setCapability("app", "/Users/rahman/git/emapps_ios/Emapps_iOS/src/main/resources/iOSEmapps.app");
			
			caps.setCapability("noReset", true);
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new IOSDriver<IOSElement>(url, caps);

		} catch (Exception exp) {
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
		}

	}

//	@Test
//	public void sampleTest() throws InterruptedException {
//		System.out.println("Ï am inside sample Test");
//		Thread.sleep(10000);
//	}

	@AfterSuite
	public void teardown() throws IOException {
		// close the app
		driver.quit();

//		// close simulator
//		String closesim[] = { "killall", "iOS Simulator" };
//		Runtime.getRuntime().exec(closesim);

	}

}
