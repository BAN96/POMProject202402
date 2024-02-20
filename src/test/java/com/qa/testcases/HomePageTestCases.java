package com.qa.testcases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPopup;

public class HomePageTestCases  extends TestBase{
	HomePage home;
	LoginPopup login;
	String header;
	
	Logger logger=LogManager.getLogger(HomePageTestCases.class);
	
	public HomePageTestCases() {
		super();
	}
	
	
	@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(String browser) {
		System.out.println("browser:"+browser+" getting launch");
		logger.info("browser getting launch");
		LocalDriver_initialization(browser);
		System.out.println("browser launched");
		logger.info("browser launched");
		home=new HomePage();
		System.out.println("User on Homepage");
	}
	
	@Test(priority = 1)
	public void verifyPageHeader() {
		System.out.println("getting page header");
		logger.info("getting page header");
		header=home.getLogoName();
		System.out.println("page header :"+header);
		logger.info("page header :"+header);
		Assert.assertEquals(header, "PRODUCT STORE");
	}
	@Test(priority = 2)
	public void verifyHomepageUserafterLogin() {
		System.out.println("clicking on Login on homepage");
		logger.info("clicking on Login on homepage");
		login=home.clickLogin();
		System.out.println("Sending User name and Password");
		logger.info("Sending User name and Password");
		home=login.doLogin(properties.getProperty("user"), properties.getProperty("pass"));
		String welcomemsg=home.getwelcomeMsg();
		System.out.println("Welcome msg is "+welcomemsg);
		logger.info("Welcome msg is "+welcomemsg);
		Assert.assertEquals(welcomemsg, "Welcome "+properties.getProperty("user"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		System.out.println("browsers closed");
		logger.info("browsers closed");
	}
	
}
