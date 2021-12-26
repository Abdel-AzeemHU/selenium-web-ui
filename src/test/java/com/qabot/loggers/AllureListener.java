package com.qabot.loggers;

import com.qabot.MasterTest;
import com.qabot.utils.DriverGenerator;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {
    private String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Test Started");
        iTestContext.setAttribute("WebDriver", DriverGenerator.getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("All Tests Run");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " failed");
        WebDriver driver = DriverGenerator.getDriver();

        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test method: " + getTestMethodName(iTestResult));
            saveFailureScreenShot(driver);
        }
        saveTextLog(iTestResult.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
