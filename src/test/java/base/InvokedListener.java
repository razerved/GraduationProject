package base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class InvokedListener implements IInvokedMethodListener {
    public void afterInvocation(IInvokedMethod method, ITestResult result) {


        if (result.getStatus() == ITestResult.FAILURE) {
            ITestContext iTestContext = result.getTestContext();
            WebDriver wd = (WebDriver) iTestContext.getAttribute("WebDriver");

            try {
                byte[] srcFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(srcFile);
            } catch (NoSuchSessionException ex) {

            }
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }
}
