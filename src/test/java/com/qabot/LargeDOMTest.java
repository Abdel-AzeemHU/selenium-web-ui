package com.qabot;

import com.qabot.pages.LargeDOMPage;
import com.qabot.utils.JsonReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

public class LargeDOMTest extends MasterTest {
    LargeDOMPage largeDOMPage;

    @Test(priority = 1, description = "Validate the right page")
    void testValidatePage() {
        largeDOMPage = homePage.clickLinkByText("Large & Deep DOM", LargeDOMPage.class);
        softAssert.assertTrue(largeDOMPage.validatePage());
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Validate the text inside the target cell", dataProvider = "jsonPath")
    void testCellText(Map table) {
        int row = Integer.parseInt(table.get("row").toString());
        int column = Integer.parseInt(table.get("column").toString());
        String cell = table.get("cell").toString();

        softAssert.assertEquals(largeDOMPage.getCellText(row,column), cell);
        softAssert.assertAll();
    }

    @DataProvider(name = "jsonPath")
    Iterator<Map> readJsonpath() {
        return JsonReader.dataIterator("data.json", "$.table");
    }
}
