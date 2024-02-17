package com.qa.pages;

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
		PageFactory.initElements(driver,this);
		
	}
	
	
}
