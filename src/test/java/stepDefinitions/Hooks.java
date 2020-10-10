package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import TestUtils.WebEventListener;
import baseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks extends BaseClass{
	
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	 
	@Before
	
	public void beforeScenario() throws FileNotFoundException {
		readConfigFile();
		String browser = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","Webdrivers/chromedriver" );
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","Webdrivers/geckodriver" );
			driver = new FirefoxDriver();
		}
		wait = new WebDriverWait(driver,30);

		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	}
	
	@After
	
	public void afterScenario() throws IOException {
		captureScreenshot();
		driver.quit();
		
	}
}
