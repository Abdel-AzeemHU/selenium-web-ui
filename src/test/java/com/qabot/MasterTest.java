package com.qabot;

import com.qabot.utils.Driver;
import com.qabot.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class MasterTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeClass
    public void beforeClass() {
        softAssert = new SoftAssert();
        driver = Driver.createDriver();
        driver.navigate().to(PropertyReader.getProperty("baseURL"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


