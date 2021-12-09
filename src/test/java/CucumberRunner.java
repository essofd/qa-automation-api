import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @wip and not @quarentine", //wip significa que o trabalho esta em progresso
                                                // e quarentine significa que hora passa e hora nao passa
        plugin = {"pretty", "html:build/reports/feature.html"},
        features = "src/test/resources/features"
)
public class CucumberRunner {
}
