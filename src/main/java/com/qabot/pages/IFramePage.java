package com.qabot.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage extends MasterPage {
    @FindBy(tagName = "h3")
    private WebElement header;

    @FindBy(tagName = "p")
    private WebElement paragraph;

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate IFrame page with the editor component")
    public boolean validatePage() {
        return header.getText().toLowerCase().contains("an iframe containing the");
    }

    @Step("Type text and check the paragraph")
    public String typeText(String randomText) {
        selectMenuOptions("File", "New document");
        driver.switchTo().frame(0);
        setTextElementText(paragraph, randomText);
        return paragraph.getText();
    }

    @Step("Select menu and menu option")
    private void selectMenuOptions(String menu, String option) {
        driver.findElement(By.xpath("//span[contains(.,'"+ menu + "')]")).click();
        driver.findElement(By.cssSelector("div[title='"+ option + "']")).click();
    }
}
