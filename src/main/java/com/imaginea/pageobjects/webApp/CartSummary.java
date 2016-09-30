package com.imaginea.pageobjects.webApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

import com.imaginea.utils.UIUtility;

public class CartSummary extends UIUtility{

	@FindBy(className="toast ease-in-overlay")
	private WebElement toastLabel;
	
	@FindBy(css=".large-btn.cart-proceed")
	private WebElement continueButton;
	@FindBy(css=".cartWrapper>.bold")
	private WebElement shoppingCartLabel;
	
	@FindBy(className="item-count")
	private WebElement items;
	
	@FindBy(css=".product-name>a>span")
	private WebElement productName;
	
	@FindBy(className="unit")
	private WebElement price;
	
	@FindBy(css=".buttons>.price>span")
	private WebElement totalPrice;
	
	public CartSummary(AppiumDriver driver) {
		super(driver);
	}
	
	public String getToastMessage(){
		return toastLabel.getText();
	}
	
	public void clickOnContinueButton(){
		continueButton.click();
	}
	
	public String getShoppingCartMessage(){
		return shoppingCartLabel.getText();
	}
	public String getItemsCount(){
		return items.getText();
	}
	
	public String getProductNameFromProductPage(){
		return productName.getText();
	}
	
	public String getProductPriceFromProductPage(){
		return price.getText();
	}
	
	public String getTotalProductPriceFromProductPage(){
		return totalPrice.getText();
	}
	
	public boolean verifyProductNameFromProductPage(String name){
		return getProductNameFromProductPage().trim().equalsIgnoreCase(name.trim());
	}
	public boolean verifyProductPriceFromProductPage(String price){
		return getProductPriceFromProductPage().replaceAll(" +", "").equalsIgnoreCase(price.replaceAll(" +", ""));
	}
	
	public boolean verifyTotalProductPriceFromProductPage(String price){
		return getTotalProductPriceFromProductPage().replaceAll(" +", "").equalsIgnoreCase(price.trim());
	}
}
