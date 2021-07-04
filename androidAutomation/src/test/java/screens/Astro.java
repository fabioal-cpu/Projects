package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class Astro extends BaseScreen {

    /**
     * Constructor method for standard screens object.
     *
     * @param driver
     * @author fabio.alarcon
     */
    public Astro(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    // AndroidElements
    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/finder_detail_text")
    private  AndroidElement findOnMapText;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/finder_detail_wait_time_minutes")
    private  AndroidElement minutesStandbyText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\".*Teens\")")
    private AndroidElement teensText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/finderListView\").childSelector( new UiSelector().index(3))")
    private AndroidElement astroAttractionButton;

    /**
     * Click on the attraction Astro
     */
    public void clickOnAstroAttraction(){
        click(astroAttractionButton);
    }

    /**
     *Check if 'Find On Map' is available
     * @return Availability of an element
     */
    public boolean visibilityOfFindOnMap() {
        return isElementAvailable(findOnMapText);
    }

    /**
     *Check if 'numeric data' is available
     * @return Availability of an element
     */
    public boolean numericDataMinuteWait() {
        return isElementAvailable(minutesStandbyText);
    }

    /**
     *Return how much minutes you have to wait in the line
     * @return time on line
     */
    public String minutesWaited(){
        return minutesStandbyText.getText();
    }

    /**
     *Check if the attraction is available for teens
     * @return true, if the text has the word 'teens'
     */
    public boolean teensAsAgeCategory() {
        return teensText.getText().contains("Teens");
    }

    /**
     * Alert control.
     */
    @Override
    public void alertControl() {

    }

}
