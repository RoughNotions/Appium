package snapdeal.SnapDealTestFrameWork;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.pageobjects.FashionPageActivity;
import com.imaginea.pageobjects.HomePageActivity;
import com.imaginea.utils.UIUtility;

/**
 * All test case of Fashion Category are updated in this page
 * 
 * @author krishnakumarnellore
 *
 */
public class FashionTests extends BaseTest {

	@BeforeMethod
	public void beforeMethod() {
		driver.launchApp();
	}

	@Test(description = "Verify Fashion Category and sub category list")
	public void verifyFashionCategory() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Fashion");
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		String category[] = { "Men's Fashion", "Women's Fashion",
				"Baby & Kids", "Jewellery", "Bags & Luggage",
				"Sports, Fitness & Outdoor" };
		Assert.assertEquals(fashionPageActivity.getSubCategoryList(),
				Arrays.asList(category));
	}

	@Test(description = "Verify Sub Category")
	public void verifySubCategory() {
		HomePageActivity homePage = new HomePageActivity(driver);
		String category[] = { "Men's Fashion", "Women's Fashion",
				"Baby & Kids", "Jewellery", "Bags & Luggage",
				"Sports, Fitness & Outdoor" };
		String subCategory[] = { "Clothing", "Ethnic Wear", "Toys & Games",
				"Fashion Jewellery", "Backpacks & More", "Sports" };

		for (int i = 0; i < category.length; i++) {
			homePage.selectCategory("Fashion");
			FashionPageActivity fashionPageActivity = new FashionPageActivity(
					driver);
			fashionPageActivity.selectSubCategory(category[i]);
			Assert.assertEquals(UIUtility.getElementTextByIndex(driver, 1),
					subCategory[i], "Sub Category result field didn't match");
			driver.navigate().back();
		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}
}
