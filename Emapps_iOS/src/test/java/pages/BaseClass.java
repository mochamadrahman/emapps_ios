package pages;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import tests.EmappsTestReport;

public class BaseClass extends EmappsTestReport{
	
	protected IOSDriver<IOSElement> driver;

	@BeforeTest 

	public void setup() {

		try {

			DesiredCapabilities caps = new DesiredCapabilities();

			
			caps.setCapability("platformName", "iOS");
			caps.setCapability("platformVersion", "12.2");
			caps.setCapability("deviceName", "iPhone 8 Plus");
			caps.setCapability("resetKeyboard", true);
			caps.setCapability("noReset", true);
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			
			// relative path to ipa file
			final File classpathRoot = new File(System.getProperty("user.dir"));
//			final File appDir = new File(classpathRoot, "src/main/resources/");
			final File appDir = new File(classpathRoot, "");
			final File app = new File(appDir, "iOSEmapps.ipa");
//			caps.setCapability("app", app.getAbsolutePath());

			URL url = new URL("http://localhost:4723/wd/hub");
			driver = new IOSDriver<IOSElement>(url, caps);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception exp) {
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
		}

	}

	@AfterSuite(alwaysRun = true)
	public void teardown() throws IOException {
		
		driver.quit();

	}

}