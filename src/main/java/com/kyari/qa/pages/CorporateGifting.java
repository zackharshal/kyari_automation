package com.kyari.qa.pages;

import com.kyari.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CorporateGifting extends TestBase {

    public static Logger logger = Logger.getLogger(HomePage.class);
    @FindBy(xpath = "//h2[contains(text(),\"Green gifts for everlasting bonds\")]")
    WebElement greenGiftsText;

    @FindBy(id = "full-name")
    WebElement enterFullName;

    @FindBy(id = "phone")
    WebElement enterPhoneNumber;

    @FindBy(id = "email")
    WebElement enterEmail;

    @FindBy(id = "company-name")
    WebElement enterCompanyName;

    @FindBy(id = "customisation")
    WebElement enterCustomisation;

    @FindBy(xpath = "(//button[@type=\"submit\"])[1]")
    WebElement clickSubmit;

    @FindBy(xpath = "//img[@alt=\"Aglaonema Lipstick Plant with Aura Planter\"]")
    WebElement lipStickPlant;

    @FindBy(css = ".desk_bg_img")
    WebElement enquireNow;

    @FindBy(xpath = "//h2[text()=\"FAQ\"]")
    WebElement faq;

    public CorporateGifting(){
        PageFactory.initElements(driver,this);
    }

    public String corporateGiftingText(){
        logger.info("Corporate Gifting ");
        return greenGiftsText.getText();
    }

    public void getQuote(){
        enterFullName.sendKeys("Harshal Gotarne");
        enterPhoneNumber.sendKeys("8652478946");
        enterEmail.sendKeys("2019harshal.gotarne@ves.ac.in");
        enterCompanyName.sendKeys("Bridgelabz");
        enterCustomisation.sendKeys("No need");
        clickSubmit.click();
    }

    public String clickLipStickPlant(){
        lipStickPlant.click();
        return driver.getTitle();
    }

    public String clickEnquireNow(){
        enquireNow.click();
        return faq.getText();
    }
}
