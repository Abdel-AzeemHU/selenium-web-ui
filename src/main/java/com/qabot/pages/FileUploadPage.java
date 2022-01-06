package com.qabot.pages;

import com.qabot.utils.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends MasterPage{

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='example'] h3")
    private WebElement fileUploadHeaderTxt;

    @FindBy(id = "file-upload")
    private WebElement chooseFileBtn;

    @FindBy(id = "file-submit")
    private WebElement uploadBtn;

    @FindBy(css = "#drag-drop-upload")
    private WebElement boxUploader;

    @FindBy(css = "#uploaded-files")
    private WebElement uploadedFileTxt;

    @Step("Get the header page text")
    public String getTheHeaderText() {
        return fileUploadHeaderTxt.getText();
    }

    @Step("Get the header page text after file uploaded")
    public String getUploadedFileName() {
        return uploadedFileTxt.getText();
    }

    @Step("Verify the header page text before file upload")
    public boolean getFileUploadHeaderText() {
        return fileUploadHeaderTxt.getText().contains("File Uploader");
    }

    @Step("Verify the header page text after file uploaded")
    public boolean getHeaderTextAfterUpload() {
        return fileUploadHeaderTxt.getText().contains("File Uploaded!");
    }

    @Step("Upload the file")
    public void uploadFile() {
        chooseFileBtn.sendKeys(System.getProperty("user.dir") + "/src/main/resources/upload.txt");
        clickButton(uploadBtn);
        WaitUtils.waitVisibilityOf(driver, fileUploadHeaderTxt, 20);
    }

}
