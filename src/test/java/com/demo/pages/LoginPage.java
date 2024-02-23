package com.demo.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.utils.BaseClass;

public class LoginPage extends BaseClass {

// ==================Login page locators=======================
	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement LoginButton;

	@FindBy(xpath = "//ul[@class='woocommerce-error']//li")
	private WebElement ValidationMsg;

	@FindBy(className = "logout")
	private WebElement logout;

//=========================================================================	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterEmailAddress(String userName) {
		username.clear();
		username.sendKeys(userName);
	}

	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	public void clickOnLoginButton() {
		LoginButton.click();
	}

	public void loginIntoApplication(String email, String pass) throws InterruptedException, IOException {
		enterEmailAddress(email);
		enterPassword(pass);
		clickOnLoginButton();
	}

	public boolean verifyValidationMessageIsDisplayed() {
		return ValidationMsg.isDisplayed();
	}

	public void logoutFromApplication() {
		logout.click();

	}

}
