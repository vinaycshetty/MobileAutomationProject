package com.vs.base;

import com.google.common.collect.ImmutableMap;
import com.vs.utils.ConfigReader;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Created by : Vinay Shetty
 * on 10-03-2025 at 00:24
 **/
public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void setup() throws MalformedURLException {
        // Android driver
        // Appium code -> appium server -> mobile
        // to start appium programmatically
        // file path
//        File file = new File("C://Users//vinay//AppData//Roaming//npm//node_modules//appium//build//lib//main.js");
//         service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1").usingPort(4723).build();
//        service.start();
        // two parameters to pass is one URL to appium server and options
        ConfigReader configReader = new ConfigReader(System.getProperty("user.dir")+"//src//main//resources//config.properties");
        URL url = new URL(configReader.getProperty("url"));
        // options
        UiAutomator2Options options = new UiAutomator2Options();
        // set chromedriver exe path for hybrid app
        options.setCapability("chromedriver_autodownload", true);
        options.setDeviceName(configReader.getProperty("deviceName"));
        options.setApp(System.getProperty("user.dir")+configReader.getProperty("app"));
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void LongPressAction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"
        ));
    }

    public void swipeAction(WebElement element, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction", direction,
                "percent", 0.1
        ));
    }
    public void dragDropAction(WebElement element,int x, int y){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement) element).getId(),
                "endX", x,
                "endY",y
        ));
    }

    public Double getFormattedAmount(String amount) {
        return Double.parseDouble(amount.substring(1));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
//        service.stop();
    }
}
