package com.gdn.qa.training.steps;

import com.gdn.qa.training.api.DummyApi;
import com.gdn.qa.training.model.EmployeeRequest;
import com.gdn.qa.training.model.EmployeeResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.E;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DummyEmployeeSteps extends ScenarioSteps {

    @Steps
    DummyApi dummyApi;

    EmployeeRequest postRequest;
    EmployeeRequest postResponse;
    EmployeeResponse getResponse;

    @Given("^user prepare dummy rest$")
    public void userPrepareDummyRest(){
        dummyApi.prepareDummyApi();
    }

    @When("^user post new employee data$")
    public void userPostNewEmployeeData(){
        postRequest = new EmployeeRequest("jojojojjoj", 12345, 1200);
        postResponse = dummyApi.postEmployee(postRequest);
    }

    @Then("^response post should be true$")
    public void responsePostTrue(){
        assertThat("Name not same", postResponse.getName(), equalTo(postRequest.getName()));
        assertThat("Salary not same", postResponse.getSalary(), equalTo(postRequest.getSalary()));
        assertThat("Age not same", postResponse.getAge(), equalTo(postRequest.getAge()));
    }

    @When("^user retrieve employee data$")
    public void retrieveEmployee(){
        getResponse = dummyApi.getEmployee(postResponse.getId());
    }

    @Then("^response get should be true$")
    public void responseGetTrue(){
        assertThat("Name not same", getResponse.getEmployee_name(), equalTo(postResponse.getName()));
        assertThat("Id not same", getResponse.getId(), equalTo(postResponse.getId()));
        assertThat("Salary not same", getResponse.getEmployee_salary(), equalTo(postResponse.getSalary()));
        assertThat("Age not same", getResponse.getEmployee_age(), equalTo(postResponse.getAge()));
    }
}
