package com.delta.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.delta.utilities.Driver;

public class CalendarPage {
	
	public CalendarPage() {
		PageFactory.initElements(Driver.getDriver(),this);
	};
	
	@FindBy(id = "input_departureDate_1")
	public WebElement departureReturnCalendar;
	
	
	

	
	
	
	
	
	
}
