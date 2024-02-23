package com.demo.tests;

import com.demo.pages.Product;
import com.demo.pages.NavigationMenu;

import org.junit.Assert;

import com.demo.pages.LoginPage;
import com.demo.utils.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDef extends BaseClass {

	LoginPage loginPage = new LoginPage(driver);
	NavigationMenu navigationMenu = new NavigationMenu(driver);
	Product product = new Product(driver);
	public static String totalAmountTest;

	@When("I Click on shop menu")
	public void clickOnShopMenu() throws InterruptedException {
		navigationMenu.clickShopMenuLink();
	}

	@When("I Add book {string} into cart")
	public void i_add_book_into_cart(String productName) throws InterruptedException {
		product.addProductToBasket(productName);
	}

	@When("I Click on cart icon and move to basket page")
	public void i_click_on_cart_icon_and_move_to_basket_page() {
		product.clickOnCartIcon();
	}

	@When("I Store the total amount of products")
	public void i_store_the_total_amount_of_products() {
		totalAmountTest = product.getTotalAmountAtBasketPage();
	}

	@When("I Click on proceed to checkout button")
	public void i_click_on_proceed_to_checkout_button() throws InterruptedException {
		product.clickOnProceedToCheckoutButton();
	}

	@When("I Click on place order button")
	public void i_click_on_place_order_button() throws InterruptedException {
		product.clickOnPlaceOrderButton();
	}

	@Then("I Verify order confirmation message")
	public void i_verify_order_confirmation_message() {
		product.getOrderConfirmationMessage();
	}

	@Then("I Verify the total amount is correct")
	public void i_verify_the_total_amount_is_correct() {
		Assert.assertEquals(product.getTotalAmountAtOrderConfirmationPage(), totalAmountTest);

	}
}
