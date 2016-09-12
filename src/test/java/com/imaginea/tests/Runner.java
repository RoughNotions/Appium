package com.imaginea.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;

import com.appium.manager.ParallelThread;


public class Runner {

    @Test
    public void testApp() throws Exception {
        //Below line take care of setting apk path in properies file
        Properties prop = new Properties();
        File file = new File(System.getProperty("user.dir") + "/config.properties");
        prop.load(new FileInputStream(file));        
        prop.setProperty("ANDROID_APP_PATH", new File(System.getProperty("user.dir")
                + "/src/test/resources/Snapdeal Online Shopping India_6.1.4_apk-dl.com.apk").getAbsolutePath());
        FileOutputStream fr=new FileOutputStream(file);
        prop.store(fr,"Properties");
        fr.close();
        
        ParallelThread parallelThread = new ParallelThread();
        List<String> tests = new ArrayList<String>();
        tests.add("FashionTests");        
        tests.add("MobilesElectronicsTests");
        parallelThread.runner("com.imaginea.tests",tests);
    }
}
