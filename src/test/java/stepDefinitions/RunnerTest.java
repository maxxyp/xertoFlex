package stepDefinitions;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (strict = false,
        features = "src/test/resources/feature",
        format = {"pretty", "json:target/cucumber.json"}
//        tags = {"@SignIn"}
)
public class RunnerTest {


}
