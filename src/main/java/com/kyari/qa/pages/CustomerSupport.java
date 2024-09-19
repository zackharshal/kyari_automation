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
        return address.getText();
    }

    //Address: 1115, Skye Earth Corporate Park AB Rd Indore, Madhya Pradesh 452010
    public String checkPhoneNumber(){
        return phoneNumber.getText();
    }
    //+91 8376885182
    public String checkEmail(){
        return email.getText();
    }
    //support@kyari.co
}
