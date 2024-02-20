package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.qa.config.TimeOutWaits;

public class TestBase {

	public static Properties properties;
	private static MutableCapabilities options;
	//public static RemoteWebDriver rdriver;
	public static WebDriver driver;
	private static URL url;
	
	private static ThreadLocal<WebDriver> tldriver=new ThreadLocal<>();
	
	public TestBase() {
		properties=new Properties();
		try {
			properties.load(new FileInputStream(".\\src\\main\\java\\com\\qa\\config\\config.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void RemoteDriver_initialization(String browser) {
		
		try {
			url = new URL("http://localhost:4444");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			options=new ChromeOptions();
			
		}
		if(browser.equalsIgnoreCase("firefox")) {
			options=new FirefoxOptions();
		}
		if(browser.equalsIgnoreCase("edge")) {
			options=new EdgeOptions();
		}
		if(browser.equalsIgnoreCase("safari")) {
			options=new SafariOptions();
		}
		tldriver.set(new RemoteWebDriver(url, options));
		//driver=tldriver.get();
		
		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeOutWaits.IMPLICITWAIT_TIME));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutWaits.PAGELOADWait_TIME));
		
		getDriver().get(properties.getProperty("url"));
		driver=getDriver();
	}
	
	public static void LocalDriver_initialization(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			tldriver.set(new ChromeDriver());
		}
		if(browser.equalsIgnoreCase("firefox")) {
			//driver=new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
		}
		if(browser.equalsIgnoreCase("edge")) {
			//driver=new EdgeDriver();
			tldriver.set(new EdgeDriver());
		}
		if(browser.equalsIgnoreCase("safari")) {
			//driver=new SafariDriver();
			tldriver.set(new SafariDriver());
		}
		
		driver=getDriver();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeOutWaits.IMPLICITWAIT_TIME));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutWaits.PAGELOADWait_TIME));
		
		getDriver().get(properties.getProperty("url"));
		
	}
	
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
}
