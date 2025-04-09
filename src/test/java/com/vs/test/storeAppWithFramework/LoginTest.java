package com.vs.test.storeAppWithFramework;

import com.vs.pageObject.android.FormPage;
import com.vs.base.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by : Vinay Shetty
 * on 02-04-2025 at 10:42
 **/
public class LoginTest extends BaseTest {

    @Test
    public void login(){
        FormPage formPage = new FormPage(driver);
        formPage.EnterName("Vinay Shetty");
        formPage.selectGender("male");
        formPage.selectCountry("Belgium");
        formPage.submitForm();
    }
}
