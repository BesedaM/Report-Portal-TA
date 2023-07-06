package com.epam.biaseda.reportportaltest.integration;

import com.epam.biaseda.reportportaltest.api.util.ObjectMapperUtils;
import lombok.*;

import static io.restassured.RestAssured.given;

public class TeamsNotificationService {

    @Getter
    @Setter
    @AllArgsConstructor
    private static class Message {

        private String text;
    }

    private static final String WEBHOOK_URI = "https://epam.webhook.office.com/"
            + "webhookb2/c37b1dec-ec78-4aab-9bc8-1fb7da0322ae@b41b72d0-4e9f-4c26-8a69-f949f367c91d/"
            + "IncomingWebhook/8f68dff84a974c6f886923db2e7a6a39/86f199de-b91b-4dc7-88f7-28404f8656f9";

    public static void sendNotification(String notification) {
        given()
                .baseUri(WEBHOOK_URI)
                .contentType("application/json")
                .body(ObjectMapperUtils.getEntityAsJson(new Message(notification)))
                .post();
    }
}
