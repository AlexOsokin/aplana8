import autotest.pages.BasePage;
import autotest.steps.BaseSteps;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "autotest/steps",
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"}
)

public class CucumberRunner{
}
