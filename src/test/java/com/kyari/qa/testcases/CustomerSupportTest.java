package com.kyari.qa.testcases;

import com.kyari.qa.base.TestBase;
import com.kyari.qa.pages.CustomerSupport;
import com.kyari.qa.pages.HomePage;
import com.kyari.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerSupportTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    CustomerSupport customerSupport;

    public CustomerSupportTest(){
        super();
    }


    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        customerSupport = homePage.clickCustomerSupport();
    }

    @Test
    public void checkAddressTest(){
        String text = customerSupport.checkAddress();
        Assert.assertEquals(text, "Address: 1115, Skye Earth Corporate Park AB Rd Indore, Madhya Pradesh 452010");
    }

    @Test
    public void checkPhoneNumberTest(){
        String text = customerSupport.checkPhoneNumber();
        Assert.assertEquals(text, "+91 8376885182");
    }

    @Test
    public void checkEmailTest(){
        String text = customerSupport.checkEmail();
        Assert.assertEquals(text, "support@kyari.co");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
