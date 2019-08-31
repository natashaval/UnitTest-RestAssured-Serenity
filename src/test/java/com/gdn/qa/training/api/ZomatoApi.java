package com.gdn.qa.training.api;

import com.gdn.qa.training.model.Categories;
import com.gdn.qa.training.model.CategoriesResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static net.serenitybdd.rest.RestRequests.given;

public class ZomatoApi extends ScenarioSteps {

    RequestSpecification base;

    @Step
    public void prepareZomatoApi(){
        base = given()
                .baseUri("https://developers.zomato.com/")
                .basePath("/api/v2.1/")
                .header("Accept", "application/json")
                .header("user-key", "7ffb03ee03041d4e839639a88a47cbb1")
        .log().all();
    }

    @Step
    public CategoriesResponse getCategories(){
        Response response = base.get("/categories");
        // harus di mapper pakai "as" ke class Response yang dituju
        // bisa pakai jsonschema2pojo
        response.getBody().prettyPrint();
        return response.as(CategoriesResponse.class);
    }
}
