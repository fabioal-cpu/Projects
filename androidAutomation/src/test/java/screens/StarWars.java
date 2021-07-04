package screens;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

/**
 * Star Wars screen.
 *
 * @author Fabio.alarcon
 *
 */

public class StarWars extends BaseScreen {

    /**
     * Constructor method for standard screens object.
     *
     * @param driver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public StarWars(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.disney.wdpro.dlr:id/filter_group_container\").childSelector( UiSelector().index(1)).childSelector(UiSelector().index(4))")
    private AndroidElement starWarsButton;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/filter_apply")
    private AndroidElement applyFilterButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/baymax_list_fragment_container\").childSelector(new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/finderListView\").childSelector(new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"Datapad\")))")
    private AndroidElement secondAttraction;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/cta_section_recyclerview\").childSelector(new UiSelector().index(1))")
    private AndroidElement findOnMapButton2;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/expandable_view_title")
    private AndroidElement accessibilityOtherInformationButton;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/toggleTitle")
    private AndroidElement showFullListButton;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/finder_detail_guests_height_section")
    private AndroidElement scrollDown;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/close_inline_popup")
    private AndroidElement closePopUp;

    /**
     * Method to select a filter option
     */
    public void selectFilterOption(){
        click(starWarsButton);
    }

    /**
     * Method to apply the selection in the filter
     */
    public void applyTheFilterSelection(){
        click(applyFilterButton);
    }

    /**
     * Method to see the attraction, base on the filter
     */
    public void goToShowList2() {
        click(showFullListButton);
    }

    /**
     * Select the second attraction
     */
    public void secondAttractionOption(){
        click(secondAttraction);
    }

    /**
     * Checking the 'Find On Map' visibility
     * @return true if the word is founded
     */
    public boolean visibilityOfFindOnMapStarWars() {
        return isElementAvailable(findOnMapButton2);
    }

    /**
     * Checking if 'AccessibilityAndInformation' button is available
     * @return true if the button is available
     */
    public boolean existenceAccessibilityAndInformationButton() {
        click(closePopUp);
        return isElementAvailable(accessibilityOtherInformationButton);
    }

    /**
     * Alert control.
     */
    @Override
    public void alertControl() {

    }

}
