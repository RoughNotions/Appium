package com.imaginea.tests.web;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.base.BaseTest;
import com.imaginea.pageobjects.webApp.CartSummary;
import com.imaginea.pageobjects.webApp.HomeAndLivingPage;
import com.imaginea.pageobjects.webApp.HomePage;

public class HomeAndLivingTests extends BaseTest{

	HomeAndLivingPage homeLivingPage;
	HomePage homePage;
	CartSummary cartSummary;
    String categoryMenu = "Home & Living";
    String category[] = {  "Kitchenware","Kitchen Appliances", "Tools & Hardware", "Home Improvement", "Home Furnishing", "Home Decoratives",
            "Furniture & Real Estate", "Home Appliances" };
    String kitchenWareSubCategories[] = { "Cookware & Bakeware", "Storage & Thermoware", "Kitchen Tools", "Dining & Serving", "Tea & Coffee Serveware", "Microwave Cooking",
            "Bar Accessories", "Hotel & Catering Supplies","Disposables","All Kitchenware" };


    @Test(description = "Verify Home & Living Category and sub category list")
    public void verifyHomeLivingCategory() {
        homeLivingPage = new HomeAndLivingPage(driver);
        homeLivingPage.clickMenuicon();
        homeLivingPage.selectCategory(categoryMenu);
        Assert.assertEquals(homeLivingPage.getSubCategories(categoryMenu), Arrays.asList(category));
    }
    
    @Test(description = "Verify Home & Living ->KitchenWare-> sub category list")
    public void verifyKitchenWareSubCategories() {
    	String subCategory="Kitchenware";
        homeLivingPage = new HomeAndLivingPage(driver);
        homeLivingPage.clickMenuicon();
        homeLivingPage.selectCategory(categoryMenu);
        homeLivingPage.clickSubCategory(categoryMenu,subCategory);
        Assert.assertEquals(homeLivingPage.getRelavantSubCategories(categoryMenu,subCategory), Arrays.asList(kitchenWareSubCategories));
    }
    
    @Test(description = "select any product and add to cart from Home and Living Menu and perform all validations")
    public void selectAnyProductAndAddtoCart() {
    	String subCategory="Kitchenware";
        homeLivingPage = new HomeAndLivingPage(driver);
        homeLivingPage.clickMenuicon();
        homeLivingPage.selectCategory(categoryMenu);
        homeLivingPage.clickSubCategory(categoryMenu,subCategory);
        homeLivingPage.clickSubSubCategory("Dining & Serving");
        Assert.assertEquals(homeLivingPage.getHeader(),"Dining & Serving","Header is not matchng");
        homeLivingPage.clickOnSubOption();
        String productName=homeLivingPage.getProductName();
        String productPrice=homeLivingPage.getProductPrice();
        homeLivingPage.tapOnProductName();
        Assert.assertTrue(homeLivingPage.verifyProductNameFromProductPage(productName), "Product Name from ProductPage is not matching");
        Assert.assertTrue(homeLivingPage.verifyProductPriceFromProductPage(productPrice), "Product Price from ProductPage is not matching");
        cartSummary=homeLivingPage.clickOnAddToCartButton();
        Assert.assertEquals(cartSummary.getShoppingCartMessage(),"Shopping Cart (1 item)","Header is not matchng");
        Assert.assertEquals(cartSummary.getItemsCount(),"1","Count is not matchng");
        Assert.assertTrue(cartSummary.verifyProductNameFromProductPage(productName), "Product Name from ProductPage is not matching");
        Assert.assertTrue(cartSummary.verifyProductPriceFromProductPage(productPrice), "Product Price from ProductPage is not matching");
        Assert.assertTrue(cartSummary.verifyTotalProductPriceFromProductPage(productPrice),"Count is not matchng");
        cartSummary.clickOnContinueButton();
        
    }
    
}
