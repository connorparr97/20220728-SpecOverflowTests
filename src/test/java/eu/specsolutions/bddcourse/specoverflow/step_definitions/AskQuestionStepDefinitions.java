package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.page_objects.BrowserStackLoginPage;
import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import eu.specsolutions.bddcourse.specoverflow.support.BrowserHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AskQuestionStepDefinitions {
    @Autowired
    private BrowserContext browserContext;
    private String userName;
    private String errorMessage;

    @When("user submits question not logged in")
    public void user_submits_question_not_logged_in() {
        browserContext.getDriver().get("https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/Ask");
        userName = browserContext.getDriver().findElement(By.id("UserInfo")).getText();
        WebElement submitQuestionBtn = browserContext.getDriver().findElement(By.cssSelector("input[type=submit]"));
        submitQuestionBtn.click();
        browserContext.WaitForElementsLoad(1000);
        errorMessage = browserContext.getDriver().findElement(By.className("error")).getText();
        //userinfo seems to be set too "anonymous" for non-signed in users
        //if logged in as ANY user then userinfo is set to "logged in as"
        //therefore userinfo element is fine to deduce whether user is logged in?
    }
    @Then("page prompts user with message not logged in")
    public void page_prompts_user_with_message_not_logged_in() {
        assertEquals("Not logged in", errorMessage);
    }

    @When("user submits question without anything in title or body")
    public void user_submits_question_without_anything_in_title_or_body() {
        browserContext.getDriver().get("https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/Ask");
        userName = browserContext.getDriver().findElement(By.id("UserInfo")).getText();

        if(!browserContext.getDriver().findElement(By.id("UserInfo")).getText().contains("anonymous"))
        {
            System.out.println("USER LOGGED IN");
            WebElement submitQuestionBtn = browserContext.getDriver().findElement(By.cssSelector("input[type=submit]"));
            submitQuestionBtn.click();
            browserContext.WaitForElementsLoad(1000);
            errorMessage = browserContext.getDriver().findElement(By.className("error")).getText();
        }
        else
        {
            System.out.println("USER NOT LOGGED IN");
            WebElement loginHyperlink = browserContext.getDriver().findElement(By.linkText("Login"));
            loginHyperlink.click();
            browserContext.WaitForElementsLoad(1000);
            BrowserStackLoginPage loginPage = new BrowserStackLoginPage(browserContext);
            loginPage.Login("Marvin","1234");
            browserContext.WaitForElementsLoad(1000);
            WebElement askHyperLink = browserContext.getDriver().findElement(By.linkText("Ask Question"));
            askHyperLink.click();
            WebElement submitQuestionBtn = browserContext.getDriver().findElement(By.cssSelector("input[type=submit]"));
            submitQuestionBtn.click();
            browserContext.WaitForElementsLoad(1000);
            errorMessage = browserContext.getDriver().findElement(By.className("error")).getText();
        }
    }
    @Then("page prompts user with message title and body cannot be empty")
    public void page_prompts_user_with_message_title_and_body_cannot_be_empty() {
        assertEquals("Title and Body cannot be empty", errorMessage);
    }



}
