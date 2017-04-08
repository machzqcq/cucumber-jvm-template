package com.ecvictor.api.rest.assured.o2o.twitter;

/**
 * Created by caoc on 3/24/2017.
 */

import com.ecvictor.api.rest.assured.o2o.RestAssuredUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.Properties;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by caoc on 2/22/16.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */
public class ProductTest {
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
    public void testGetUserTimeline() {
        expect().statusCode(200);
        expect().body("[0].id_str", equalTo("850726222111924225"))
                .contentType("application/json;charset=utf-8")
                .given().auth().oauth("fu0Q7boXTSmGwbJr2UbNKacT8","VRXWN4xWUv5KvNAgRYmvqUlnDl6jBgEZKmVJpEMx47ouBTH1Tn",
                "846843580882866176-rgW5abXjp2KJZwqUSSgFa3ayNQ8jRzL","Z6Xwl8HryhevFxlagXbVFILeQlaVATGZQVMvlpUKalAn3")
                .when().get("https://api.twitter.com/1.1/statuses/user_timeline.json");
    }    /**
     * Should not be able to access.
     */
    @Test
    public void testPostUserTimeline() {
        expect().statusCode(200);
        expect().body("id_str", equalTo(Collections.singletonList("848231288238735362")))
                .contentType("application/json;charset=utf-8")
                .given().auth().oauth("fu0Q7boXTSmGwbJr2UbNKacT8","VRXWN4xWUv5KvNAgRYmvqUlnDl6jBgEZKmVJpEMx47ouBTH1Tn",
                "846843580882866176-rgW5abXjp2KJZwqUSSgFa3ayNQ8jRzL","Z6Xwl8HryhevFxlagXbVFILeQlaVATGZQVMvlpUKalAn3")
                .param("status", "Post from Rest Assured")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");
    }


}