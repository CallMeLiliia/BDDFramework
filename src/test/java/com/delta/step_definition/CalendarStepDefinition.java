package com.delta.step_definition;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.delta.pages.HomePage;
import com.delta.utilities.BrowserUtilities;
import com.delta.utilities.ConfigReader;
import com.delta.utilities.Driver;
import com.delta.utilities.LoggerUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalendarStepDefinition {

	Logger logger = LoggerUtils.getLogger(HomePageStepDefinition.class);
	
	
	@Given("I am on the home page")
	public void i_am_on_the_home_page() throws InterruptedException {
		Driver.getDriver().manage().timeouts()
				.implicitlyWait(Long.parseLong(ConfigReader.getConfiguration("implicitTimeout")), TimeUnit.SECONDS);
		Driver.getDriver().get(ConfigReader.getConfiguration("url"));

		BrowserUtilities.waitFor(2);

		logger.info("Navigating to Home Page");
		String actualTitle = Driver.getDriver().getTitle();
		String expectedTitle = "Airline Tickets & Flights: Book Direct with Delta Air Lines - Official Site";

		Assert.assertEquals(expectedTitle, actualTitle);
		logger.info("Navigating to Home Page");

	}

	@Given("Trip type should be displayed as a {string}")
	public void trip_type_should_be_displayed_as_a(String string) {

		HomePage homePage = new HomePage();
		homePage.selectTripType("Round Trip");
		logger.info("Selecting Round Trip");

	}

	@When("I click on depart-return button")
	public void i_click_on_depart_return_button() {
		HomePage homePage = new HomePage();
		BrowserUtilities.waitForClickablility(homePage.departureReturnButton, 5);
		homePage.departureReturnButton.click();

	}

	@Then("I click on depart {string} date and month {string}, year {string}")
	public void i_click_on_depart_date_and_month_year(String month, String day, String year) {
		
		HomePage homePage = new HomePage();
		homePage.clickOnSelectedDate("May", "10","2020");

	}

	@Then("I click on return {string} date and month {string},year {string}")
	public void i_click_on_return_date_and_month_year(String month, String day, String year) {
		HomePage homePage = new HomePage();
		homePage.clickOnSelectedDate("May", "16","2020");
		
	}

	@Then("Click on done button")
	public void click_on_done_button() {
		HomePage homePage = new HomePage();
		homePage.doneButton.click();
		
		
		
		homePage.getActualConfirmationTextDisplayed();
	}

	@Then("Picked date should be displayed in depart-return button")
	public void picked_date_should_be_displayed_in_depart_return_button() {

		HomePage homePage = new HomePage();
		homePage.getActualConfirmationTextDisplayed();
		System.out.println("++++++++++++++++++++++++"+homePage.getActualConfirmationTextDisplayed());
    	System.out.println(	"++++++++++++++++++++++++"+homePage.currentMonth());
	
    	
    	
    	
    	
    	
    	
//    	homePage.calendarPicker.click();
//		homePage.clearButton.click();
//		BrowserUtilities.waitFor(2);
//		
//		
//		String expectedMonth =homePage.nextButtonFunctionality(3);
//		String actualMonthDisplayed =homePage.monthElement.getText();
//		System.out.println("*******************"+actualMonthDisplayed);
//		System.out.println("%%%%%%%%%%%%%%%%%%"+expectedMonth);
//			//	Assert.assertEquals(expectedMonth, actualMonthDisplayed);
//				System.out.println("*******************"+actualMonthDisplayed);
//				System.out.println("%%%%%%%%%%%%%%%%%%"+expectedMonth);
	
	}

	@Then("I click {int} times on  select next month button")
	public void i_click_times_on_select_next_month_button(Integer numberofclicks) {
		HomePage homePage = new HomePage();
		homePage.calendarPicker.click();
		homePage.clearButton.click();
		BrowserUtilities.waitFor(2);
		String expectedMonth =homePage.nextButtonFunctionality(numberofclicks);
		String actualMonthDisplayed =homePage.monthElement.getText();
		System.out.println("********%%%%%%%%%"+actualMonthDisplayed);
		System.out.println("*********%%%%%%%%%%%%%%%%%%"+expectedMonth);
				Assert.assertEquals(expectedMonth, actualMonthDisplayed);
				System.out.println("*******************"+actualMonthDisplayed);
				System.out.println("%%%%%%%%%%%%%%%%%%"+expectedMonth);
	}

	@Then("Calendar should display  correct month")
	public void calendar_should_display_correct_month() {
	
		
	}
	@Then("I click {int} on select previous month button")
	public void i_click_on_select_previous_month_button(Integer int1) {
	}

	@Then("Calendar should display previous month")
	public void calendar_should_display_previous_month() {
	}

	@Then("I click on clear button")
	public void i_click_on_clear_button() {
	}

	@Then("Calendar should diselect all dates")
	public void calendar_should_diselect_all_dates() {
	}

}
