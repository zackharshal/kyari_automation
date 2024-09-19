package com.kyari.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.kyari.qa.util.TestUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static Logger logger;

    public ExtentReports report = new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("");

    public TestBase(){
        PropertyConfigurator.configure("src/main/java/com/kyari/qa/config/log4j.properties");
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/kyari/qa/config/config.properties");
            prop.load(ip);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equals("FireFox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

}
