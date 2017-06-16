package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.fabric.xmlrpc.base.Data;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Base_Class {
	
	public AppiumDriver driver;
	public Process process;
	
	
	public void Start_Server() throws IOException{
		
		String Start_Server = "D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!= null){
			System.out.println("Appium Server Started Successfully");
		}
		else
		{
			System.out.println("Failed to start Appium server");
		}
				
	}
	
	
	public void Launch_App() throws InterruptedException, IOException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "HTC Desire 820s dual sim");
		capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.4");
        
		
       // capabilities.setCapability("appPackage","com.bigbasket.mobileapp");
		// capabilities.setCapability("appActivity","com.bigbasket.mobileapp.activity.SplashActivity");
        

        capabilities.setCapability("appPackage",Utility_Class.Reading_properties("Packge_name"));
 		capabilities.setCapability("appActivity",Utility_Class.Reading_properties("Activity_name"));
 		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(3000);
		
	}
	
	
	public void ExplicitWait(WebElement ele,int i){
		
		WebDriverWait wait=new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
	}
			
			
	
	public void Capture_Screenshot1(String TC_ID,String Order_Set) throws IOException
	{
		
		
		Date date= new Date();
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD hh-mm-ss");	
        String str = df.format(date);
        
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File screenshotAs=screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs, new File("/NAMRATA/LEARNINGS/Appium/Apr30_BB_project/Screenshot/ " + TC_ID + Order_Set + "-" + str));
		
		
	}
	
	
	public void Stop_Server() throws InterruptedException
	{
		
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(3000);
			System.out.println("Appium Server Stopped successfully");
		}
		
	}

}
	