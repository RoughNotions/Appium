package com.imaginea.tests.web;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.base.BaseTest;
import com.imaginea.pageobjects.nativeApp.HomeAndLivingPageActivity;
import com.imaginea.pageobjects.nativeApp.HomePageActivity;
import com.imaginea.pageobjects.webApp.HomeAndLivingPage;
import com.imaginea.pageobjects.webApp.HomePage;

public class HomeAndLivingTests extends BaseTest{

	HomeAndLivingPage homeLivingPage;
	HomePage homePage;
    String categoryMenu = "Home & Living";
    String category[] = {  "Kitchenware","Kitchen Appliances", "Tools & Hardware", "Home Improvement", "Home Furnishing", "Home Decoratives",
            "Furniture & Real Estate", "Home Appliances" };
    String kitchenWareSubCategories[] = { "Cookware & Bakeware", "Storage & Thermoware", "Kitchen Tools", "Dining & Serving", "Tea & Coffee Serveware", "Microwave Cooking",
            "Bar Accessories", "Hotel & Catering Supplies","Disposables","All Kitchenware" };

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://m.snapdeal.com");
	}

    @Test(description = "Verify Home & Living Category and sub category list")
    public void verifyHomeLivingCategory() {
        homeLivingPage = new HomeAndLivingPage(driver);
        homeLivingPage.clickMenuicon();
        homeLivingPage.selectCategory(categoryMenu);
        Assert.assertEquals(homeLivingPage.getSubCategories(categoryMenu), Arrays.asList(category));
    }
    
    @Test(description = "Verify Home & Living Category and sub category list")
    public void verifyKitchenWareSubCategories() {
    	String subCategory="Kitchenware";
        homeLivingPage = new HomeAndLivingPage(driver);
        homeLivingPage.clickMenuicon();
        homeLivingPage.selectCategory(categoryMenu);
        System.out.println(homeLivingPage.getSubCategories(categoryMenu));
        homeLivingPage.clickSubCategory(categoryMenu,subCategory);
        System.out.println(homeLivingPage.getRelavantSubCategories(categoryMenu,subCategory));
        Assert.assertEquals(homeLivingPage.getRelavantSubCategories(categoryMenu,subCategory), Arrays.asList(kitchenWareSubCategories));
    }
}
