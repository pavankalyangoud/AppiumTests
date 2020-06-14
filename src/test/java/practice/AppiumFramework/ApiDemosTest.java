package practice.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ApiDemoPageObject.DependenciesTest;
import ApiDemoPageObject.HomePageTest;
import ApiDemoPageObject.PreferencePageTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemosTest extends BaseTest{
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		System.out.println("Killing All Nodes");
		 Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		 Thread.sleep(4000);
	}

	@Test
	public void apiDemoHome() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		service = startServer();
		Thread.sleep(10000);
		
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemos");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		HomePageTest h = new HomePageTest(driver);
		h.preference.click();
		
		PreferencePageTest p = new PreferencePageTest(driver);
		p.dependencies.click();
	
		DependenciesTest d = new DependenciesTest(driver);
		d.wifiCheckbox.click();
		d.wifiSettings.click();
		d.wifiSettingsTextBox.sendKeys("Mobile Tester");
		d.okButton.get(1).click();
		service.stop();

	}

}
