package com.softwaretestingboard.magento.pages;


import com.aventstack.extentreports.Status;
import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    // Mouse Hover on Women Menu
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Women']")
    WebElement mouseHoverWomenMenu;

    // Mouse Hover on Tops
    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-9']//span[contains(text(),'Tops')]")
    WebElement mouseHoverTop;

    //By mouseHoverTop = By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]");
    // Click on Jackets
    public void mouseHoverWomenMenu() {
        mouseHoverToElement(mouseHoverWomenMenu);
        CustomListeners.test.log(Status.PASS, "mouseHoverWomenMenu");
    }

    //waitUntilVisibilityOfElementLocated(mouseHoverTop,10);
    public void mouseHoverOnTop() {
        mouseHoverToElement(mouseHoverTop);
        CustomListeners.test.log(Status.PASS, "mouseHoverOnTop");
    }

    //Homepage action takes to MenPage
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Men']")
    WebElement mouseHoverOnMenMenu;

    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-18']")
    WebElement mouseHoverOnBottom;


    //Mouse Hover on Men Menu
    public void mouseHoverMenMenu() {
        mouseHoverToElement(mouseHoverOnMenMenu);
        CustomListeners.test.log(Status.PASS, "mouseHoverMenMenu");
    }

    //Mouse Hover On Bottom
    public void mouseHoverBottom() {
        mouseHoverToElement(mouseHoverOnBottom);
        CustomListeners.test.log(Status.PASS, "mouseHoverBottom");
    }

    //Homepage action takes to GearPage
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Gear']")
    WebElement mouseHoverGearMenu;


    // Mouse Hover on Gear Menu
    public void mouseHoveOnGearMenu() {
        mouseHoverToElement(mouseHoverGearMenu);
        CustomListeners.test.log(Status.PASS, "mouseHoveOnGearMenu");
    }

}
