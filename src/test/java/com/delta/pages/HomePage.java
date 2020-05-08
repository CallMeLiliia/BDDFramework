package com.delta.pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.delta.utilities.BrowserUtilities;
import com.delta.utilities.Driver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "selectTripType-val")
	public WebElement selectTripTypeDropDown;
	@FindBy(id = "input_departureDate_1")
	public WebElement departureReturnButton;
	@FindBy(xpath = "//ul[@id='selectTripType-desc']//li")
	public List<WebElement> listOfSelectTripType;

	//////////// Airport
	@FindBy(id = "fromAirportName")
	public WebElement fromAirportName;
	@FindBy(id = "search_input")
	public WebElement departureSearchInput;

	@FindBy(xpath = "//span[.='WAS']")
	public WebElement pickFromDropDownWAS;

	@FindBy(xpath = "//li[@class='airport-list ng-star-inserted']")
	public List<WebElement> optionsFromDropDownDeparture;

////////////////////////Airport

	@FindBy(xpath = "//table//tbody//tr//td//span[@class='dl-state-disabled']")
	public WebElement disabledDate;

	@FindBy(id = "toAirportName")
	public WebElement destinationAirportName;
	@FindBy(id = "search_input")
	public WebElement destinationSearchInput;
	@FindBy(xpath = "//span[.='MIA']")
	public WebElement pickFromDropDownMIA;

	@FindBy(xpath = "(//span[@class='select-ui-wrapper '])[2]")
	public WebElement quantityOfPassengers;
	@FindBy(id = "ui-list-passengers1")
	public WebElement pick2Passengers;

	@FindBy(id = "btn-book-submit")
	public WebElement submitButton;

	/// //////////////calendar
	@FindBy(id="input_returnDate_1")
	public WebElement calendarPicker;

	@FindBy(xpath = "//div//div//a//span[.='Next']")
	public WebElement nextArrow;
	@FindBy(xpath = "//span[.='Prev']")
	public WebElement prevArrow;
	@FindBy(xpath = "//button[@class='donebutton']")
	public WebElement doneButton;
	@FindBy (xpath = "//button[@value='clear']")
	public WebElement clearButton;
	@FindBy(xpath = "//span[@class='calDepartLabelCont']//span[@class='sr-only']")
	public WebElement confirmationTextElement;

	@FindBy(xpath = "//div/table//td[@class='dl-datepicker-available-day']")
	public List<WebElement> listOfdates;
	@FindBy(xpath = "//div[@class='dl-datepicker-title']")
	public List<WebElement> listOfMonth;
	@FindBy(xpath = "(//div[@class='dl-datepicker-title'])//span")
	public WebElement monthElement;
	@FindBy(xpath = "((//div[@class='dl-datepicker-title'])//span)[3]")
	public WebElement secondMonthElement;

	// ////////////// calendar

	public void clickOnSelectedDate(String month, String date, String year) {

		Actions a = new Actions(Driver.getDriver());
		int countDays = listOfdates.size();

		while (!monthElement.getText().contains(month) && !monthElement.getText().contains(year)) {
			a.moveToElement(nextArrow).click().build().perform();
		}
		for (int i = 0; i < countDays; i++) {
			String dayFromList = listOfdates.get(i).getText();
			if (dayFromList.contains(date)) {
				listOfdates.get(i).click();
				break;
			}
		}

	}
	public String getActualConfirmationTextDisplayed() {

		return confirmationTextElement.getText();
	}

	
	
	public String nextButtonFunctionality(int numberofclicks) {
				for (int i = 0; i < numberofclicks; i++) {
			nextArrow.click();
		}
					String  displayedMonth = nextMonthFromCurrent(numberofclicks);
			return displayedMonth;
	}
	  public String nextMonthFromCurrent (int numberofclicks) {
			String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
					"October", "November", "December" };
			Calendar cal = Calendar.getInstance();
			String expectedMonthAfterClicking = monthName[cal.get(Calendar.MONTH) + numberofclicks];
			return expectedMonthAfterClicking;
		}

	public String currentMonth() {
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH)];

		return month;
	}

  
	
	

	/////////////////////////////// calendar

	///////////////////////////////// TripType

	public WebElement xpathSelectTripCustom(String tripType) {

		String customXpath = "//ul[@id='selectTripType-desc']//li[.='" + tripType + "']";
		return Driver.getDriver().findElement(By.xpath(customXpath));
	}

	public void selectTripType(String tripType) {
		Actions action = new Actions(Driver.getDriver());
		BrowserUtilities.waitForClickablility(selectTripTypeDropDown, 5);
		selectTripTypeDropDown.click();
		for (WebElement l : listOfSelectTripType) {
			if (l.getText().equalsIgnoreCase(tripType)) {
				action.moveToElement(selectTripTypeDropDown).click().build().perform();
				action.moveToElement(xpathSelectTripCustom(tripType)).click().build().perform();
			}
		}

	}

/////////////////////////////////////////

	public void optionsFromDropDowm(String city) {

		fromAirportName.click();
		for (WebElement options : optionsFromDropDownDeparture) {
			String optionsToSee = options.getText();
			System.out.println(optionsToSee);
		}

	}

}
