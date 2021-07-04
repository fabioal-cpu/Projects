package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

// TODO: Auto-generated Javadoc

/**
 * Map screen.
 * 
 * @author Hans.Marquez / Fabio.alarcon
 *
 */
public class MapScreen extends BaseScreen {

	/**
	 * Constructor method.
	 *
	 * @author Hans.Marquez / Fabio.alarcon
	 * @param driver the driver
	 */
	public MapScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	// AndroidElements
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle.*\")")
	private AndroidElement categoryList;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
	@AndroidFindBy(id = "com.disney.wdpro.dlr:id/filterTitle")
	private AndroidElement filterButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tmpsubacts_primary\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
	private AndroidElement showListButton;

	@AndroidFindBy(id = "com.disney.wdpro.dlr:id/toggleTitle")
	private AndroidElement showFullListButton;

	/**
	 * @author Hans.Marquez
	 *
	 * @description: return true if Category List element is displayed in screen, otherwise false.
	 *
	 */
	public boolean categoryIsDisplayed() {
		return isElementAvailable(categoryList);
	}

	/**
	 * @author Hans.Marquez
	 *
	 * @description: return true if Filter Button element is displayed in screen, otherwise false.
	 *
	 */
	public boolean filterIsDisplayed() {
		return isElementAvailable(filterButton);
	}

	/**
	 * @author Hans.Marquez
	 *
	 * @description: return true if Show List Button element is displayed in screen, otherwise false.
	 *
	 */
	public boolean showListIsDisplayed() {
		return isElementAvailable(showListButton);
	}

	/**
	 * Go to attraction general full list
	 * @return driver to Astro class
	 */
	public Astro goToAttractionList() {
		click(showFullListButton);
		return new Astro(driver);
	}

	/**
	 * Go to filter general full list
	 * @return driver to Star Wars class
	 */
	public StarWars goToFilterButton(){
		click(filterButton);
		return new StarWars(driver);
	}

	/**
	 * Alert control.
	 */
	@Override
	public void alertControl() {
		// TODO Auto-generated method stub

	}
}
