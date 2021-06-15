package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import static io.appium.java_client.pagefactory.LocatorGroupStrategy.*;

import io.appium.java_client.MobileElement;
import util.screens.BaseScreen;


/**
 * Object of the first screen that appears when we open the application.
 * 
 * @author Arley.Bolivar
 *
 */

public class TutorialScreen extends BaseScreen {

	/**
	 * Constructor method.
	 *
	 * @author Arley.Bolivar
	 * @param driver the driver
	 */
	public TutorialScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Get Started\")")
	private AndroidElement getStartedButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*skip_text.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Skip\")")
	private AndroidElement skipLocationButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Share Location\")")
	private AndroidElement shareLocationButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*message.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Use your location to enable\")")
	private AndroidElement locationDescriptionLabel;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*button1.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"OK\")")
	private AndroidElement allowLocationButton;

	/**
	 * @author Hans.Marquez
	 *
	 * @description: Start permissions process.
	 *
	 */
	public void startPermissionsProcess() {
		click(getStartedButton);
	}

	/**
	 * @author Hans.Marquez
	 *
	 * @description: Start permissions process.
	 *
	 */
	public DashBoardScreen skipLocationPermissions() {
		click(skipLocationButton);
		return new DashBoardScreen(driver);
	}


	/**
	 * @author Hans.Marquez
	 *
	 * @description: Returns the DashBoard screen after after handling
	 *               popUps.
	 *
	 * @return DashBoardScreen
	 */
	public DashBoardScreen handleAlerts() {

		return new DashBoardScreen(driver);
	}


	/**
	 * Alert control.
	 */
	@Override
	public void alertControl() {

	}

}
