package com.vs.test.mobilebrowserapp;

import com.vs.base.MobileBrowserBaseTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by : Vinay Shetty
 * on 07-04-2025 at 10:33
 **/
public class BrowserAutomatinExample extends MobileBrowserBaseTest {
    @Test
    public void mobileBrowserTest() throws InterruptedException {
        driver.get("http://google.com");
        Thread.sleep(20000);
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
        System.out.println("COntexts are "+nativeAppContext+" and "+webAppContext);
        // switch the context to webview
        driver.context(webAppContext);
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.close();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
