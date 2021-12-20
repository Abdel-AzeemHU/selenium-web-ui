package com.qabot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MasterPage {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        // Chrome driver
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/properties/userdata.properties");
        prop.load(file);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            // Firefox code
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("IE")) {
            // IE code
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

}
