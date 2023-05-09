package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.MenPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
  @Listeners(CustomListeners.class)
public class MenTest extends BaseTest {
    MenPage menPage ;
    HomePage homePage ;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        menPage = new MenPage();
    }
    @Test(groups = {"sanity","regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart()throws InterruptedException
    {
        Thread.sleep(3000);

        homePage.mouseHoverMenMenu();
        homePage.mouseHoverBottom();
        menPage.clickPants();
        menPage.productNameCronusYogaPantCLickOnSize32();
        menPage.productNameCronusYogaPantClickOnColourBlack();
        menPage.CronusYogaPantClickAddToCartButton();
        menPage.verifyTextMessage();
        menPage.shoppingCartLink();
        menPage.verifyShoppingCart();
        menPage.verifyProductNameCronusYogaPant();
        menPage.verifyProductSize32();
        menPage.verifyProductColourBlack();
    }
}
