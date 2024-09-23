package com.kyari.qa.testcases;

import com.kyari.qa.base.TestBase;
import com.kyari.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {

    HomePage homePage;
    CorporateGifting corporateGifting;
    PlantConsultation plantConsultation;
    CustomerSupport customerSupport;
    LoginPage loginPage;
    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test(priority = 3)
    public void clickCorporateGiftingTest(){
        corporateGifting = homePage.clickCorporateGifting();
    }

    @Test(priority = 4)
    public void clickPlantConsultationTest(){
        plantConsultation = homePage.clickPlantConsultation();
    }

    @Test(priority = 5)
    public void clickCustomerSupportTest(){
        customerSupport = homePage.clickCustomerSupport();
    }

    @Test(priority = 2)
    public void clickJadePlantTest(){
        String text = homePage.clickJadePlant();
        Assert.assertEquals(text,"Lucky Jade Plant");
    }

    @Test(priority = 1)
    public void greenDelightTextTest(){
        String text = homePage.greenDelightText();
        Assert.assertEquals(text,"Shop Our Green Delights");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
