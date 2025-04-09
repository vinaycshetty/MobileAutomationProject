package com.vs.test.demoapp;

import com.vs.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by : Vinay Shetty
 * on 09-03-2025 at 21:18
 **/
public class AppiumBasics extends BaseTest {
    @Test
    public void firstTest() throws MalformedURLException {
        // xpath , id, classname -> by. and accessibilityid, androidUIAutomator -> AppiumBy.
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("vinay");
        driver.findElement(By.id("android:id/button1")).click();
    }
}
