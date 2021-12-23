package com.qabot;

import com.qabot.utils.Driver;
import com.qabot.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class MasterTest {

    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = Driver.createDriver();
        driver.navigate().to(PropertyReader.getProperty("baseURL"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


