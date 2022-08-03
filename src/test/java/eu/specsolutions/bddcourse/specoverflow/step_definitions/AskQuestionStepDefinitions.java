package eu.specsolutions.bddcourse.specoverflow.step_definitions;

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



}
