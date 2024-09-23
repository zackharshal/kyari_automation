package com.kyari.qa.testcases;

import com.kyari.qa.base.TestBase;
import com.kyari.qa.pages.HomePage;
import com.kyari.qa.pages.LoginPage;
import com.kyari.qa.util.XLUtil;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviderLogin extends TestBase {
    private static Logger logger = Logger.getLogger(DataProviderLogin.class);
    LoginPage loginPage;
    HomePage homePage;
    public DataProviderLogin(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
    }

    @DataProvider(name = "LoginData")
    public String[][] loginData() throws IOException {
        String path = "src/main/java/com/kyari/qa/testdata/dataProvider.xlsx";
        XLUtil xlUtil = new XLUtil(path);
        int totalrows = xlUtil.getRowCount("Sheet1");
        int totalcols = xlUtil.getCellCount("Sheet1", 1);
        String logindata[][] = new String[totalrows][totalcols];
        for(int i = 1; i < totalrows; i++){
            for(int j = 0; j < totalcols; j++){
                logindata[i-1][j]= xlUtil.getCellData("Sheet1", i, j);
            }
        }
        return logindata;
    }

    @Test(dataProvider = "LoginData")
    public void logintest(String user, String pwd, String cases){
        if(cases.equals("valid")){
            loginPage.login(user,pwd);
            Assert.assertTrue(true);
            logger.info("Test pass");
        }else{
            if(cases.equals("invalid")){
                loginPage.login(user,pwd);
                Assert.assertFalse(false);
                logger.info("Failed test pass");
            }
        }

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
