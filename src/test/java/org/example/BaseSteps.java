package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.Before;

public class BaseSteps {

    public BaseSteps() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }
}
