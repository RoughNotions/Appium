package com.imaginea.pageobjects.webApp;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;

public class FashionPage extends UIUtility {
    public enum fashion {
        fashion("Fashion "), subcategory(
                "//div[text()='%s' and @class='catName ellip']/../following-sibling::div[@class='subCatHldr'][1]/a"), subcategories(
                        "//a[text()=\"%s\" and @class='subCategories routeThroughCookieBarMenu_h']"), datacustomnav(
                                "div.outer a"), polos("T-Shirts & Polos"), tshirts("T-Shirts"), sorting(
                                        "productSorting");

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

    public List<String> getSortingCategoryList() {
        sleep(3000L);
        List<String> option = new ArrayList<>();        
        Select select = new Select(driver.findElement(By.id(fashion.sorting.value)));
        for (WebElement element : select.getOptions()) {
            option.add(element.getText());            
        }
        return option;
    }
}
