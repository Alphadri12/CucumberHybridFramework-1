package Hooks;


import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import Utils.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
WebDriver driver;
private ConfigReader configReader;

	@Before
	public void setUp() {
		 configReader= new ConfigReader(); //Code can be optimized as Properties prop= new configReader.intializeProperties();
		Properties prop=configReader.intializeProperties();
		DriverFactory.initializeBrowser(prop.getProperty("browser")) ;
		driver=DriverFactory.getDriver();
		//driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}
	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioName= scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
			
		byte[]srcScreenshot=	((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		driver.quit();
	}
}
