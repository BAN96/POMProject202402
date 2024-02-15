package com.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(id="login2") private WebElement loginLink;
	@FindBy(id="signin2") private WebElement signupLink;
	@FindBy(id="cartur") private WebElement cartLink;
	@FindBy(xpath="//a[text()='About us']") private WebElement abouUsLink;
	@FindBy(xpath="//a[text()='Contact']") private WebElement contactLink;
	@FindBy(xpath="//a[contains(text(),'Home')]") private WebElement HomeLink;
	@FindBy(xpath="//a[@id='nava']/img") private WebElement logo;
	@FindBy(xpath="//a[@id='nava']") private WebElement logoName;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPopup clickLogin() {
		loginLink.click();
		return new LoginPopup();
	}
	
	public void clickSignup() {
		signupLink.click();
	}
	public void clickOnCart() {
		cartLink.click();
	}
	public void clickonAboutUS() {
		abouUsLink.click();
	}
	public void clickOnContact() {
		contactLink.click();
	}
	public void clickonHome() {
		HomeLink.click();
	}
	
	public void getLogo() {
		File actualImg=logo.getScreenshotAs(OutputType.FILE);
		try {
			org.openqa.selenium.io.FileHandler.copy(actualImg, new File(".\\src\\main\\java\\com\\qa\\images\\"+logoName.getText().replaceAll(" ", "_")+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
