package com.kyari.qa.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class TestUtil {
    public static long PAGE_LOAD_TIMEOUT = 10;
    public static long IMPLICIT_WAIT= 10;

    public byte[] takeScreenshotFailure(WebDriver driver){
        int num =(int) (10000 * Math.random());
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File SFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        File DFile=new File("\"C:\\Users\\harsh\\OneDrive\\Desktop\\testing\\automation_testing\\failure_screenshots\""+ num+".png");
        try {
            FileHandler.copy(SFile,DFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

    }
}

