package com.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPopup;

public class LoginPageTestCases extends TestBase{

	HomePage home;
	LoginPopup login;
	
	String header;
	public LoginPageTestCases() {
		super();
	}
	
	
	@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(String browser) {
		System.out.println("browser:"+browser+" getting launch");
		LocalDriver_initialization(browser);
		System.out.println("browser launched");
		home=new HomePage();
		System.out.println("User on Homepage");
		System.out.println("clicking on Login on homepage");
		login=home.clickLogin();
		System.out.println("Login popup opened");
	}
	
	@Test
	public void verifyPageHeader() {
		System.out.println("getting login popup title");
		header=login.getLoginPopupTitle();
		System.out.println("Login popup title is: "+header);
		Assert.assertEquals(header, "Log in");
	}
	@Test
	public void verifyLoginWithValidCredentials() {
		System.out.println("Sending User name and Password");
		login.enterUsername(properties.getProperty("user"));
		login.enterPassword(properties.getProperty("pass"));
		home=login.clickOnLoginButton();
		System.out.println("User logged in");
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		System.out.println("browsers closed");
	}
}
