package org.example;

import static com.codeborne.selenide.Selenide.$$x;

public class ResultPage {

    static class XPATH{
        public static final String RESULT_ON_LIST = "//table[@id='offersTable']/tbody/tr";
    }

    public int getResults() {
        return  $$x(XPATH.RESULT_ON_LIST).size();
    }

}
