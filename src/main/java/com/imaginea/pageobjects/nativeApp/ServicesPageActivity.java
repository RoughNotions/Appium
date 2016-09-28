package com.imaginea.pageobjects.nativeApp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;

public class ServicesPageActivity extends UIUtility {

    public enum Services {
        serviceTabSelected("com.snapdeal.main:id/services_tab_selected"), serviceTabUnSelected(
                "com.snapdeal.main:id/services_tab_unselected"), allServicesText(
                        "com.snapdeal.main:id/bucketMainTitle"), homeServicesText(
                                "com.snapdeal.main:id/crux_home_3x1_product_title"), sliderTitle(
                                        "com.snapdeal.main:id/sliderTitle"), homeServices("Home Services"), prepaid(
                                                "com.snapdeal.main:id/fc_header_prepaid"), enterNumber(
                                                        "com.snapdeal.main:id/fc_widget_number_et"), plan(
                                                                "com.snapdeal.main:id/plans"), recharge(
                                                                        "com.snapdeal.main:id/done");
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

    public void clickPrepaid() {
        clickElementusingID(Services.prepaid.value);
    }

    public void setNumber(String number) {
        enterTextusingID(Services.enterNumber.value, number);
    }

    public boolean isPlanAndRechargeDisplayed() {
        WebElement element = fluentWait(driver.findElementById(Services.plan.value));
        return element.isDisplayed();
    }

}
