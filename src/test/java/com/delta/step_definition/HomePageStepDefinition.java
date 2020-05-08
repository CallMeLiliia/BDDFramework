package com.delta.step_definition;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.delta.utilities.ConfigReader;
import com.delta.utilities.Driver;
import com.delta.utilities.LoggerUtils;

import io.cucumber.java.en.Given;

public class HomePageStepDefinition {

	Logger logger = LoggerUtils.getLogger(HomePageStepDefinition.class);

//	@Given("I am on the home page")
//	public void i_am_on_the_home_page() {
//
//		Driver.getDriver().manage().timeouts()
//				.implicitlyWait(Long.parseLong(ConfigReader.getConfiguration("implicitTimeout")), TimeUnit.SECONDS);
//		Driver.getDriver().get(ConfigReader.getConfiguration("url"));
//
//		logger.info("Navigating to Home Page");
//
//	}

}
