package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.page_objects.BrowserStackAskQuestionPage;
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
    private String errorMessage;
    BrowserStackAskQuestionPage askQuestionPage;
    BrowserStackLoginPage loginPage;

    @When("user submits question not logged in")
    public void user_submits_question_not_logged_in() {
        browserContext.getDriver().get("https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/Ask");
        askQuestionPage = new BrowserStackAskQuestionPage(browserContext);
        askQuestionPage.SubmitQuestion();
        browserContext.WaitForElementsLoad(1000);
        errorMessage = askQuestionPage.ReturnErrorMessage();

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
        askQuestionPage = new BrowserStackAskQuestionPage(browserContext);
        loginPage = new BrowserStackLoginPage(browserContext);

        if(askQuestionPage.FetchUsername().contains("anonymous"))
        {
            //USER NOT LOGGED IN
            askQuestionPage.ClickLoginPage();
            browserContext.WaitForElementsLoad(1000);
            loginPage.Login("Marvin","1234");
            browserContext.WaitForElementsLoad(1000);
            loginPage.ClickAskQuestionHyperlink();
            askQuestionPage.SubmitQuestion();
            browserContext.WaitForElementsLoad(1000);
            errorMessage = askQuestionPage.ReturnErrorMessage();
        }
        else
        {
            //USER LOGGED IN
            askQuestionPage.SubmitQuestion();
            browserContext.WaitForElementsLoad(1000);
            errorMessage = askQuestionPage.ReturnErrorMessage();
        }
    }
    @Then("page prompts user with message title and body cannot be empty")
    public void page_prompts_user_with_message_title_and_body_cannot_be_empty() {
        assertEquals("Title and Body cannot be empty", errorMessage);
    }



}
