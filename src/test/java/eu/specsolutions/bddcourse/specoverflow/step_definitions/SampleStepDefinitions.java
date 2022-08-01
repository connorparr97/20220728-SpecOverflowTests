package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleStepDefinitions {
    ChromeDriver driver;
    @Autowired
    private BrowserContext browserContext;

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        driver = new ChromeDriver();
        driver.get("https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/");
        WebElement loginHyperLink = driver.findElement(By.linkText("Login"));
        loginHyperLink.click();
    }
    @Then("browser loads login page")
    public void browser_loads_login_page() {
        assertEquals("Login - Spec Overflow", driver.getTitle());
    }


    @When("user clicks the register button")
    public void user_clicks_the_register_button() {
        driver = new ChromeDriver();
        driver.get("https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/");
        WebElement registerHyperLink = driver.findElement(By.linkText("Register"));
        registerHyperLink.click();
    }
    @Then("browser loads register page")
    public void browser_loads_register_page() {
        assertEquals("Register - Spec Overflow", driver.getTitle());
    }

}
