package com.kyari.qa.testcases;

import com.kyari.qa.base.TestBase;
import com.kyari.qa.pages.HomePage;
import com.kyari.qa.pages.LoginPage;
import com.kyari.qa.pages.PlantConsultation;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PlantConsultationTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    PlantConsultation plantConsultation;
    public PlantConsultationTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        plantConsultation = homePage.clickPlantConsultation();
    }

    @Test
    public void selectDateTest(){
        plantConsultation.selectDate();
    }

    @Test
    public void meetingSchedulerNameTest(){
        String name = plantConsultation.meetingSchedulerName();
        Assert.assertEquals(name, "Shrishty Mishra");
    }

    @Test
    public void selectTimeZoneTest(){
        String timeZone = plantConsultation.selectTimeZone();
        Assert.assertEquals(timeZone, "India Standard Time");
    }

    @Test
    public void clickGoToNextMonthTest(){
        plantConsultation.clickGoToNextMonth();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
