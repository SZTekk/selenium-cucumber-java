package com.demo.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.utils.BaseClass;

public class Product extends BaseClass {

// ==================Product, Add to Cart page locators=======================	

	@FindBy(xpath = "//a[contains(@class,'wpmenucart-contents')]")
	private WebElement cartIcon;

	@FindBy(xpath = "//a[contains(@class,'checkout-button')]")
	private WebElement proceedToCheckoutButton;

	@FindBy(xpath = "//ul[contains(@class,'products')]/li")
	private List<WebElement> productList;

	@FindBy(xpath = "//tr[@class='order-total']//span[contains(@class,'woocommerce-Price-amount')]")
	private WebElement totalAmount;

	@FindBy(id = "place_order")
	private WebElement placeOrderButton;

	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	private WebElement orderConfirmationMsg;

	@FindBy(xpath = "//ul[@class='woocommerce-thankyou-order-details order_details']//span[@class='woocommerce-Price-amount amount']")
	private WebElement totalAmountAtOrderConfirmation;

//=========================================================================	

	public Product(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void addProductToBasket(String productName) throws InterruptedException {
		for (int i = 1; i < productList.size(); i++) {
			String proName = driver.findElement(By.xpath("//ul[contains(@class,'products')]/li[" + i + "]/a/h3"))
					.getText();

			if (productName.equalsIgnoreCase(proName.trim())) {
				driver.findElement(By
						.xpath("//ul[contains(@class,'products')]/li[" + i + "]//a[contains(text(),'Add to basket')]"))
						.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

	public void clickOnCartIcon() {
		cartIcon.click();
	}

	public String getTotalAmountAtBasketPage() {
		String str = totalAmount.getText();
		str = str.replaceAll("[^a-zA-Z0-9.]", " ");
		return str;
	}

	public void clickOnProceedToCheckoutButton() throws InterruptedException {
		proceedToCheckoutButton.click();
	}

	public void clickOnPlaceOrderButton() throws InterruptedException {
		placeOrderButton.click();
	}

	public String getOrderConfirmationMessage() {
		return orderConfirmationMsg.getText();
	}

	public String getTotalAmountAtOrderConfirmationPage() {
		String str = totalAmountAtOrderConfirmation.getText();
		str = str.replaceAll("[^a-zA-Z0-9.]", " ");
		return str;
	}

}
