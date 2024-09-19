package com.kyari.qa.pages;

import com.kyari.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{
    public static Logger logger = Logger.getLogger(LoginPage.class);
    @FindBy(css = ".area--account.icon-button.icon-button--text-tooltip")
    WebElement loginIcon;

    @FindBy(id="customer_email")
    WebElement email;

    @FindBy(id="customer_password")
    WebElement password;

    @FindBy(xpath = "//button/span[text()='Login']")
    WebElement loginButton;

    @FindBy(linkText = "New Customer? Sign Up!")
    WebElement signUpLink;

    @FindBy(xpath = "(//img[@alt=\"kyari logo\"])[2]")
    WebElement kyariLogo;

    public LoginPage(){
        PageFactory.initElements(driver,this);
        loginIcon.click();
    }

    public String validateLoginPage(){
        logger.info("Login page validated");
        return driver.getTitle();
    }

    public boolean kyariInage(){
        logger.info("Kyari image validated");
        return kyariLogo.isDisplayed();
    }

    public HomePage login(String usn, String pass){
        email.sendKeys(usn);
        password.sendKeys(pass);
        loginButton.click();
        logger.info("Login validated");
        return new HomePage();
    }
}
