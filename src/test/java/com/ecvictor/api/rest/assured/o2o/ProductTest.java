package com.ecvictor.api.rest.assured.o2o;

/**
 * Created by caoc on 3/24/2017.
 */

import org.junit.BeforeClass;
import org.junit.Test;

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
    public void testGetMyIp() {
        expect().statusCode(200);
        expect().body("ip", equalTo("76.65.24.106"))
                .contentType("application/json; charset=ISO-8859-1")
                .given()
                .when().get("http://ip.jsontest.com");
    }


    /**
     * Should not be able to access.
     */
    @Test
    public void testLoginCredential() {
        expect().statusCode(200);
        expect().body("username", equalTo(prop.getProperty("username")))
                .body("password", equalTo(prop.getProperty("password")))
                .contentType("application/json; charset=ISO-8859-1")
                .given()
                .when().get("http://echo.jsontest.com/username/ccao/password/123456");
    }

    /**
     * Should not be able to access.
     */
    @Test
    public void testGetECVLocation() {
        expect().statusCode(200);
        expect().body("results[0].address_components[2].long_name", equalTo("Sherbrooke Street West"))
                .contentType("application/json; charset=UTF-8")
                .given()
                .when().get("https://maps.googleapis.com/maps/api/geocode/json?address=ecvictor");
    }



}