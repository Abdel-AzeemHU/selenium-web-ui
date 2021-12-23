package com.qabot.utils;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class Driver {
    private final static Map<String, Function<Boolean, WebDriver>> map = new HashMap<>();
    private static WebDriver driver = null;

    static {
        map.put(Browser.CHROME.browserName(),(h)-> {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(chromeOptions(h));
        });
        map.put(Browser.FIREFOX.browserName(), (h)-> {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(firefoxOptions(h));
        } );
    }

    public static WebDriver createDriver() {
        boolean headless = Boolean.parseBoolean(PropertyReader.getProperty("headless"));
        driver = createDriverInstance(headless);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createDriverInstance(boolean headless) {
        String browser = PropertyReader.getProperty("browser").toLowerCase();
        Function<Boolean,WebDriver> fn = map.get(browser);
        if (fn !=null) {
            return fn.apply(headless);
        }
        throw new IllegalArgumentException("No Such browser found: " + browser.toUpperCase());
    }

    private static ChromeOptions chromeOptions(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension",false);
        if (headless) {
            options.setHeadless(true);
            options.addArguments("window-size=2000,1080");
        }
        return options;
    }

    private static FirefoxOptions firefoxOptions(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        //option.addPreference("browser.download.folderList", 2);
        //option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        //option.addPreference("browser.download.manager.showWhenStarting", false);
        //option.addPreference("pdfjs.disabled", true);
        if (headless) {
            options.setHeadless(true);
        }
        return options;
    }
}
