package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.WomenPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Listeners(CustomListeners.class)
public class WomenTest extends BaseTest {
    WomenPage womenPage ;
    HomePage homePage ;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        womenPage = new WomenPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity","regression"})
    public void sortByProductName()throws InterruptedException
    {
        Thread.sleep(3000);
        homePage.mouseHoverWomenMenu();
        homePage.mouseHoverOnTop();
        womenPage.clickOnJackets();

        List<WebElement> jacketsElementsList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> jacketsNameListBefore = new ArrayList<>();
        for (WebElement value : jacketsElementsList) {
            jacketsNameListBefore.add(value.getText());
        }
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Product Name");

        // After Sorting value
        jacketsElementsList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> jacketsNameListAfter = new ArrayList<>();

        //waitUntilVisibilityOfElementLocated(By.xpath("//strong[@class='product name product-item-name']//a"),10);
        for (WebElement value : jacketsElementsList) {
            jacketsNameListAfter.add(value.getText());
        }
        // Sort the before name list into Ascending Order
        jacketsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order

        // Verify the products name display in alphabetical order

        Assert.assertEquals(jacketsNameListBefore, jacketsNameListAfter);
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void sortByPriceFilter()throws InterruptedException
    {
         Thread.sleep(3000);
        homePage.mouseHoverWomenMenu();
        homePage.mouseHoverOnTop();
        womenPage.clickOnJackets();

        // Storing jackets price in list
        List<WebElement> jacketsPriceElementList = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> jacketsPriceListBefore = new ArrayList<>();
        for (WebElement value : jacketsPriceElementList)
        {
            //Converting price in to Double and Removing $ from price
            jacketsPriceListBefore.add(Double.valueOf(value.getText().replace("$", "")));
        }

        // Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Price");

        // waitUntilVisibilityOfElementLocated(By.xpath("//li[@class='item product product-item']"),10);

        // After Sorting Products by Price
        jacketsPriceElementList = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> jacketsPriceListAfter = new ArrayList<>();

        for (WebElement value : jacketsPriceElementList)
        {
            //Converting price in to Double and Removing $ from price
            jacketsPriceListAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Sort the jacketPriceListBefore to Ascending Order
        Collections.sort(jacketsPriceListBefore);
        // Verify the products price display in Low to High
       Assert.assertEquals(jacketsPriceListBefore, jacketsPriceListAfter);
    }
}
