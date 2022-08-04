package eu.specsolutions.bddcourse.specoverflow.support;

import io.cucumber.spring.ScenarioScope;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@ScenarioScope
public class BrowserContext {

    private WebDriver driver;
    private String baseUrl = "https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/";

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    // invoked from BrowserHooks
    public void startBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
    }
    // invoked from BrowserHooks
    public void stopBrowser() {
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
    public void takeScreenshot(String fileName) throws IOException {
        File targetFile = new File("./target/test-output/" + fileName);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, targetFile);
        System.out.printf("The screenshot was saved to: %s%n", targetFile.getAbsolutePath());
    }
    // use it only for debugging!
    public void pauseForDebug(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
