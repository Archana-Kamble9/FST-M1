package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\Features",
        glue = {"stepDefinitions"},
        tags = "@activity1 or @activity2 or @activity3 or @activity4 or @activity5",
        plugin = {"json: test-reports/json-report.json"},
        //plugin = {"html: test-reports"},
        //plugin = {"pretty"},
        monochrome = true
)

public class ActivitiesRunner {
    //empty
}
