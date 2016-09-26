package com.imaginea.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.appium.manager.AppiumParallelTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class UserBaseTest extends AppiumParallelTest {

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        getDriver().quit();
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
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
