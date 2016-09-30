package com.imaginea.pageobjects.webApp;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomeAndLivingPage extends HomePage{

	@FindBy(css = ".sliderWrap.topSlider+div+.sectionHeading")
	private WebElement header;

	@FindBy(css="#csfAllCategory>a")
	private List<WebElement> categories;

	@FindBy(css=".plItemCon.gridview.dp-click-widgets>div:nth-of-type(2)>a:nth-of-type(1) .pdName.ellip.lineHeight.lineClamp")
	private WebElement productName;


	@FindBy(css=".plItemCon.gridview.dp-click-widgets>div:nth-of-type(2)>a:nth-of-type(1) .pdNewPrice")
	private WebElement productPrice;

	@FindBy(css=".product-title.pdName")
	private WebElement productNameDetail;
	
	@FindBy(className="display-price")
	private WebElement productPriceDetail;
	
	@FindBy(className="btnTxt")
	private WebElement addToCartButton;
	
	
	public HomeAndLivingPage(AppiumDriver driver) {
		super(driver);
	}

	public String getHeader(){
		return	fluentWait(header).getText();
	}

	public void clickOnSubOption(){
		clickSubElementFromList(categories,"Dinnerware");
		waitforAjaxLoading();
	}
	public String getProductName(){
		return fluentWait(productName).getText().trim();
	}

	public String getProductPrice(){
		return productPrice.getText().trim();
	}

	public void tapOnProductName(){
		productName.click();
		waitforAjaxLoading();
	}
	
	
	public boolean verifyProductPriceFromProductPage(String price){
		//getProductPriceFromProductPage().replaceAll(" +", "").equalsIgnoreCase(price.trim().replaceAll(" +", ""));
/*		System.out.println(getProductPriceFromProductPage().replaceAll(" +", ""));
		System.out.println((price.trim().replaceAll(" +", "")));
		System.out.println(getProductPriceFromProductPage().replaceAll(" +", "").equalsIgnoreCase(price.trim().replaceAll(" +", "")));*/
		
		return  getProductPriceFromProductPage().replaceAll(" +", "").equalsIgnoreCase(price.trim().replaceAll(" +", ""));
	}
	
	public boolean verifyProductNameFromProductPage(String name){
		return getProductNameFromProductPage().equalsIgnoreCase(name.trim());
	}
	public String getProductNameFromProductPage(){
		return productNameDetail.getText().trim();
	}
	
	public String getProductPriceFromProductPage(){
		return productPriceDetail.getText().trim();
	}
	
	public CartSummary clickOnAddToCartButton(){
		addToCartButton.click();
		waitforAjaxLoading();
		return new CartSummary(driver); 
	}
}
