package com.vs.utils;

import com.vs.config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Created by : Vinay Shetty
 * on 09-04-2025 at 09:16
 **/
public class DriverFactory {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public static void initDriver() throws MalformedURLException {
         ConfigReader configReader = new ConfigReader(System.getProperty("user.dir")+"//src//main//resources//config.properties");
        URL url = new URL(configReader.getProperty("url"));
        // options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("chromedriver_autodownload", true);
        options.setDeviceName(configReader.getProperty("deviceName"));
        options.setCapability("platformName", configReader.getProperty("platformName"));
        options.setCapability("automationName", configReader.getProperty("automationName"));
        options.setApp(System.getProperty("user.dir")+configReader.getProperty("app"));
        AppiumDriver appiumDriver = new AndroidDriver(url, options);
        driver.set(appiumDriver);
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
