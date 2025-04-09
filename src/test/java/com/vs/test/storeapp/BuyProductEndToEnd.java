package com.vs.test.storeapp;

import com.vs.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/**
 * Created by : Vinay Shetty
 * on 03-04-2025 at 10:02
 **/
public class BuyProductEndToEnd extends BaseTest {
    @Test
    public void sumAmountTest() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pooja Shetty");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        scrollToText("Belgium");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        scrollToText("Air Jordan 1 Mid SE");
        int size = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i = 0; i < size; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Air Jordan 1 Mid SE")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        scrollToText("Converse All Star");
        int size1 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i = 0; i < size1; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Converse All Star")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(5000);
//         wait for new page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/toolbar_title']")), "text", "Cart"));
        Double totalSum = 0.0;
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        for (int i=0;i<count;i++){
            String amount = productPrices.get(i).getText();
            Double price = getFormattedAmount(amount);
            totalSum = totalSum +price;
        }
        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double formattedDisplaySum = getFormattedAmount(displaySum);
        Assert.assertEquals(totalSum,formattedDisplaySum);
        WebElement termsAndConditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        LongPressAction(termsAndConditions);
        String alertTest = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
        Assert.assertEquals(alertTest,"Terms Of Conditions");
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(10000);
    }
}
