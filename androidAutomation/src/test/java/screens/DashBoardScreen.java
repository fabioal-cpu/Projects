package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

/**
 * DashBoard screen.
 * 
 * @author Hans.Marquez
 *
 */
public class DashBoardScreen extends BaseScreen {

	/**
	 * Constructor method.
	 * 
	 * @author Hans.Marquez
	 * 
	 * @param driver
	 *            : AndroidDriver
	 */
	public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	// AndroidElements
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*button2.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Dismiss\")")
    private AndroidElement dismissPreferenceUpdateButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*button1.*\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Visit\")")
	private AndroidElement visitPreferenceUpdateButton;
	
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tmpsubacts_primary\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Sign In, button\")")
	private AndroidElement signInButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon.*\").descriptionContains(\"Home\")")
	@AndroidFindBy(uiAutomator = "//android.widget.ImageView[contains(@content-desc,\"Home\")]")
	private AndroidElement homeButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon.*\").descriptionContains(\"Map\")")
	@AndroidFindBy(uiAutomator = "//android.widget.ImageView[contains(@content-desc,\"Map\")]")
	private AndroidElement mapButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_animated_icon.*\").descriptionContains(\"Reserve\")")
	@AndroidFindBy(uiAutomator = "//android.widget.ImageView[contains(@content-desc,\"Reserve\")]")
	private AndroidElement plusButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon.*\").descriptionContains(\"Search\")")
	@AndroidFindBy(uiAutomator = "//android.widget.ImageView[contains(@content-desc,\"Search\")]")
	private AndroidElement searchButton;

	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon.*\").descriptionContains(\"More Options\")")
	@AndroidFindBy(uiAutomator = "//android.widget.ImageView[contains(@content-desc,\"More Options\")]")
	private AndroidElement moreOptionsButton;
	
	/**
	 * @author Hans.Marquez
	 *
	 * @description: Navigate to Login Screen from DashBoard Screen.
	 *
	 */
	public LoginScreen goToLoginScreen() {
		click(signInButton);
		return new LoginScreen(driver);
	}

	/**
	 * @author Hans.Marquez
	 *
	 * @description: Navigate to Login Screen from DashBoard Screen.
	 *
	 */
	public MapScreen goToMapScreen() {
		click(dismissPreferenceUpdateButton);
		click(mapButton);
		return new MapScreen(driver);
	}

	/**
	 * Alert control.
	 */
	@Override
	public void alertControl() {
	}
}
