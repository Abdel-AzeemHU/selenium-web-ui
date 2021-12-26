package com.qabot.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ChallengingDOMPage extends MasterPage {
    @FindBy(tagName = "h3")
    private WebElement header;

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;

    public ChallengingDOMPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate page")
    public boolean validatePage() {
        return header.getText().equalsIgnoreCase("challenging DOM");
    }

    @Step("Print and validate table headers")
    public int validateColumn(int index) {
        try {
            if (index >9) throw new ArrayIndexOutOfBoundsException("index: " + index + " does not exist");

            List<String> texts = rows.stream()
                    .map(r->r.findElements(By.tagName("td")).get(index))
                    .map(cell->cell.getText()).collect(Collectors.toList());

            texts.parallelStream().forEach(System.out::println);
            return texts.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
