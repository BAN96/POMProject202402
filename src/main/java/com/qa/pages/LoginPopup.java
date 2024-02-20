package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class LoginPopup extends TestBase{

	@FindBy(id="logInModalLabel") private WebElement popupTitle;
	@FindBy(id="loginusername") private WebElement usernamefield;
	@FindBy(id="loginpassword") private WebElement passwordfield;
	@FindBy(xpath="//button[text()='Log in']") private WebElement loginButton;
	@FindBy(xpath="//button[text()='Log in']/preceding-sibling::button") private WebElement closeButton;
	@FindBy(xpath="//h5[@id='logInModalLabel']/following-sibling::button[@aria-label='Close']/span") private WebElement crossIconButton;
	
	public LoginPopup() {
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPopupTitle() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(popupTitle));

		return popupTitle.getText().trim();
	}
	public void enterUsername(String user) {
		usernamefield.clear();
		usernamefield.sendKeys(user);
	}
	public void enterPassword(String pass) {
		passwordfield.clear();
		passwordfield.sendKeys(pass);
	}
	public HomePage clickOnLoginButton() {
		loginButton.click();
		return new HomePage();
	}
	
	public HomePage doLogin(String user,String pass) {
		enterUsername(user);
		enterPassword(pass);
		return clickOnLoginButton();
	}
	
	public HomePage clickOnCloseButton() {
		closeButton.click();
		return new HomePage();
	}
	
	public HomePage clickOnCrossIcon() {
		crossIconButton.click();
		return new HomePage();
	}
	
}
