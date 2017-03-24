package com.ecvictor.api.rest.assured.o2o;

/**
 * Created by caoc on 3/24/2017.
 */

import io.restassured.RestAssured;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.config.HttpClientConfig.httpClientConfig;


/**
 * Created by caoc on 2/22/16.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */


/**
 * Isolate set-up of REST-assured here in order not to have to change it
 * everywhere else.
 */
public class RestAssuredUtil {

    public static final void setup() {

//        Properties prop = getProperties();
//        RestAssured.baseURI = prop.getProperty("baseURI");
//        RestAssured.basePath = prop.getProperty("basePath");
//        RestAssured.port = Integer.parseInt(prop.getProperty("port"));
        // we want all the details for failed tests
        RestAssured.config().httpClient(httpClientConfig().setParam("CONNECTION_MANAGER_TIMEOUT", 10000));;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static Properties getProperties() {
        //load properties from the config file
        String resourceName = "config.properties"; // could also be a constant
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        try {
            InputStream resourceStream = loader.getResourceAsStream(resourceName);
            prop.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}