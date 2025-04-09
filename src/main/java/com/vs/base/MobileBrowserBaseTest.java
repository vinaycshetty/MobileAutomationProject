package com.vs.base;

import com.google.common.collect.ImmutableMap;
import com.vs.utils.ConfigReader;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Created by : Vinay Shetty
 * on 07-04-2025 at 10:28
 **/
public class MobileBrowserBaseTest {
    public AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        ConfigReader configReader = new ConfigReader(System.getProperty("user.dir") + "//src//main//resources//config.properties");
        URL url = new URL(configReader.getProperty("url"));
        // options
        UiAutomator2Options options = new UiAutomator2Options();
        // set chromedriver exe path for hybrid app
        options.setCapability("chromedriver_autodownload", true);
        options.setDeviceName(configReader.getProperty("deviceName"));
        options.setCapability("brwoserName",configReader.getProperty("browser"));
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
