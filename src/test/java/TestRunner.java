import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/features"},
        tags = {"@Search-SelectFirsService"},
        plugin = {
                "json:target/cucumber.json",
                "junit:target/cucumber-results.xml",
                "pretty:target/cucumber-pretty.txt",
                "html:target/cucumber-html-report",}
)

public class TestRunner {
}
