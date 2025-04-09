package com.vs.test.storeapp;

import com.vs.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by : Vinay Shetty
 * on 02-04-2025 at 10:42
 **/
public class LoginTest extends BaseTest {

 @Test
 public void login() throws InterruptedException {
  driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pooja Shetty");
  driver.hideKeyboard();
  driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
  driver.findElement(By.id("android:id/text1")).click();
  scrollToText("Belgium");
  driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
  driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

 }
}
