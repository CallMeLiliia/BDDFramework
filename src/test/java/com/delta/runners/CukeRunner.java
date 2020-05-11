 package com.delta.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	
				plugin = {"rerun:target/rerun.txt",
						"html:target/built-in-html-report",
						"json:target/Cucumber.json ",
						"junit:target/Cucumber.xml"
				
				},
		
	tags = {"@wip"},
		features = "src/test/resources/delta/features" 
		,glue = "com/delta/step_definition"
		,strict=true
//  	,dryRun = true
		,monochrome = true
		,stepNotifications = true
		
		)
public class CukeRunner {

}
