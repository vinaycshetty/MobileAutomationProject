package com.vs.test.demoapp;

import com.vs.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

/**
 * Created by : Vinay Shetty
 * on 10-03-2025 at 09:51
 **/
public class ScrollExample extends BaseTest {
    @Test
    public void scrollTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollToText("WebView");
    }

}
