package com.yavlena.ui.pages.broker;

import com.codeborne.selenide.*;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
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
    @Description("Verify Broker Search results")
    public BrokerPage verifyBrokerSearchResults(String name, String prefix) {

        brokerNames.shouldHave(CollectionCondition.size(1));
        brokerNames.get(0).shouldHave(exactText(name));
        brokerAddress.shouldNotBe(empty);

        phones.shouldHave(CollectionCondition.size(2));

        for (SelenideElement phoneNumber : phones) {
            String number = phoneNumber.getOwnText();
            Assert.assertTrue(number.startsWith(prefix));
        }

        propertiesLink.should(matchText(".*\\d+\\s+имота.*"));
        return this;
    }

    @Step
    @Description("Reset Search")
    public BrokerPage resetSearch() {
        resetSearch.click();
        brokerNames.get(9).should(exist);
        return new BrokerPage();
    }


}
