package com.imaginea.tests.web;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.imaginea.base.BaseTest;
import com.imaginea.pageobjects.webApp.FashionPage;
import com.imaginea.pageobjects.webApp.FashionPage.fashion;
import com.imaginea.pageobjects.webApp.HomePage;

public class FashionTests extends BaseTest {
    HomePage homePage = null;
    FashionPage fashionPage = null;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://m.snapdeal.com");
    }

    @Test(description = "Verify Fashion Category and sub category list ")
    public void verifyFashionCategory() {
        homePage = new HomePage(driver);
        homePage.clickMenuicon();
        homePage.selectCategory(fashion.fashion.value);
        fashionPage = new FashionPage(driver);
        String category[] = { "Men", "Women", "Jewellery", "Perfumes & Fragrances", "Bags & Luggage",
                "Sports, Fitness & Outdoor" };
        Assert.assertEquals(fashionPage.getAllSubCategoriesList(fashion.fashion.value), Arrays.asList(category));
    }

    @Test(description = "Verify Sub Category")
    public void verifySubCategory() {
        SoftAssert s_assert = new SoftAssert();
        homePage = new HomePage(driver);
        homePage.clickMenuicon();
        homePage.selectCategory(fashion.fashion.value);
        fashionPage = new FashionPage(driver);
        String category[] = { "Men", "Women", "Jewellery", "Perfumes & Fragrances", "Bags & Luggage",
                "Sports, Fitness & Outdoor" };
        String subCategory[] = { "Clothing", "Ethnic Wear", "Fashion Jewellery", "Men's Fragrances", "Backpacks & More",
                "Sports" };
        for (int i = 0; i < subCategory.length; i++) {
            homePage.clickSubCategory(fashion.fashion.value, category[i]);
            s_assert.assertTrue(
                    homePage.isElementExistInWeb(By.xpath(String.format(fashion.subcategories.value, subCategory[i]))),
                    "Expected Sub Category " + subCategory[i] + " field didn't match");
            homePage.clickSubCategory(fashion.fashion.value, category[i]);
        }
        s_assert.assertAll();
    }

    @Test(description = "Verify List of Sort Type Avilable for Fashion Category")
    public void verifyMenFashionClothingCategorySortType() {
        homePage = new HomePage(driver);
        homePage.clickMenuicon();
        homePage.selectCategory(fashion.fashion.value);
        fashionPage = new FashionPage(driver);
        homePage.clickSubCategory(fashion.fashion.value, "Men");
        fashionPage.clickElement(By.xpath(String.format(fashion.subcategories.value, "Clothing")));
        fashionPage.clickSubElementFromList(By.cssSelector(fashion.datacustomnav.value),fashion.polos.value);
        fashionPage.clickSubElementFromList(By.cssSelector(fashion.datacustomnav.value),fashion.tshirts.value);
        String filter[]={"Relevance", "Popularity", "Price Low To High", "Price High To Low", "New Arrival", "Discount"};
        Assert.assertEquals(fashionPage.getSortingCategoryList(),Arrays.asList(filter),"Filter value didn't match");
        
    }

}
