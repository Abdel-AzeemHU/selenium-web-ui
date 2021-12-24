package com.qabot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

public class HomePage extends MasterPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public <T extends MasterPage> T clickLinkByText(String text, Class<T> page) {
        WebElement link = driver.findElement(By.partialLinkText(text));
        T newPage = null;
        clickButton(link);
        try {
             newPage = page.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return newPage;
    }
}
