package com.web.automation.test;

import com.web.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightByTravelocity extends BaseTest{

    private HomePage homePage;

//    @Test(description = "Booking a flight in Travelocity")
//    public void bookZzaFlight(){
//        homePage = getHomePage();
//        log.info("Select flight button");
//        homePage.selectFlightButton();
//        log.info("Searching two travelers");
//        homePage.selectionTwoTravelers();
//        log.info("Type of flight = Round");
//        homePage.roundTripButton();
//        log.info("Selecting Origin");
//        homePage.searchFlightOrigin("LAS");
//        log.info("Selecting Departure");
//        homePage.searchFlightDeparture("LAX");
//        log.info("Selecting dates");
//        ResultsSearchFlight resultsSearchFlight = homePage.searchFlightDates();
//        log.info("Assert box to filter search elements");
//        Assert.assertTrue(resultsSearchFlight.confirmationOfOrderButton(),"Checking the filter");
//        log.info("Assert confirmation flight price");
//        Assert.assertTrue(resultsSearchFlight.confirmationFlightPriceInResults(),"Checking all the flight prices in the result");
//        log.info("Assert of flight duration");
//        Assert.assertTrue(resultsSearchFlight.confirmationOfFlightDuration(),"Confirmation of flights' duration");
//        log.info(("Assert of flight Airline and Route"));
//        Assert.assertTrue(resultsSearchFlight.confirmationOfFlightAirline(),"Checking the list is not empty");
//        Assert.assertTrue(resultsSearchFlight.confirmationOfFlightRoute(),"Checking the list is not empty");
//        log.info("Sort by short duration");
//        SelectingFlights selectingFlights = resultsSearchFlight.selectSortBy("Duration (Shortest)");
//        log.info("Assert the order");
//        Assert.assertTrue(selectingFlights.afterSort());
//        log.info("Select departure to LAX");
//        selectingFlights.clickToSelectAFlight(1);
//        log.info("Return trip to LAS");
//        selectingFlights.clickToSelectAFlight(3);
//        log.info("Price present");
//        Assert.assertTrue(selectingFlights.totalPrice(),"Checking the total price");
//        log.info("Departure and Return information of the previous selection");
//        Assert.assertTrue(selectingFlights.departureReturnInfo(),"Checking two travelers");
//        log.info("Checking the price text");
//        Assert.assertTrue(selectingFlights.priceText());
//        log.info("Assert fare Economy");
//        Assert.assertTrue(selectingFlights.fareEconomy());
//        log.info("Continue booking");
//        SecureBooking secureBooking = selectingFlights.continueBooking();
//        log.info("Input traveler name");
//        secureBooking.firstTravelerName("Laura");
//        log.info("Input traveler middle name");
//        secureBooking.firstTravelerMiddleName("Camila");
//        log.info("Input traveler last name");
//        secureBooking.firstTravelerLastName("Rodriguez");
//        log.info("Country First traveler");
//        secureBooking.firstTravelerCountry("Colombia +57");
//        log.info("Phone number");
//        secureBooking.firstTravelPhoneNumber("3205261203");
//        log.info("First traveler female Gender");
//        secureBooking.firstTravelGender();
//        log.info("First Traveler birth month");
//        secureBooking.firstTravelerBirthMonth("08 - Aug");
//        log.info("First Traveler birth day");
//        secureBooking.firstTravelerBirthDay("10");
//        log.info("First Traveler birth year");
//        secureBooking.firstTravelerBirthYear("1995");
//        log.info("Input second traveler name");
//        secureBooking.secondTravelerName("Fabio");
//        log.info("Input second traveler middle name");
//        secureBooking.secondTravelerMiddleName("Alberto");
//        log.info("Input second traveler last name");
//        secureBooking.secondTravelerLastName("Alarcon");
//        log.info("Input second traveler gender");
//        secureBooking.secondTravelGender();
//        log.info("Second Traveler birth month");
//        secureBooking.secondTravelerBirthMonth("01 - Jan");
//        log.info("Second Traveler birth day");
//        secureBooking.secondTravelerBirthDay("05");
//        log.info("Second Traveler birth year");
//        secureBooking.secondTravelerBirthYear("1989");
//        log.info("Checking 'who'");
//        Assert.assertTrue(secureBooking.whosTraveling());
//        log.info("Getting text: type of flight");
//        Assert.assertEquals(secureBooking.typeOfTravel(),"Roundtrip flight");
//        log.info("Getting text: how many tickets");
//        Assert.assertEquals(secureBooking.quantityOfTickets(),"2 tickets: 2 adults");
//        log.info("Complete booking button");
//        Assert.assertTrue(secureBooking.bookingButton());
//        log.info("State drop down");
//        Assert.assertTrue(secureBooking.stateDrpDown());
//        log.info("Tell us what you think button");
//        Assert.assertTrue(secureBooking.whatYouThink());
//
//    }

    @Test(description = "Booking a fligh, hotel and car")
    public void bookAPackage(){
        homePage = getHomePage();
        log.info("Click on Package");
        PackagePage packagePage = homePage.clickOnPackage();
        log.info("Verify the page is correctly opened");
        Assert.assertTrue(packagePage.verifyPackagePage(),"Check there are three buttons");
        log.info("Selecting origin flight");
        packagePage.searchLeavingFlight("LAS");
        log.info("Selecting destination flight");
        packagePage.searchGoingToFlight("LAX");
        log.info("Selecting last - Not working");
        homePage.selectingDatesPackage(13);
        log.info("Check");


    }
}
