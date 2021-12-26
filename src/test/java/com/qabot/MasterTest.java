package com.qabot;

import com.qabot.pages.HomePage;
import com.qabot.utils.DriverGenerator;
import com.qabot.utils.PropertyReader;
import com.qabot.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class MasterTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = DriverGenerator.createDriver();
        driver.navigate().to(PropertyReader.getProperty("baseURL"));
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void tearDown() {
        DriverGenerator.stopDriver();
    }
}


