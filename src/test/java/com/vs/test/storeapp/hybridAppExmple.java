package com.vs.test.storeapp;

import com.vs.base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by : Vinay Shetty
 * on 07-04-2025 at 09:25
 **/
public class hybridAppExmple extends BaseTest {
    @Test
    public void hybridAppTest() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vinay Shetty");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        scrollToText("Air Jordan 1 Mid SE");
        int size = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i = 0; i < size; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Air Jordan 1 Mid SE")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);
        // this will get me all context
        Set<String> contexts = driver.getContextHandles();

        String nativeAppContext = null;
        String webAppContext = null;

        for (String context : contexts) {
            if (context.contains("NATIVE")) {
                nativeAppContext = context;
            } else if (context.contains("WEB")) {
                webAppContext = context;
            }
        }
        // switch the context to webview
        driver.context(webAppContext);
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context(nativeAppContext);
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vinay Shetty");
    }
}
