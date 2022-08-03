package eu.specsolutions.bddcourse.specoverflow.page_objects;

import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

public class BrowserStackAskQuestionPage {
    @Autowired
    private BrowserContext browserContext;

    By titleField = By.id("TitleInput");
    By bodyField = By.id("BodyInput");
    By tagField = By.id("Tags");
    By postQuestionButton = By.id("PostQuestionButton");

    By loginHyperlink = By.linkText("Login");

    By errorMessage = By.className("error");

    public BrowserStackAskQuestionPage(BrowserContext browserContext) {
        this.browserContext = browserContext;
    }

    public void EnterTitle(String title)
    {
        browserContext.getDriver().findElement(titleField).sendKeys(title);
    }

    public void EnterBody(String body)
    {
        browserContext.getDriver().findElement(bodyField).sendKeys(body);
    }

    public void EnterTags(String tags)
    {
        browserContext.getDriver().findElement(tagField).sendKeys(tags);
    }

    public void SubmitQuestion()
    {
        browserContext.getDriver().findElement(postQuestionButton).click();
    }

    public String FetchUsername()
    {
        return browserContext.getDriver().findElement(By.id("UserInfo")).getText();
    }

    public void ClickLoginPage()
    {
        browserContext.getDriver().findElement(loginHyperlink).click();
    }

    public String ReturnErrorMessage()
    {
        return browserContext.getDriver().findElement(errorMessage).getText();
    }

}
