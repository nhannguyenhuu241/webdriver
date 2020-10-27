package com.ftel.isc;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test2 {
    private static WebDriver driver;
    private static String baseURL, nodeURL;

    @BeforeTest
    public static void setupTest() throws MalformedURLException {
        nodeURL = "http://172.18.27.60:45061/wd/hub";
        baseURL = "https://staging.fpt.vn/shop";
        DesiredCapabilities caps = DesiredCapabilities.safari();
        caps.setBrowserName("safari");
        caps.setPlatform(Platform.MAC);
        driver = new RemoteWebDriver(new URL(nodeURL), caps);
    }

    @Test
    public void actionTest(){
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();

        Assert.assertEquals("FPT Telecom | Đăng Ký Online", driver.getTitle());
    }

    @AfterTest
    public static void quitDriver(){
        driver.quit();
    }
}
