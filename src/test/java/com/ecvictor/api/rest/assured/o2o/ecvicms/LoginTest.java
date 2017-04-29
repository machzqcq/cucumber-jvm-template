package com.ecvictor.api.rest.assured.o2o.ecvicms;

/**
 * Created by caoc on 3/24/2017.
 */

import com.ecvictor.api.rest.assured.o2o.RestAssuredUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by caoc on 2/22/16.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */
public class LoginTest {
    private String token;
    Properties prop = RestAssuredUtil.getProperties();

    @BeforeClass
    public static void setup() {
        RestAssuredUtil.setup();
        {
            RestAssuredUtil.setup();

        }
    }

    /**
     * Should not be able to access.
     */
    @Test
    public void testLogin() {
        expect().statusCode(200);
        expect().body("user.userName", equalTo("root"))
                .body("login",equalTo("success"))
                .contentType("application/json;charset=utf-8")
                .given().auth().basic("root", "123456")
                .when().post("http://192.168.88.187:8080/ecvcms/f/login.json");
    }


//    /**
//     * Should not be able to access.
//     */
//    @Test
//    public void testGetUserTimeline() {
//        expect().statusCode(200);
//        JSONObject jsonObj = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
//        String message="{\"taxonomyTermFieldData\": {\"tid\":null,\"langcode\": \"ch\",\"name\": \"awesome\",\"descriptionValue\": \"it's very awesome\",\"descriptionFormat\": \"it's very awesome\",\"weight\": 1,\"changed\": 0,\"defaultLangCode\":1}}";
//        expect().body("user.userName", equalTo("root"))
//                .contentType("application/json;charset=utf-8")
//                .body(jsonObj.toString())
//                .when().post("http://192.168.88.187:8080/ecvcms/a/content/taxonomyTermFieldData/update.json");
//    }

}