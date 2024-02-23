package com.demo.tests;

import java.io.IOException;

import org.junit.Assert;

import com.demo.pages.LoginPage;
import com.demo.pages.NavigationMenu;
import com.demo.utils.BaseClass;
import com.demo.utils.PropertyReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends BaseClass {

	LoginPage loginPage = new LoginPage(driver);
	NavigationMenu navigationMenu = new NavigationMenu(driver);
	public PropertyReader propertyReader = new PropertyReader();

	@Given("User move to login screen")
	public void user_move_to_login_screen() {
		navigationMenu.clickMyAccountMenuLink();
	}

	@When("I Enter {string} in login text field")
	public void UserEnterUserName(String username) {
		loginPage.enterEmailAddress(username);
	}

	@When("I Enter {string} in password text field")
	public void UserEnterPassword(String password) {
		loginPage.enterPassword(password);
	}

	@When("I Click on login button")
	public void ClickOnLoginButton() {
		loginPage.clickOnLoginButton();
	}

	@Then("I Verify the {string} message")
	public void VerifyTheValidationMessage(String str) {
		boolean isEmpty = str == null || str.trim().length() == 0;
		if (!(isEmpty)) {
			Assert.assertTrue("Validation message should be displayed", loginPage.verifyValidationMessageIsDisplayed());
		}
	}

	@Given("I Log into the Demo application")
	public void userLoginIntoApplicaion() throws InterruptedException, IOException {
		navigationMenu.clickMyAccountMenuLink();
		String email = propertyReader.readApplicationFile("EmailAddress");
		String password = propertyReader.readApplicationFile("Password");
		loginPage.loginIntoApplication(email, password);
	}

}
