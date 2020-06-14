package practice.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {
	public static AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer() {
		System.out.println("Starting Appium Server");
	    boolean flag=    checkIfServerIsRunnning(4723);
	    if(!flag)
	    {
	       
	        service=AppiumDriverLocalService.buildDefaultService();
	        service.start();
	    }
	        return service;
	}
	
	public static boolean checkIfServerIsRunnning(int port) {
	       
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
           
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		//\src\main\java\resources\fly.bat
	    //Runtime.getRuntime().exec(System.getProperty("user.dir")+"\src\main\java\resources\fly.bat");
		System.out.println("Starting an emulator");
	   Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\fly.bat");
	    Thread.sleep(6000);
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Properties prop = new Properties();
		prop.load(fis);
		
		// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir,(String) prop.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		String device = (String) prop.get("device");
//		if(device.contains("Pavanemulator")) {
//		startEmulator();
//		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}
