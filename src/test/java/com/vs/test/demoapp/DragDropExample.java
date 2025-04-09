package com.vs.test.demoapp;

import com.vs.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by : Vinay Shetty
 * on 10-03-2025 at 19:41
 **/
public class DragDropExample extends BaseTest {
    @Test
    public void dragDropTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        dragDropAction(source,619,560);
        String results = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(results,"Dropped!");
    }
}
