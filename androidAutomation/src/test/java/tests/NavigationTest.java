package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.context.annotation.Description;
import screens.*;
import util.tests.BaseMobileTest;

/**
 * @author Hans.Marquez / Fabio.alarcon
 */
public class NavigationTest extends BaseMobileTest {


	/**
	 * Validate Map Screen Navigation.
	 */
	@Description(value = "Map screen Navigation test")
	@Test()
	public void navigateToMapScreen() {
		log.info("Start Navigation to Map Screen");
		DashBoardScreen dashBoard = loadDashBoardScreen();
		MapScreen map = dashBoard.goToMapScreen();
		log.info("Validate Show List Button");
		Assert.assertTrue(map.showListIsDisplayed(),"Show List not displayed");
		log.info("Validate Category Button");
		Assert.assertTrue(map.categoryIsDisplayed(),"Category not displayed");
		log.info("Validate Filter Button");
		Assert.assertTrue(map.filterIsDisplayed(),"Filter not displayed");
	}

	/**
	 * Validate Astro Orbitor attraction
	 */
	@Description(value = "Astro Orbitor navigation attraction")
	@Test()
	public void AstroOrbitor(){
		log.info("Start Navigation to Map Screen");
		DashBoardScreen dashBoard = loadDashBoardScreen();
		MapScreen map = dashBoard.goToMapScreen();
		log.info("Click on the 'show list'");
		Astro astro = map.goToAttractionList();
		log.info("Click on Astro Orbitor Attraction");
		astro.clickOnAstroAttraction();
		log.info("Validate visibility of 'Find On Map'");
		Assert.assertTrue(astro.visibilityOfFindOnMap(), "Visibility of 'Find On Map' button ");
		log.info("Validate numeric data of 'Minute Wait'");
		Assert.assertTrue(astro.numericDataMinuteWait(),"Check the text");
		log.info(astro.minutesWaited());
		log.info("Validate that age category include 'teens'");
		Assert.assertTrue(astro.teensAsAgeCategory());
	}

	/**
	 * Validate Star Wars location attraction
	 */
	@Description(value = "Navigation on Star Wars Map")
	@Test()
	public void navigateToStarWarsMapFilter() {
		log.info("Start Navigation to Map Screen");
		DashBoardScreen dashBoard = loadDashBoardScreen();
		MapScreen map = dashBoard.goToMapScreen();
		log.info("click on filter button");
		StarWars starwars = map.goToFilterButton();
		log.info("Select StarWars filter option");
		starwars.selectFilterOption();
		log.info("Apply the filter");
		starwars.applyTheFilterSelection();
		log.info("Show list options");
		starwars.goToShowList2();
		log.info("Click on the second attraction option");
		starwars.secondAttractionOption();
		log.info("Validate visibility of 'Find on Map' button");
		Assert.assertTrue(starwars.visibilityOfFindOnMapStarWars());
		log.info("Validate the existence of 'Accessibility & Other Information' section");
		Assert.assertTrue(starwars.existenceAccessibilityAndInformationButton());
	}

	/**
	 * Navigate to Dining Availability
	 */
	@Description(value = "Checking dining to reservation")
	@Test()
	public void navigateToDiningAvailability() {
		log.info("Start Navigation to Map Screen");
		DashBoardScreen dashBoard = loadDashBoardScreen();
		Dining dinig = dashBoard.goToMoreOption();
		log.info("Click on diner availability");
		dinig.diningAvailability();
		log.info("Click on Sizing 3 times");
		dinig.partySize3times();
		log.info("Party size filed display '3'");
		Assert.assertTrue(dinig.element3(),"Numeric equal 3");
		log.info("Validate visibility of Calendar");
		Assert.assertTrue(dinig.calendarVisibility());
		log.info("Validate 'Month' visibility");
		Assert.assertTrue(dinig.validateMonth(),"Check the month");
		log.info("Validate 'Year' visibility");
		Assert.assertTrue(dinig.validateYear(),"Check the year");
	}
}
