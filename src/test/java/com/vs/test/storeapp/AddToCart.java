package com.vs.test.storeapp;

import com.vs.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Created by : Vinay Shetty
 * on 03-04-2025 at 08:27
 **/
public class AddToCart extends BaseTest {

    @Test
    public void addToCartTest() {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pooja Shetty");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        scrollToText("Belgium");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        scrollToText("Converse All Star");
        int size = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i = 0; i < size; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Converse All Star")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        // wait for new page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/toolbar_title']")), "text", "Cart"));
        String finalProductName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(finalProductName, "Converse All Star");
    }
}
