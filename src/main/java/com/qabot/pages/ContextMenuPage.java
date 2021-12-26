package com.qabot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends MasterPage{

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="div[class='example'] h3")
    public WebElement contextMenuHeaderTxt;

    @FindBy(id = "hot-spot")
    private WebElement box;

    public void rightClickAndAcceptTheAlert() {
        Actions action = new Actions(driver);
        action.contextClick(box).perform();
        driver.switchTo().alert().accept();
    }

}
