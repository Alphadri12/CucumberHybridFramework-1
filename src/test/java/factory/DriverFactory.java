package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.CommonUtils;

public class DriverFactory {

	 static WebDriver driver=null;
	
public static void initializeBrowser(String browserName) {
	

	
	if(browserName.equalsIgnoreCase("chrome")) {
		
		 driver=new ChromeDriver();
		
	}else if(browserName.equalsIgnoreCase("firefox")) {
		
		 driver=new FirefoxDriver();
		
	}else if(browserName.equalsIgnoreCase("edge")) {
		
		driver =new EdgeDriver();
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
	
	
	
}
public  static WebDriver getDriver() {
	
	return driver;
}
	
	
}
