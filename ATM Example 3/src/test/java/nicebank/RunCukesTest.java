package nicebank;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "html:out" }, 
		features = "src/test/resources", 
		glue = {"nicebank"}, 
		snippets = SnippetType.CAMELCASE)

public class RunCukesTest {

}
