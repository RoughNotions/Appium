package com.imaginea.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.appium.manager.AppiumParallelTest;
import com.imaginea.pageobjects.FashionPageActivity;
import com.imaginea.pageobjects.HomePageActivity;

/**
 * All test case of Fashion Category are updated in this page
 * 
 * @author krishnakumarnellore
 *
 */

public class FashionTests extends AppiumParallelTest {

    @BeforeMethod()
    public void startApp(Method name) throws Exception {
        driver = startAppiumServerInParallel(name.getName());
        startLogResults(name.getName());
    }

    @AfterMethod()
    public void killServer(ITestResult result) {

        try {
            endLogTestResults(result);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        getDriver().quit();
    }

    @Test(description = "Verify Fashion Category and sub category list")
    public void verifyFashionCategory() {
        HomePageActivity homePage = new HomePageActivity(driver);
        FashionPageActivity fashionPageActivity = new FashionPageActivity(driver);
        String category[] = { "Men's Fashion", "Women's Fashion", "Baby & Kids", "Jewellery", "Bags & Luggage",
                "Sports, Fitness & Outdoor" };
        homePage.selectCategory("Fashion");
        Assert.assertEquals(fashionPageActivity.getSubCategoryList(), Arrays.asList(category));
    }

    @Test(description = "Verify Sub Category")
    public void verifySubCategory() {
        SoftAssert s_assert = new SoftAssert();
        HomePageActivity homePage = new HomePageActivity(driver);
        String category[] = { "Men's Fashion", "Women's Fashion", "Baby & Kids", "Jewellery", "Bags & Luggage",
                "Sports, Fitness & Outdoor" };
        String subCategory[] = { "Clothing", "Ethnic Wear", "Kids Clothing", "Fashion Jewellery", "Backpacks & More",
                "Sports" };

        for (int i = 0; i < category.length; i++) {

            homePage.selectCategory("Fashion");
            FashionPageActivity fashionPageActivity = new FashionPageActivity(driver);
            fashionPageActivity.selectSubCategory(category[i]);
            s_assert.assertEquals(fashionPageActivity.getElementTextByIndex(1), subCategory[i],
                    "Sub Category result field didn't match");
            driver.navigate().back();

        }
        s_assert.assertAll();
    }

    @Test(description = "Verify List of Sort Type Avilable for Fashion Category")
    public void verifyMenFashionClothingCategorySortType() {
        HomePageActivity homePage = new HomePageActivity(driver);
        homePage.selectCategory("Fashion");
        FashionPageActivity fashionPageActivity = new FashionPageActivity(driver);
        fashionPageActivity.selectSubCategory("Men's Fashion");
        fashionPageActivity.sleep(10000L);
        fashionPageActivity.clickElementByText("Clothing");
        fashionPageActivity.sleep(10000L);
        fashionPageActivity.clickElementByText("Sort\nPopularity");
        String sortCategory[] = { "Relevance", "Popularity", "Price Low To High", "Price High To Low", "New Arrival",
                "Discount" };
        Assert.assertEquals(fashionPageActivity.getSortCategoryList(), Arrays.asList(sortCategory));
    }

    @Test(description = "Verify Sort By discount in Fashion Category")
    public void verifyMenFashionSortByDiscount() {
        HomePageActivity homePage = new HomePageActivity(driver);
        homePage.selectCategory("Fashion");
        FashionPageActivity fashionPageActivity = new FashionPageActivity(driver);
        fashionPageActivity.selectSubCategory("Men's Fashion");
        fashionPageActivity.sleep(5000L);
        fashionPageActivity.clickElementByText("Clothing");
        fashionPageActivity.sleep(5000L);
        fashionPageActivity.clickElementByText("Sort\nPopularity");
        fashionPageActivity.clickElementByText("Discount");
        fashionPageActivity.sleep(5000L);
        Assert.assertTrue(fashionPageActivity.getProductDiscountList().get(0).contains("% OFF"),
                "Discount is not shown");
    }

    @Test(description = "Verify Brand Selection in Fashion Category")
    public void testBrandSelection() {
        HomePageActivity homePage = new HomePageActivity(driver);
        homePage.selectCategory("Fashion");
        FashionPageActivity fashionPageActivity = new FashionPageActivity(driver);
        fashionPageActivity.selectSubCategory("Men's Fashion");
        fashionPageActivity.sleep(5000L);
        fashionPageActivity.clickElementByText("Clothing");
        fashionPageActivity.sleep(5000L);
        fashionPageActivity.selectCategoryByText("Brand");
        fashionPageActivity.sleep(2000L);
        fashionPageActivity.selectCategoryByText("Lee");
        fashionPageActivity.sleep(2000L);
        fashionPageActivity.clickApplyButton();
        fashionPageActivity.sleep(5000L);
        List<String> titleList = fashionPageActivity.getProductTitleList();
        Assert.assertTrue(titleList.get(0).contains("Lee"), "Title is not shown " + titleList);
    }

    @Test(description = "Verify Size Selection in Fashion Category")
    public void testSizeSelection() {
        HomePageActivity homePage = new HomePageActivity(driver);
        homePage.selectCategory("Fashion");
        FashionPageActivity fashionPageActivity = new FashionPageActivity(driver);
        fashionPageActivity.selectSubCategory("Men's Fashion");
        fashionPageActivity.sleep(5000L);
        fashionPageActivity.clickElementByText("Clothing");
        fashionPageActivity.sleep(5000L);
        fashionPageActivity.selectCategoryByText("Price");
        fashionPageActivity.sleep(2000L);
        fashionPageActivity.setPriceFilter("2000", "30000");
        fashionPageActivity.sleep(5000L);
        List<String> titleList = fashionPageActivity.getProductDisplayPriceList();
        int price = Integer.parseInt(titleList.get(0).replace("Rs. ", "").replace(",", ""));
        Assert.assertEquals(price > 2000, price < 30000, "Price is not in range");
    }

    @Test(description = "Verify Discount Selection in Fashion Category")
    public void testDiscountSelection() {
        HomePageActivity homePage = new HomePageActivity(driver);
        homePage.selectCategory("Fashion");
        FashionPageActivity fashionPageActivity = new FashionPageActivity(driver);
        fashionPageActivity.selectSubCategory("Men's Fashion");
        fashionPageActivity.clickElementByText("Clothing");
        fashionPageActivity.selectCategoryByText("Discount %");
        fashionPageActivity.selectCategoryByText("40 - 50");
        fashionPageActivity.clickApplyButton();
        fashionPageActivity.sleep(2000L);
        List<String> titleList = fashionPageActivity.getProductDiscountPriceList();
        Assert.assertTrue(titleList.get(0).contains("% OFF"), "Discount is not shown");
    }

    @Test(description = "Verify Zoom Functionality in Fashion Category")
    public void testZoomFunctionality() {
        HomePageActivity homePage = new HomePageActivity(driver);
        homePage.selectCategory("Fashion");
        FashionPageActivity fashionPageActivity = new FashionPageActivity(driver);
        fashionPageActivity.selectSubCategory("Men's Fashion");
        fashionPageActivity.clickElementByText("Clothing");
        fashionPageActivity.clickElementByText("T-Shirts & Polos");
        fashionPageActivity.clickElementByText("T-Shirts");
        fashionPageActivity.clickElementByText("Alan Jones Clothing Grey Cotton T-Shirt");
        fashionPageActivity.zoomImage();
        Assert.assertTrue(fashionPageActivity.isElementPresent("com.snapdeal.main:id/imageViewZoom"),
                "Trouble in Zooming image");
    }

    @Test(description = "Verify Add to Cart Functionality in Fashion Category")
    public void testAddToCartFunctionality() {
        HomePageActivity homePage = new HomePageActivity(driver);
        homePage.selectCategory("Fashion");
        FashionPageActivity fashionPageActivity = new FashionPageActivity(driver);
        fashionPageActivity.selectSubCategory("Men's Fashion");
        fashionPageActivity.clickElementByText("Clothing");
        fashionPageActivity.clickElementByText("T-Shirts & Polos");
        fashionPageActivity.clickElementByText("T-Shirts");
        String fashionItem = "Alan Jones Clothing Grey Cotton T-Shirt";
        fashionPageActivity.clickElementByText(fashionItem);
        fashionPageActivity.clickElementByText("Add to Cart");
        fashionPageActivity.clickElementByText("L");
        fashionPageActivity.clickElementByText("Add to cart");
        fashionPageActivity.clickMenuCartIcon();
        Assert.assertEquals(fashionPageActivity.getCartProductNameList().get(0), fashionItem);
        Assert.assertEquals(fashionPageActivity.getCartProductCountList().get(0), "1");

    }

    @BeforeClass()
    public void beforeClass() throws Exception {
        startAppiumServer(getClass().getSimpleName());
    }

    @AfterClass()
    public void afterClass() throws InterruptedException, IOException {
        killAppiumServer();
    }

}
