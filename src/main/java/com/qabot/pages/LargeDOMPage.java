package com.qabot.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LargeDOMPage extends MasterPage {
    @FindBy(tagName = "h3")
    private WebElement header;

    @FindBy(css = "#large-table tbody")
    private WebElement table;

    public LargeDOMPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate the right page")
    public boolean validatePage() {
        return header.getText().equalsIgnoreCase("Large & Deep DOM");
    }

    @Step("Get the target cell text")
    public String getCellText(int row, int column) {
        try {
            if (row < 1 || row > 50) {
                if (column < 1 || column > 50) {
                    throw new ArrayIndexOutOfBoundsException("Invalid index");
                }
            }
            return table.findElements(By.tagName("tr")).get(row - 1)
                    .findElements(By.tagName("td")).get(column - 1).getText();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return "This is an invalid index";
    }
}
