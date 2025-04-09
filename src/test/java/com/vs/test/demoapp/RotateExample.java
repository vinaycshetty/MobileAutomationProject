package com.vs.test.demoapp;

import com.vs.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by : Vinay Shetty
 * on 10-03-2025 at 20:01
 **/
public class RotateExample extends BaseTest {
 @Test
 public void rotateTest(){
  driver.findElement(AppiumBy.accessibilityId("Preference")).click();
  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
  driver.findElement(By.id("android:id/checkbox")).click();
  DeviceRotation landscape = new DeviceRotation(0,0,90);
  driver.rotate(landscape);
  driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
  String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
  Assert.assertEquals(alertTitle, "WiFi settings");
  driver.findElement(By.id("android:id/edit")).sendKeys("vinay");
  driver.findElement(By.id("android:id/button1")).click();
 }
}
