package com.yavlena.ui.base.com.yavlena.ui;

import com.yavlena.ui.base.BaseTest;
import com.yavlena.ui.pages.broker.BrokerPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class BrokerPageTest extends BaseTest {
    private BrokerPage brokerPage = new BrokerPage();

    @Test
    @Description("Check Brokers Page with search by name Soft assertion")
    public void checkBrokersAssert() {

        brokerPage
                .open()
                .clickFindMore();

        List<String> brokersList = new ArrayList<>();
        brokerPage.getAllBrokers(brokersList);

        for (String name : brokersList) {
            brokerPage
                    .searchBrokerByName(name)
                    .verifyBrokerSearchResults(name)
                    .resetSearch();
        }
    }

}
