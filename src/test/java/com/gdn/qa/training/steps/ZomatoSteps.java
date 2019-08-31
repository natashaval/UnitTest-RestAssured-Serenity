package com.gdn.qa.training.steps;

import com.gdn.qa.training.api.ZomatoApi;
import com.gdn.qa.training.model.CategoriesResponse;
import com.gdn.qa.training.model.Category;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

// untuk yang Rest API pakai Rest-Assured
public class ZomatoSteps extends ScenarioSteps {

    // karena implement ScenarioSteps juga
    @Steps
    ZomatoApi zomatoApi;
    CategoriesResponse categories;

    @Given("^user prepare request$")
    public void userPrepareRequest() {
        zomatoApi.prepareZomatoApi();
    }

    @When("^user hit on api categories$")
    public void userHitApiCategories(){
        categories = zomatoApi.getCategories();
    }

    @Then("^id \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void idShouldBe(Integer arg0, String arg1) throws Throwable {
        Category cat = categories.getCategories()
                .stream()
                .filter(category ->
                category.getCategories().getId().equals(arg0))
                .findFirst().get();
        assertThat("Category is not same", cat.getCategories().getName(), equalTo(arg1));
    }
}
