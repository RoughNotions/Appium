package com.imaginea.pageobjects;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;

public class ServicesPageActivity extends UIUtility {

    public enum Services {
        serviceTabSelected("com.snapdeal.main:id/services_tab_selected"), serviceTabUnSelected(
                "com.snapdeal.main:id/services_tab_unselected");
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

}
