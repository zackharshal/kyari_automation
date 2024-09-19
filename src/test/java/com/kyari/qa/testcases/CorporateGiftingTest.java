package com.kyari.qa.testcases;

import com.kyari.qa.base.TestBase;
import com.kyari.qa.pages.CorporateGifting;
import com.kyari.qa.pages.HomePage;
import com.kyari.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class CorporateGiftingTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    CorporateGifting corporateGifting;
    public CorporateGiftingTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        corporateGifting = homePage.clickCorporateGifting();
    }

    @Test(priority = 1)
    public void corporateGiftingTextTest(){
        String text = corporateGifting.corporateGiftingText();
        Assert.assertEquals(text,"Green gifts for everlasting bonds");
    }

    @Test(priority = 2)
    public void getQuote(){
        corporateGifting.getQuote();
    }

    @Test(priority = 3)
    public void clickLipStickPlant(){
        String text = corporateGifting.clickLipStickPlant();
        Assert.assertEquals(text, "Aglaonema Lipstick Plant with Aura Planter – Kyari.co");
    }

    @Test(priority = 4)
    public void clickEnquireNowTest(){
        String text = corporateGifting.clickEnquireNow();
        Assert.assertEquals(text, "FAQ");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
