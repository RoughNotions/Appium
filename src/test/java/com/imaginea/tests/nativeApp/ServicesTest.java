package com.imaginea.tests.nativeApp;

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

import com.imaginea.base.BaseTest;
import com.imaginea.base.UserBaseTest;
import com.imaginea.pageobjects.nativeApp.ServicesPageActivity;

public class ServicesTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.launchApp();
    }

    @Test
    public void verifyServicesTabIsSelectedOrNot() {
        ServicesPageActivity servicesPageActivity = new ServicesPageActivity(driver);
        servicesPageActivity.selectServiceTab();
        Assert.assertTrue(servicesPageActivity.isElementPresent(ServicesPageActivity.Services.serviceTabSelected.value),
                "Service Tab is not selected");
    }

    @Test
    public void verifyAllServicesText() {
        ServicesPageActivity servicesPageActivity = new ServicesPageActivity(driver);
        servicesPageActivity.selectServiceTab();
        String title[] = { "Book an Uber", "Movie Tickets ", "Order Food", "Personal Services", "Buses", "Flights",
                "Bill Payments", "More" };
        List<String> actualTitle = servicesPageActivity.getAllServicesTitle();
        Assert.assertEquals(actualTitle, Arrays.asList(title));
    }

    @Test
    public void verifyHomeServicesText() {
        ServicesPageActivity servicesPageActivity = new ServicesPageActivity(driver);
        servicesPageActivity.selectServiceTab();
        String title[] = { "Home Cleaning", "Plumbers", "Salon at Home" };
        List<String> actualTitle = servicesPageActivity.getHomeServicesTitle();
        Assert.assertEquals(actualTitle, Arrays.asList(title));
    }

    @Test
    public void verifyPrepaidTab() {
        ServicesPageActivity servicesPageActivity = new ServicesPageActivity(driver);
        servicesPageActivity.selectServiceTab();
        servicesPageActivity.clickPrepaid();
        servicesPageActivity.setNumber("9030169971");
        Assert.assertTrue(!servicesPageActivity.isPlanAndRechargeDisplayed());
    }

    @AfterMethod
    public void afterMethod() {
        driver.closeApp();
    }

}
