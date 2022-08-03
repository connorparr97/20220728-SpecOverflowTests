package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.page_objects.BrowserStackAskQuestionPage;
import eu.specsolutions.bddcourse.specoverflow.page_objects.BrowserStackLoginPage;
import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import eu.specsolutions.bddcourse.specoverflow.support.BrowserHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AskQuestionStepDefinitions extends BaseStepDefinitions {
    @Autowired
    private BrowserContext browserContext;
    private String errorMessage;
    BrowserStackAskQuestionPage askQuestionPage;
    BrowserStackLoginPage loginPage;

    private String questionTitle = "Test";
    private String questionBody = "Test";

    @When("user submits question not logged in")
    public void user_submits_question_not_logged_in() {
        browserContext.getDriver().get(browserContext.getBaseUrl() + "Ask");
        askQuestionPage = new BrowserStackAskQuestionPage(browserContext);
        askQuestionPage.SubmitQuestion();
        askQuestionPage.WaitForError();
        errorMessage = askQuestionPage.ReturnErrorMessage();
        //userinfo seems to be set too "anonymous" for non-signed in users
        //if logged in as ANY user then userinfo is set to "logged in as"
        //therefore userinfo element is fine to deduce whether user is logged in?
    }
    @Then("page prompts user with message not logged in")
    public void page_prompts_user_with_message_not_logged_in() {
        assertEquals("Not logged in", errorMessage);
    }

    @When("user submits question without anything in title and body")
    public void user_submits_question_without_anything_in_title_and_body() {
        browserContext.getDriver().get(browserContext.getBaseUrl() + "Ask");
        askQuestionPage = new BrowserStackAskQuestionPage(browserContext);
        loginPage = new BrowserStackLoginPage(browserContext);
        CheckAndLogUserIn();
        loginPage.ClickAskQuestionHyperlink();
        askQuestionPage.SubmitQuestion();
        askQuestionPage.WaitForError();
        errorMessage = askQuestionPage.ReturnErrorMessage();
    }
    @Then("page prompts user with message title and body cannot be empty")
    public void page_prompts_user_with_message_title_and_body_cannot_be_empty() {
        assertEquals("Title and Body cannot be empty", errorMessage);
    }

    @When("user submits question with characters in body and title")
    public void user_submits_question_with_characters_in_body_and_title() {
        browserContext.getDriver().get(browserContext.getBaseUrl() + "Ask");
        askQuestionPage = new BrowserStackAskQuestionPage(browserContext);
        loginPage = new BrowserStackLoginPage(browserContext);
        CheckAndLogUserIn();
        loginPage.ClickAskQuestionHyperlink();
        askQuestionPage.EnterTitle(questionTitle);
        askQuestionPage.EnterBody(questionBody);
        askQuestionPage.SubmitQuestion();
    }
    @Then("user question should be posted to website")
    public void user_question_should_be_posted_to_website() {
        WebElement x = new WebDriverWait(browserContext.getDriver(),10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("QuestionDetails")));
        assertEquals(questionTitle,browserContext.getDriver().findElement(By.id("QuestionTitle")).getText());
    }

    //HELPER METHOD



}
