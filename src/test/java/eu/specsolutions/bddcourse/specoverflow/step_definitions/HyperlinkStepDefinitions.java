package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.page_objects.BrowserStackAskQuestionPage;
import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HyperlinkStepDefinitions extends BaseStepDefinitions {
    @Autowired
    private BrowserContext browserContext;

    @When("user clicks the home button")
    public void user_clicks_the_home_button() {
        browserContext.getDriver().get(browserContext.getBaseUrl() + "Login");
        WebElement homeHyperlink = browserContext.getDriver().findElement(By.linkText("Home"));
        homeHyperlink.click();
    }
    @Then("browser loads home page")
    public void browser_loads_home_page() {
        assertEquals("Home - Spec Overflow", browserContext.getDriver().getTitle());
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        browserContext.getDriver().get(browserContext.getBaseUrl());
        WebElement loginHyperlink = browserContext.getDriver().findElement(By.linkText("Login"));
        loginHyperlink.click();
    }
    @Then("browser loads login page")
    public void browser_loads_login_page() {
        assertEquals("Login - Spec Overflow", browserContext.getDriver().getTitle());
    }

    @When("user clicks the register button")
    public void user_clicks_the_register_button() {
        browserContext.getDriver().get(browserContext.getBaseUrl());
        WebElement registerHyperlink = browserContext.getDriver().findElement(By.linkText("Register"));
        registerHyperlink.click();
    }
    @Then("browser loads register page")
    public void browser_loads_register_page() {
        assertEquals("Register - Spec Overflow", browserContext.getDriver().getTitle());
    }

    @When("user clicks the questions button")
    public void user_clicks_the_questions_button() {
        browserContext.getDriver().get(browserContext.getBaseUrl());
        WebElement questionsHyperlink = browserContext.getDriver().findElement(By.linkText("Questions"));
        questionsHyperlink.click();
    }
    @Then("browser loads questions page")
    public void browser_loads_questions_page() {
        assertEquals("All Questions - Spec Overflow", browserContext.getDriver().getTitle());
    }

    @When("user clicks ask question button")
    public void user_clicks_ask_question_button() {
        browserContext.getDriver().get(browserContext.getBaseUrl());
        WebElement askQuestionHyperlink = browserContext.getDriver().findElement(By.linkText("Ask Question"));
        askQuestionHyperlink.click();
    }
    @Then("browser loads ask question page")
    public void browser_loads_ask_question_page() {
        assertEquals("Ask a Question - Spec Overflow", browserContext.getDriver().getTitle());
    }

    @When("user clicks logout button")
    public void user_clicks_logout_button() {

    }
    @Then("browser logs user out")
    public void browser_logs_user_out() {

    }


}
