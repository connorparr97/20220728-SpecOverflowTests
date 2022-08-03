package eu.specsolutions.bddcourse.specoverflow.page_objects;

import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

public class BrowserStackLoginPage {
    @Autowired
    private BrowserContext browserContext;

    By usernameField = By.id("Name");
    By passwordField = By.id("Password");
    By loginButton = By.id("LoginButton");

    By askHyperlink = By.linkText("Ask Question");

    public BrowserStackLoginPage(BrowserContext browserContext) {
        this.browserContext = browserContext;
    }

    public void Login(String username, String password)
    {
       browserContext.getDriver().findElement(usernameField).sendKeys(username);
       browserContext.getDriver().findElement(passwordField).sendKeys(password);
       browserContext.getDriver().findElement(loginButton).click();
    }

    public void EnterUsername(String username)
    {
        browserContext.getDriver().findElement(usernameField).sendKeys(username);
    }

    public void EnterPassword(String password)
    {
        browserContext.getDriver().findElement(passwordField).sendKeys(password);
    }

    public void ClickLogin()
    {
        browserContext.getDriver().findElement(loginButton).click();
    }

    public void ClickAskQuestionHyperlink() {
        browserContext.getDriver().findElement(askHyperlink).click();
    }
}
