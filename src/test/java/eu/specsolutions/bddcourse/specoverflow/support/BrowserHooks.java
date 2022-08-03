package eu.specsolutions.bddcourse.specoverflow.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.springframework.beans.factory.annotation.Autowired;

public class BrowserHooks {

    @Autowired
    private BrowserContext browserContext;

    @BeforeAll
    public static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void startBrowser() {
        browserContext.startBrowser();
    }

    @After
    public void stopBrowser() {
        browserContext.stopBrowser();
    }

}
