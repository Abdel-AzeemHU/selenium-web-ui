package com.qabot.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends MasterPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click {0} link to open {page} page")
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
