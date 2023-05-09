package com.softwaretestingboard.magento.pages;


import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MenPage extends Utility {
    public MenPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-23']//span[contains(text(),'Pants')]")
    WebElement clickOnPants;

    @CacheLookup
    @FindBy(xpath = "//div[@id='option-label-size-143-item-175']")
    WebElement cronusYogaPantClickOnSize32;

    @CacheLookup
    @FindBy(xpath = "//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']")
    WebElement cronusYogaPantClickColourBlack;

    @CacheLookup
    @FindBy(xpath = "//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]")
    WebElement clickOnAddToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement verifyText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement clickOnShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement verifyShopping;

    @CacheLookup
    @FindBy(xpath = "//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")
    WebElement verifyCronusYogaPant;

    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'32')]")
    WebElement verifyProductSize32;

    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'Black')]")
    WebElement verifyProductColourBlack;



    //Click on Pants
    public void clickPants() {
        clickOnElement(clickOnPants);
        CustomListeners.test.log(Status.PASS, "click On Pants");

    }

    //Mouse Hover on product name Cronus Yoga Pant and click on size 32.
    public void productNameCronusYogaPantCLickOnSize32() {
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverToElementAndClick(cronusYogaPantClickOnSize32);
        CustomListeners.test.log(Status.PASS, "cronusYogaPantClickOnSize32");
    }

    //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
    public void productNameCronusYogaPantClickOnColourBlack() {
        mouseHoverToElementAndClick(cronusYogaPantClickColourBlack);
        CustomListeners.test.log(Status.PASS, "cronusYogaPantClickColourBlack");
    }

    //Mouse Hover on product name Cronus Yoga Pant and click on ‘Add To Cart’ Button.
    public void CronusYogaPantClickAddToCartButton() {
        mouseHoverToElementAndClick(clickOnAddToCart);
        CustomListeners.test.log(Status.PASS, "clickOnAddToCart");
    }

    // Verify the text You added Cronus Yoga Pant to your shopping cart.
    public void verifyTextMessage() {
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        String actualMessage = getTextFromElement(verifyText);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "You added Cronus Yoga Pant  to your ");
    }

    // Click on ‘shopping cart’ Link into message
    public void shoppingCartLink() {
        clickOnElement(clickOnShoppingCart);
        CustomListeners.test.log(Status.PASS, "clickOnShoppingCart");
    }

    // Verify the text ‘Shopping Cart.
    public void verifyShoppingCart() {
        String expectedMessage = "Shopping Cart";
        String actualMessage = getTextFromElement(verifyShopping);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Shopping Cart");
    }

    // Verify the product name ‘Cronus Yoga Pant’
    public void verifyProductNameCronusYogaPant() {
        String expectedMessage = "Cronus Yoga Pant";
        String actualMessage = getTextFromElement(verifyCronusYogaPant);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Verify the product name ‘Cronus Yoga Pant’");

    }

    // Verify the product size ‘32’
    public void verifyProductSize32() {
        String expectedMessage = "32";
        String actualMessage = getTextFromElement(verifyProductSize32);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Verify the product size ‘32’");
    }

    // Verify the product colour ‘Black’
    public void verifyProductColourBlack() {
        String expectedMessage = "Black";
        String actualMessage = getTextFromElement(verifyProductColourBlack);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Verify the product colour ‘Black’");
    }
}
