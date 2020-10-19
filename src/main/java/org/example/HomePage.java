package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    static class XPATH{
        public static final String CONTACT_FORM_DIV = "//div[@data-active-root-state]";
        public static final String CONTACT_FORM_CLOSE_BUTTON = "//div[@data-active-root-state]/button";
        public static final String MESSAGE_ALERT = "//div[@class='alert']";
        public static final String CLOSE_MESSAGE_ALERT = "//div[@class='alert']/span";
        public static final String LOCATION_FIELD = "//div[@class='styledSelect' and contains(text(), 'Lokalizacja')]";
        //        public static final String LOCATION_SELECT = "//div[@class='select']/ul[@class='options']/li[contains(text(), '%s')]";
        public static final String NUMBER_OF_ROOMS_FIELD = "//div[@class='styledSelect' and contains(text(), 'Liczba pokoi')]";
        public static final String ACCEPT_COOKIE = "//div[@class='cookie-info']/div/a[@class='btn-cookie-accept']";
        public static final String SPACE_FROM_FIELD = "//div[@class='styledSelect' and contains(text(), 'pow. od')]";
        public static final String SPACE_TO_FIELD = "//div[@class='styledSelect' and contains(text(), 'pow. do')]";
        public static final String SEARCH_BUTTON = "//button[@type='submit' and contains(text(), 'Szukaj')]";

    }

    public HomePage closeContactForm() {
        $x(XPATH.CONTACT_FORM_DIV).waitUntil(Condition.visible, 15000);
        if ($x(XPATH.CONTACT_FORM_DIV).exists()) {
            $x(XPATH.CONTACT_FORM_CLOSE_BUTTON).click();
        }
        return new HomePage();
    }

    public HomePage closeMessageAlert() {
        if ($x(XPATH.MESSAGE_ALERT).exists()) {
            $x(XPATH.CLOSE_MESSAGE_ALERT).click();
        }
        return new HomePage();
    }

    public HomePage closeCookieInfo() {
        $x(XPATH.ACCEPT_COOKIE).waitUntil(Condition.visible, 5000).click();
        return new HomePage();
    }

    public HomePage clickLocationField(String location) {
        $x(XPATH.LOCATION_FIELD).click();
        SelenideElement loc = $x(XPATH.LOCATION_FIELD);

        $x("//div[@class='select']/ul[@class='options']/li[contains(text(), '" + location + "')]")
                .waitUntil(Condition.visible, 5000).click();
        return new HomePage();
    }

    public HomePage selectNumberOfRooms(String rooms) {
        $x(XPATH.NUMBER_OF_ROOMS_FIELD).click();
        $x("//ul[@class='options']/li[contains(text(), '" + rooms + " pok')]")
                .waitUntil(Condition.visible, 5000).click();
        return new HomePage();
    }

    public HomePage selectSpaceFrom(String spaceFrom) {
        $x(XPATH.SPACE_FROM_FIELD).click();
        $x("//ul[@class='options']/li[contains(text(), 'od " + spaceFrom + " m2')]")
                .waitUntil(Condition.visible, 5000).click();
        return new HomePage();
    }

    public HomePage selectSpaceTo(String spaceTo) {
        $x(XPATH.SPACE_TO_FIELD).click();
        $x("//ul[@class='options']/li[contains(text(), 'do " + spaceTo + " m2')]")
                .waitUntil(Condition.visible, 5000).click();
        return new HomePage();
    }


    public HomePage selectPropertyType(String typeOfProperty) {
        $x("//fieldset[@class='customCheckbox']/label[contains(text(), '" + typeOfProperty + "')]").click();
        return new HomePage();
    }

    public ResultPage clickSearchButton() {
        $x(XPATH.SEARCH_BUTTON).click();
        return new ResultPage();
    }




}
