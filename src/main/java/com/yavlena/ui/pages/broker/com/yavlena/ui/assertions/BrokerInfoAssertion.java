package com.yavlena.ui.pages.broker.com.yavlena.ui.assertions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;

public class BrokerInfoAssertion {
    String prefix = "+359";

    public void brokerInfoAssert(int brokerNameSize, String brokerNameActual, String brokerNameExpected,
                                 String brokerAddress, String properties, ElementsCollection phonesList) {

        SoftAssert asrt = new SoftAssert();

        asrt.assertEquals(brokerNameSize, 1, "Broker " + brokerNameActual + " search results has more than one broker");
        asrt.assertEquals(brokerNameActual, brokerNameExpected,
                "Broker " + brokerNameActual + " search results  name is not equal to search params");
        asrt.assertTrue(brokerAddress.length() > 1, "Broker " + brokerNameActual + " search results address is empty");
        asrt.assertEquals(phonesList.size(), 2, "Broker " + brokerNameActual + " search results has less than one phone number");
        for (SelenideElement phoneNumber : phonesList) {
            asrt.assertTrue(phoneNumber.getOwnText().startsWith(prefix),
                    "Broker " + brokerNameActual + " search results phone not started with +359");
        }
        asrt.assertTrue(properties.matches(".*\\d+\\s+имота.*"), "Broker " + brokerNameActual + " search results has no properties");
        asrt.assertAll();
    }
}
