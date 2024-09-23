package com.kyari.qa.testcases;

import com.kyari.qa.base.TestBase;
import com.kyari.qa.listner.Listner;
import com.kyari.qa.pages.HomePage;
import com.kyari.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(Listner.class)
public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageValidation(){
        String title = loginPage.validateLoginPage();
        Assert.assertEquals(title, "Account – Kyari.co");
    }

    @Test(priority = 2)
    public void kyariLogoTest(){
        boolean isPresent = loginPage.kyariInage();
        Assert.assertTrue(isPresent);
    }

    @Test(priority = 3)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
