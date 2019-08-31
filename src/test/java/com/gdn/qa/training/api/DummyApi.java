package com.gdn.qa.training.api;

import com.gdn.qa.training.model.EmployeeRequest;
import com.gdn.qa.training.model.EmployeeResponse;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.springframework.beans.factory.annotation.Autowired;

import static net.serenitybdd.rest.RestRequests.given;

public class DummyApi extends ScenarioSteps {
    RequestSpecification dummy;

    @Step
    public void prepareDummyApi(){
        RestAssured.registerParser("text/html", Parser.JSON);
        dummy = given()
                .baseUri("http://dummy.restapiexample.com/")
                .basePath("api/v1/")
                .header("Accept", "application/json")
                .log().all();
    }

    @Step
    public EmployeeRequest postEmployee(EmployeeRequest request){
        Response response = dummy
                .contentType("application/json; charset=UTF-8")
                .body(request)
                .post("/create");
        response.getBody().prettyPrint();
        return response.getBody().as(EmployeeRequest.class);
    }

    @Step
    public EmployeeResponse getEmployee(int id){
        Response response = dummy
                .contentType("application/json")
                .accept("application/json")
                .body("")
                .get("/employee/{id}", id);
        response.getBody().prettyPrint();
        return response.as(EmployeeResponse.class);
    }
}
