package com.kyari.qa.pages;

import com.kyari.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{

    public static Logger logger = Logger.getLogger(HomePage.class);
    @FindBy(xpath = "(//a//span[contains(text(),\"Home\")])[1]")
    WebElement homeLink;

    @FindBy(xpath = "(//a//span[contains(text(),\"Corporate Gifting\")])[1]")
    WebElement corporateGifting;

    @FindBy(id = "menu-item-plant-consultation-classic")
    WebElement plantConsultation;

    @FindBy(id = "menu-item-customer-support-classic")
    WebElement customerSupport;

    @FindBy(xpath = "//span[text()='Lucky Jade Plant']")
    WebElement jadePlant;

    @FindBy(xpath = "//h1[contains(text(),\"Lucky Jade Plant\")]")
    WebElement textJade;

    @FindBy(xpath = "//h2[contains(text(), \"Shop Our Green Delights\")]")
    WebElement greenDelight;

    public HomePage(){
        PageFactory.initElements(driver,this);
        homeLink.click();
    }

    public CorporateGifting clickCorporateGifting(){
        corporateGifting.click();
        logger.info("Corporate Gifting validated");
        return new CorporateGifting();
    }

    public PlantConsultation clickPlantConsultation(){
        plantConsultation.click();
        logger.info("Plant Consultation validated");
        return new PlantConsultation();
    }

    public CustomerSupport clickCustomerSupport(){
        customerSupport.click();
        logger.info("Customer Support validated");
        return new CustomerSupport();
    }

    public String clickJadePlant(){
        jadePlant.click();
        logger.info("Jade Plant validated");
        return textJade.getText();

    }

    public String greenDelightText(){
        logger.info("Green delight text validated");
        return greenDelight.getText();
    }
}
