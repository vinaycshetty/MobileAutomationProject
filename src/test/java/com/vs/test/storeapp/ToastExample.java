package com.vs.test.storeapp;

import com.vs.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by : Vinay Shetty
 * on 02-04-2025 at 10:59
 **/
public class ToastExample extends BaseTest {
 @Test
 public void toastTest(){
  // to handle the toast message - tag name will be android.widget.Toast
  // and we can get the text of that toast message by attribute name
  driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
  driver.findElement(By.id("android:id/text1")).click();
  scrollToText("Belgium");
  driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
  driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
  String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getDomAttribute("name");
  Assert.assertEquals(toastMessage,"Please enter your name");
 }
}
