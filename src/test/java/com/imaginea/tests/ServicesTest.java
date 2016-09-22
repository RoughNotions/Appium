package com.imaginea.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.pageobjects.ServicesPageActivity;

public class ServicesTest extends UserBaseTest {

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

    @Test
    public void verifyServicesTabIsSelectedOrNot() {
        ServicesPageActivity servicesPageActivity = new ServicesPageActivity(driver);
        servicesPageActivity.selectServiceTab();
        Assert.assertTrue(
                servicesPageActivity.isElementPresent(ServicesPageActivity.Services.serviceTabSelected.value),
                "Service Tab is not selected");
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
