package com.yavlena.ui.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.yavlena.com/";
        Configuration.timeout = 6000;
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
