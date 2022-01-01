package com.qabot;

import com.qabot.pages.FileUploadPage;
import org.testng.annotations.Test;

public class FileUploadTest extends MasterTest{

    FileUploadPage fileUploadPage;

    @Test(priority = 1, description = "Upload file and check if the file uploaded successfully")
    public void checkFileUpload() {
        fileUploadPage = homePage.clickLinkByText("File Upload", FileUploadPage.class);
        softAssert.assertTrue(fileUploadPage.getFileUploadHeaderText());
        System.out.println("The file upload header is: " + fileUploadPage.getTheHeaderText());
        fileUploadPage.uploadFile();
        softAssert.assertTrue(fileUploadPage.getHeaderTextAfterUpload());
        System.out.println("The header after the file uploaded successfully is: " + fileUploadPage.getTheHeaderText());
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Check if the file uploaded successfully")
    public void checkTheFileUploadSuccess() {
        softAssert.assertTrue(fileUploadPage.getHeaderTextAfterUpload());
        System.out.println("The header after the file uploaded successfully is: " + fileUploadPage.getTheHeaderText());
        System.out.println("The file uploaded name is: " + fileUploadPage.getUploadedFileName());
    }

}
