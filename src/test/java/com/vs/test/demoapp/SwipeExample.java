package com.vs.test.demoapp;

import com.vs.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by : Vinay Shetty
 * on 10-03-2025 at 10:31
 **/
public class SwipeExample extends BaseTest {
 @Test
 public void SwipeTest(){
  driver.findElement(AppiumBy.accessibilityId("Views")).click();
  driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
  driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
  WebElement firstPhoto = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
  Assert.assertEquals(firstPhoto.getDomAttribute("focusable"),"true");
  swipeAction(firstPhoto,"left");
  Assert.assertEquals(firstPhoto.getDomAttribute("focusable"),"false");
 }
}
