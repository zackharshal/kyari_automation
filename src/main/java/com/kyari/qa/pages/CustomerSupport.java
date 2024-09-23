package com.kyari.qa.pages;

import com.kyari.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerSupport extends TestBase {
    public static Logger logger = Logger.getLogger(CustomerSupport.class);

    @FindBy(xpath = "//span[contains(text(),\"Address\")]")
    WebElement address;

    @FindBy(xpath = "(//a[@title=\"tel:8376885182\"])[1]")
    WebElement phoneNumber;

    @FindBy(xpath = "//b[text()=\"support@kyari.co\"]")
    WebElement email;

    public CustomerSupport(){
        PageFactory.initElements(driver,this);
    }

    public String checkAddress(){
        logger.info("Gets the address");
        return address.getText();
    }

    public String checkPhoneNumber(){
        logger.info("Gets the phone number");
        return phoneNumber.getText();
    }

    public String checkEmail(){
        logger.info("Gets the info");
        return email.getText();
    }
}
