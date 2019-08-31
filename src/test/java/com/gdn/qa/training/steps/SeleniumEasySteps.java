package com.gdn.qa.training.steps;

import com.gdn.qa.training.pages.SeleniumEasyHomePage;
import com.gdn.qa.training.pages.SimpleFormPage;
import com.gdn.qa.training.pages.SimpleSelectPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class SeleniumEasySteps extends ScenarioSteps {
    // nama scenario harus unique, yang di .feature bisa di Ctrl+Click ke function yang dituju
    // Given pakai regex
    // kalau masih kuning, create Definitions

    SeleniumEasyHomePage seleniumEasyHomePage;
    SimpleFormPage simpleFormPage;
    SimpleSelectPage simpleSelectPage;

    @Given("^user open selenium easy homepage$")
    public void userOpenSeleniumEasyHomepage() {
        seleniumEasyHomePage.open();
    }

    @When("^user click button Start Practising$")
    public void userClickButtonStartPractising() {
        seleniumEasyHomePage.click_start();
    }

    @When("^user click on \"([^\"]*)\" on homepage$")
    public void userClickOnSimpleFormDemo(String menu) {
        seleniumEasyHomePage.clickMenuList(menu);
    }

    @Then("^user should on simple form demo page$")
    public void userShouldOnSimpleFormDemoPage() {
        // pakai hamcrest; pakai yang 3 field
        assertThat("Field message not displayed", simpleFormPage.isFieldInputMessageDisplayed(),
                equalTo(true));
    }

    @When("^user type \"([^\"]*)\" on message$")
    public void userTypeOnMessage(String text) throws Throwable {
        simpleFormPage.enterMessage(text);
//        throw new PendingException();
    }

    @When("^user click on Show Message$")
    public void userClickOnShowMessage() {
        simpleFormPage.showMessageButtonClick();
    }

    @Then("^user should able to see \"([^\"]*)\" message$")
    public void userShouldAbleToSeeMessage(String text) {
        assertThat("Display message is not correct!", simpleFormPage.isMessageDisplayed(),
                equalTo(text));
    }

    @Then("^user should on simple select demo page$")
    public void userShouldOnSimpleSelectDemoPage() {
        assertThat("User is not able to see selection", simpleSelectPage.isSelectVisible(),
                equalTo(true));
    }

    @When("^user select \"([^\"]*)\" on select demo$")
    public void userSelectOnSelectDemo(String day) throws Throwable {
        simpleSelectPage.selectDayByValue(day);
    }

    @Then("^user should be able to see \"([^\"]*)\" on select page$")
    public void userShouldBeAbleToSeeOnSelectPage(String day) throws Throwable {
        assertThat("Display message is not correct", simpleSelectPage.getMessage(),
                containsString(day));
    }
}