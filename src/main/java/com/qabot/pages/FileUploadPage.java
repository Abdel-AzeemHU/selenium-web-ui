package com.qabot.pages;

import com.qabot.utils.WaitUtils;
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

    public String getTheHeaderText() {
        return fileUploadHeaderTxt.getText();
    }

    public boolean getFileUploadHeaderText() {
        return fileUploadHeaderTxt.getText().contains("File Uploader");
    }

    public boolean getHeaderTextAfterUpload() {
        return fileUploadHeaderTxt.getText().contains("File Uploaded!");
    }

    public void uploadFile() {
        chooseFileBtn.sendKeys(System.getProperty("user.dir") + "/src/main/resources/upload.txt");
        clickButton(uploadBtn);
        WaitUtils.waitVisibilityOf(driver, fileUploadHeaderTxt, 20);

    }

    public String getUploadedFileName() {
        return uploadedFileTxt.getText();
    }
}
