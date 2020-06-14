package practice.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GeneralStorePageObject.StoreHomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceTest extends BaseTest {
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		System.out.println("Killing All Nodes");
		 Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		 Thread.sleep(4000);
	}

	@Test
	public void formFilling() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		StoreHomePage s = new StoreHomePage(driver);
		s.countrybutton.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));");
		s.selectCountry.click();
		s.yourNameTextField.sendKeys("Pavan");
		s.genderRadioButton.click();
		s.letsShopButton.click();
		service.stop();
		
		
		
	}

}
