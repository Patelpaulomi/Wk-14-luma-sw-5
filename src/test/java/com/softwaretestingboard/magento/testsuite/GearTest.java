package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.GearPage;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class GearTest extends BaseTest {
    GearPage gearPage ;
    HomePage homePage ;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        gearPage = new GearPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldAddProductSuccessFullyToShoppingCar() throws InterruptedException
    {
        Thread.sleep(3000);
        homePage.mouseHoveOnGearMenu();
        gearPage.clickOnBags();
        gearPage.productNameOvernightDuffle();
        gearPage.verifyTextOvernightDuffle();
        gearPage.changeQty3();
        gearPage.addToCart();
        gearPage.verifyTextShoppingCart();
        gearPage.shoppingCartLinkMessage();
        //gearPage.verifyQty3();
        gearPage.productPrice$135();
        gearPage.changeQty5();
        gearPage.updateShoppingCartButton();
        gearPage.productPrice$225();
    }
}
