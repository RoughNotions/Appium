package com.imaginea.tests.web;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.annotation.values.Author;
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

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
