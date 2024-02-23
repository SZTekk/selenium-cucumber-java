package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.utils.BaseClass;

public class NavigationMenu extends BaseClass {

// ==================NavigationMenu locators=======================	

	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	private WebElement myAccountMenu;

	@FindBy(xpath = "//a[contains(text(),'Shop')]")
	private WebElement shopMenu;

//=========================================================================	

	public NavigationMenu(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickMyAccountMenuLink() {
		myAccountMenu.click();
	}

	public void clickShopMenuLink() throws InterruptedException {
		shopMenu.click();
		Thread.sleep(3000);
	}

}
