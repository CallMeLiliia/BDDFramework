package com.delta.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { 
				"pretty", 
				"html:target/built-inhtml-report",
				"json:target/Cucumber.json" },

		features = "@target/rerun.txt", 
		glue = "io/duotech/step_definition"
)

public class FailedScenariosRunner {

}

