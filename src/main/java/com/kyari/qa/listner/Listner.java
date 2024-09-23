package com.kyari.qa.listner;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.kyari.qa.base.TestBase;
import com.kyari.qa.util.TestUtil;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner extends TestBase implements ITestListener {
    public static Logger logger = Logger.getLogger(Listner.class);
    TestUtil testUtil;
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test case started" +result.getName());
        report.attachReporter(spark);
        test=report.createTest(result.getName());
        test.log(Status.INFO,"The test case is started " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test case passed" +result.getName());
        test=report.createTest(result.getName());
        test.log(Status.PASS,"The test case is started" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test case failed" +result.getName());
        test=report.createTest(result.getName());
        test.log(Status.FAIL,"The test case is started" + result.getName());
        testUtil=new TestUtil();
        testUtil.takeScreenshotFailure(driver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test case Skipped " +result.getName());
        test=report.createTest(result.getName());
        test.log(Status.SKIP,"The test case is started" + result.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("flushed the Extent report." );
        report.flush();

    }
}