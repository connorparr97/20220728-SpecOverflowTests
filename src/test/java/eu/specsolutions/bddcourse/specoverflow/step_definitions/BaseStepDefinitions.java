package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.page_objects.BrowserStackAskQuestionPage;
import eu.specsolutions.bddcourse.specoverflow.page_objects.BrowserStackLoginPage;
import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseStepDefinitions {
    @Autowired
    private BrowserContext browserContext;
    private String errorMessage;
    BrowserStackAskQuestionPage askQuestionPage;
    BrowserStackLoginPage loginPage;
    public void CheckAndLogUserIn()
    {
        askQuestionPage = new BrowserStackAskQuestionPage(browserContext);
        loginPage = new BrowserStackLoginPage(browserContext);

        if(askQuestionPage.FetchUsername().contains("anonymous"))
        {
            //USER NOT LOGGED IN
            askQuestionPage.ClickLoginPage();
            loginPage.Login("Marvin","1234");
            //after this method is executed, unless there is a wait it looks like the test is terminated and refuses
            //to navigate back to the askQuestion page, however with the wait code, it can go back to the
            //askQuestion page and finish the test?? having difficulty implementing the correct DriverWait
            //to achieve this as I have no idea what to check for
        }
    }


}
