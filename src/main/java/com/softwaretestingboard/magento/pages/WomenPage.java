package com.softwaretestingboard.magento.pages;


import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage extends Utility {
    public WomenPage(){
        PageFactory.initElements(driver,this);
    }
    // Click on Jackets
    @CacheLookup
            @FindBy(xpath = "//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
    WebElement clickOnJacket;


    public void clickOnJackets()
    {
        clickOnElement(clickOnJacket);
        CustomListeners.test.log(Status.PASS,"clickOnJacket");
    }
}
