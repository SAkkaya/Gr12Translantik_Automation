package com.translantik.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/failed-html-report"}, // for report
        features = "@target/rerun.txt", // find only the failed feature file
        glue = "com/translantik/step_definitions" // find the step defs

)

public class FailedTestRunner {

}
