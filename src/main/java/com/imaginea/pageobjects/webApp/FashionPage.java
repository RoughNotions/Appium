package com.imaginea.pageobjects.webApp;

import java.util.List;
import org.apache.xml.utils.SuballocatedByteVector;
import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;

public class FashionPage extends UIUtility {
    public enum fashion {
        fashion("Fashion "), subcategory(
                "//div[text()='%s' and @class='catName ellip']/../following-sibling::div[@class='subCatHldr'][1]/a"), menClothing(
                        "a[data-cattree='wap_leftnav_Fashion _Men_Clothing']"), ethnicWear(
                                "a[data-cattree='wap_leftnav_Fashion _Women_Ethnic Wear']"), fashioJewellery(
                                        "a[data-cattree='wap_leftnav_Fashion _Jewellery_Fashion Jewellery']"), menFragrances(
                                                "a[data-cattree='wap_leftnav_Fashion _Perfumes & Fragrances_Men's Fragrances']"), backpacks(
                                                        "a[data-cattree='wap_leftnav_Fashion _Bags & Luggage_Backpacks & More']"), sports(
                                                                "a[data-cattree='wap_leftnav_Fashion _Sports, Fitness & Outdoor_Sports']"), subcategories(
                                                                        "//a[text()=\"%s\" and @class='subCategories routeThroughCookieBarMenu_h']");

        public String value;

        fashion(String value) {
            this.value = value;
        }
    }

    public FashionPage(AppiumDriver driver) {
        super(driver);
    }

    public List<String> getAllSubCategoriesList(String categoryName) {
        return getElementsText(By.xpath(String.format(fashion.subcategory.value, categoryName)));
    }

}
