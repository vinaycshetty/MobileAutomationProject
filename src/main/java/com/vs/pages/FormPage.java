package com.vs.pages;

import com.vs.utils.AndroidActions;
import com.vs.utils.Contants;
import com.vs.utils.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by : Vinay Shetty
 * on 07-04-2025 at 22:17
 **/
public class FormPage extends AndroidActions{
    private AppiumDriver driver;

    public FormPage() {
        super((AndroidDriver) DriverFactory.getDriver());
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameInput;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleRadioBtn;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement maleRadioBtn;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryDropdown;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopBtn;

    public void EnterName(String name){
        nameInput.sendKeys(name);
    }

    public void selectGender(String gender){
        if (gender.equalsIgnoreCase(Contants.MALE)){
            maleRadioBtn.click();
        }else {
            femaleRadioBtn.click();
        }
    }

    public void selectCountry(String countryName){
        countryDropdown.click();
        scrollToText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }

    public void submitForm(){
        shopBtn.click();
    }

}
