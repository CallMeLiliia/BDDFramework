package com.delta.step_definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.delta.utilities.ConfigReader;
import com.delta.utilities.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class Hooks {

	
	@Before
	public void setUp() {
		Driver.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(
				ConfigReader.getConfiguration("implicitTimeout")),TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot takeScreenShot = (TakesScreenshot)Driver.getDriver();
			byte [] screenshot = takeScreenShot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			
		}	
		Driver.getDriver().close();
	}
	


	
}