package com.imaginea.pageobjects.nativeApp;

import java.util.List;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;

public class ServicesPageActivity extends UIUtility {

    public enum Services {
        serviceTabSelected("com.snapdeal.main:id/services_tab_selected"), serviceTabUnSelected(
                "com.snapdeal.main:id/services_tab_unselected"), allServicesText(
                        "com.snapdeal.main:id/bucketMainTitle"), homeServicesText(
                                "com.snapdeal.main:id/crux_home_3x1_product_title"), sliderTitle(
                                        "com.snapdeal.main:id/sliderTitle"), homeServices("Home Services");
        public String value;

        Services(String value) {
            this.value = value;
        }
    }

    public ServicesPageActivity(AppiumDriver driver) {
        super(driver);
        new HomePageActivity(driver);
        waitForElementById(Services.serviceTabUnSelected.value);
    }

    public void selectServiceTab() {
        clickElementusingID(Services.serviceTabUnSelected.value);
        waitForElementById(Services.serviceTabSelected.value);
    }

    public List<String> getAllServicesTitle() {
        swipeDown();
        return getListOfElementsByID(Services.allServicesText.value);
    }

    public List<String> getHomeServicesTitle() {
        swipeDown();
        while (!getListOfElementsByID(Services.sliderTitle.value).contains(Services.homeServices.value)) {
            swipeDown();
        }
        return getListOfElementsByID(Services.homeServicesText.value);
    }
}
