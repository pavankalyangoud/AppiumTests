package GeneralStorePageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StoreHomePage {
	
		
		public StoreHomePage(AppiumDriver<AndroidElement> driver) {
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		
		@AndroidFindBy(className="android.widget.Spinner")
		public WebElement countrybutton;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Aruba']")
		public WebElement selectCountry;
		
		@AndroidFindBy(className="android.widget.EditText")
		public WebElement yourNameTextField;
		
		@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
		public WebElement genderRadioButton;
		
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
		public WebElement letsShopButton;
		
		

}
