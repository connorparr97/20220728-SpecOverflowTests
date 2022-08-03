package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HyperlinkStepDefinitions {
    @Autowired
    private BrowserContext browserContext;

    @When("user clicks the home button")
    public void user_clicks_the_home_button() {
        browserContext.getDriver().get("https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/login");
        WebElement homeHyperlink = browserContext.getDriver().findElement(By.linkText("Home"));
        homeHyperlink.click();
    }
    @Then("browser loads home page")
    public void browser_loads_home_page() {
        assertEquals("Home - Spec Overflow", browserContext.getDriver().getTitle());
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        browserContext.getDriver().get("https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/");
        WebElement loginHyperlink = browserContext.getDriver().findElement(By.linkText("Login"));
        loginHyperlink.click();
    }
    @Then("browser loads login page")
    public void browser_loads_login_page() {
        assertEquals("Login - Spec Overflow", browserContext.getDriver().getTitle());
    }


    @When("user clicks the register button")
    public void user_clicks_the_register_button() {
        browserContext.getDriver().get("https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/");
        WebElement registerHyperlink = browserContext.getDriver().findElement(By.linkText("Register"));
        registerHyperlink.click();
    }
    @Then("browser loads register page")
    public void browser_loads_register_page() {
        assertEquals("Register - Spec Overflow", browserContext.getDriver().getTitle());
    }

}
