package com.yavlena.ui.pages.broker;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.yavlena.ui.pages.broker.com.yavlena.ui.assertions.BrokerInfoAssertion;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BrokerPage {
    private SelenideElement findMore = $("div.load-more-brokers > a");
    private ElementsCollection brokerNames = $$("div.header-group > h3 > a");
    private SelenideElement searchField = $("#searchBox:nth-child(2)");
    private ElementsCollection phones = $$("div.tel-group > span > a");
    private SelenideElement propertiesLink = $("div.position > a");
    private SelenideElement resetSearch = $("div.filter-bar > button");
    private SelenideElement brokerAddress = $("div.header-group > div");

    @Step("Open \"Broker\" page")
    public BrokerPage open() {
        return Selenide.open("broker", BrokerPage.class);
    }

    @Step
    @Description("Click find more")
    public BrokerPage clickFindMore() {
        findMore.click();
        return new BrokerPage();
    }

    @Step
    @Description("Get Brokers names")
    public List<String> getAllBrokers(List<String> list) {
        brokerNames.get(9).should(exist);

        for (SelenideElement name : brokerNames) {
            list.add(name.getOwnText());
        }
        return list;
    }


    @Step
    @Description("Search Broker by name")
    public BrokerPage searchBrokerByName(String name) {
        searchField.sendKeys(name);
        return new BrokerPage();
    }

    @Step
    @Description("Reset Search")
    public BrokerPage resetSearch() {
        resetSearch.click();
        brokerNames.get(9).should(exist);
        return new BrokerPage();
    }

    @Step
    @Description("Verify Broker Search results")
    public BrokerPage verifyBrokerSearchResults(String name) {
        BrokerInfoAssertion brokerInfoAssertion = new BrokerInfoAssertion();

        brokerNames.get(2).should(disappear);

        brokerInfoAssertion.brokerInfoAssert(brokerNames.size(), brokerNames.get(0).getOwnText(), name, brokerAddress.getOwnText(),
                propertiesLink.getOwnText(), phones);
        return this;
    }

}
