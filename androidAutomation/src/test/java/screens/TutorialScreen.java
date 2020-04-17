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

	// AndroidElements
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageButton\").descriptionContains(\"Close\")") 
	@AndroidFindBy(uiAutomator = "new UiSelector().classNameMatches(\".*Button.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*button2.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"ALLOW\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_allow_button\")")
	private AndroidElement alertsPopUps;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tmpsubacts_root\").childSelector(new UiSelector().textContains(\"Sign In\"))")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tmpsubacts_primary\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Sign In, button\")")
	private MobileElement signInButton;



	/**
	 * @author Hans.Marquez
	 *
	 * @description: Returns the DashBoard screen after after handling
	 *               popUps.
	 *
	 * @return DashBoardScreen
	 */
	public DashBoardScreen handleAlerts() {

		int retries = 0;
		while(retries < 6) {
			try {
				if(alertsPopUps.isDisplayed() == true) {
					click(alertsPopUps, 3);
					retries++;
				}
			}catch(Exception e) {
				retries++;
				System.out.println("Not Pop Ups");
			}
		}
		return new DashBoardScreen(driver);
	}


	/**
	 * @author Hans.Marquez
	 *
	 * @description: Scroll Over Tutorial
	 *
	 */
	public void scrollOverTutorial() {
		isElementAvailable(alertsPopUps);
		scrollDown(3);
		scrollUp(3);
	}

	/**
	 * Alert control.
	 */
	@Override
	public void alertControl() {
		alertsPopUps.click();
	}

}
