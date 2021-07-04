package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;
/**
 * Dining reservation screen.
 *
 * @author Fabio.alarcon
 *
 */
public class Dining extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver
     * @author Fabio.Alarcon
     */
    public Dining(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    int monthsToReservation = 3;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/actionSheetListView\").childSelector( new UiSelector().index(0))")
    private AndroidElement dinningAvailabilty;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/plus_button")
    private AndroidElement partySizeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content_text_view\").childSelector(new UiSelector().className(\"android.widget.TextView\"))")
    private AndroidElement partySizeNumber3;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.disney.wdpro.dlr:id/fl_dine_search_calendar_container\").childSelector(new UiSelector().index(0)).childSelector(new UiSelector().index(0))")
    private AndroidElement calendar;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/calendar_month_header")
    private AndroidElement julyElement;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/calendar_year_header")
    private AndroidElement yearElement;

    /**
     * Method to go to visualize the availability of diner
     */
    public void diningAvailability(){
        click(dinningAvailabilty);
    }

    /**
     * Adjusting the month to current month to reservation
     */
    public void partySize3times(){
        int i=0;
        while (i<monthsToReservation){
            click(partySizeButton);
            ++i;
        }
    }

    /**
     * Checking the calendar visibility
     * @return
     */
    public boolean calendarVisibility(){
        return isElementAvailable(calendar);
    }

    /**
     * Checking if the dashboard is update to third month
     * @return true if find the number 3 in the dashboard
     */
    public boolean element3(){
        return partySizeNumber3.getText().equalsIgnoreCase("3");
    }

    /**
     * Check if the month to reservation is the current = July
     * @return true if the month is the current one
     */
    public boolean validateMonth(){
        return julyElement.getText().matches("July");
    }

    /**
     * Check if the year to reservation is the current = 2021
     * @return true if the year is the current one
     */
    public boolean validateYear(){
        return yearElement.getText().matches("2021");
    }

    /**
     * Alert control.
     */
    @Override
    public void alertControl() {
    }
}
