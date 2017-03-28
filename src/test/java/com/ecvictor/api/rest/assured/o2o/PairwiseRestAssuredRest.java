package com.ecvictor.api.rest.assured.o2o;

import org.junit.Test;

/**
 * Created by caoc on 3/25/2017.
 */
public class PairwiseRestAssuredRest {
    @Test
    public void buildTestSets() {
//        String NAV_SCENARIO =
//                "Browser: Chrome, Firefox, InternetExplorer, Safari"
//                        + "\nPage: Home, Category, Search, NewProducts"
////                        + "\nProduct: Phone, Movie, Computer, Blender, Microwave, Book, Sweater"
//                        + "\nClick: Link, Image, Description";
//
//        //First, generate the list of vectors we *want*
//        IInventory inventory = PairwiseInventoryFactory.generateParameterInventory(NAV_SCENARIO);
//        List<Map<String, String>> rawDataSet = inventory.getTestDataSet().getTestSets();
//
//        //Now, go through the vectors in the database to figure out what we already *have*
//        // If we don't have it already, create it
//        int index = 0;
//        for (Map<String, String> rawTestCase : rawDataSet) {
//            System.out.println(String.format("Test Case %03d: [%s] [%s] [%s] [%s]", index++, rawTestCase.get("Browser"), rawTestCase.get("Page"), rawTestCase.get("Product"), rawTestCase.get("Click")));
//
//            expect().statusCode(200);
//            expect().body("browser", equalTo(rawTestCase.get("Browser")))
//                    .body("page", equalTo(rawTestCase.get("Page")))
//                    .contentType("application/json; charset=ISO-8859-1")
//                    .log().all()
//                    .given()
//                    .when().get("http://echo.jsontest.com/browser/" + rawTestCase.get("Browser") + "/page/" + rawTestCase.get("Page"));
//        }
    }
}
