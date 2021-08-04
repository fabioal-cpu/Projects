package com.web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PackagePage extends BasePage{

    @FindBy(css = "label[class=\"uitk-pill-content\"]")
    private List<WebElement> verifyPackage;

    @FindBy(css = "button[aria-label=\"Leaving from\"]")
    private WebElement leavingFromWrapper;

    @FindBy(css = "input[data-stid=\"location-field-origin-menu-input\"]")
    private WebElement departureInput;

    @FindBy(css = "li[data-stid=\"location-field-origin-result-item\"]")
    private List<WebElement> departureOptions;

    @FindBy(css = "button[aria-label=\"Going to\"]")
    private WebElement goingToButton;

    @FindBy(id = "location-field-destination")
    private WebElement goingToText;

    @FindBy(css = "li[data-stid=\"location-field-destination-result-item\"]")
    private List<WebElement> goingToOptions;

    @FindBy(id = "d1-btn")
    private WebElement calendarButton;

    @FindBy(css = "button[class=\"uitk-date-picker-day uitk-new-date-picker-day selected edge\"]")
    private WebElement selectDayDefault;

    @FindBy(css = "td button.uitk-date-picker-day:not(.is-disabled)")
    private List<WebElement> calendarDayLists;

    @FindBy(css = "button[data-stid=\"apply-date-picker\"]")
    private WebElement calendarDoneButton;

    @FindBy(css = "button[data-testid=\"submit-button\"]")
    private WebElement submitButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public PackagePage(WebDriver pDriver) {
        super(pDriver);
    }

    public boolean verifyPackagePage(){
        boolean result = false;
        if (this.verifyPackage.size() == 3){
            result = true;
        }
        return result;
    }

    public void searchLeavingFlight(String origin){
        clickOnElement(this.leavingFromWrapper);
        this.departureInput.click();
        this.departureInput.sendKeys(origin);
        for (WebElement leaving : this.departureOptions) {
            if (leaving.getText().contains(origin)){
                leaving.click();
            }
        }
    }

    public void searchGoingToFlight(String departure){
        clickOnElement(this.goingToButton);
        this.goingToText.click();
        this.goingToText.sendKeys(departure);
        for (WebElement goingTo :this.goingToOptions) {
            if (goingTo.getText().contains(departure)){
                goingTo.click();
            }
        }
    }

    public void selectDatesPackage(int stayDays){
        clickOnElement(this.calendarButton);
        clickOnElement(this.selectDayDefault);
        String daySelected = selectDayDefault.getAttribute("data-day");
        int daysCalendarSize = this.calendarDayLists.size();

        int cont = 0;
        boolean selectedDayFlag = false;

        while (cont < daysCalendarSize-1 && !selectedDayFlag){
            if(this.calendarDayLists.get(cont).getAttribute("class").contains(daySelected)){
                this.calendarDayLists.get(cont+stayDays).click();
                selectedDayFlag = true;
            }
            cont++;
        }
        clickOnElement(this.calendarDoneButton);
        clickOnElement(this.submitButton);


    }


}
