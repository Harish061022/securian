

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SpringBootTest
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
        "html:target/cucumber-report/cucumber-report.html" }, features = "src/test/resources", tags = "@retirement_calc")

public class TestRunner {

    
}
