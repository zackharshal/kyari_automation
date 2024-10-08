package com.kyari.qa.pages;

import com.kyari.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlantConsultation extends TestBase {

    public static Logger logger = Logger.getLogger(PlantConsultation.class);

    @FindBy(xpath = "//div[@data-component=\"today-dot\"]")
    WebElement todaysDot;

    @FindBy(xpath = "//div[@data-component=\"name\"]")
    WebElement name;

    @FindBy(id = "timezone-field")
    WebElement timeZone;

    @FindBy(xpath = "(//div[contains(text(),\"India Standard Time\")])[1]")
    WebElement selectTimeZone;

    @FindBy(xpath = "//button[@aria-label=\"Go to next month\"]")
    WebElement goToNextMonth;

    public PlantConsultation(){
        PageFactory.initElements(driver,this);
    }

    public void selectDate(){
        todaysDot.click();
        logger.info("Click the date");
    }

    public String meetingSchedulerName(){
        logger.info("Gets the name of Meeting scheduler");
        return name.getText();
    }

    public String selectTimeZone(){
        timeZone.click();
        selectTimeZone.click();
        logger.info("Selects the time zone");
        return selectTimeZone.getText();
    }

    public void clickGoToNextMonth(){
        goToNextMonth.click();
        logger.info("Click on the next month");
    }
}
