package com.gdn.qa.training.steps;

import com.gdn.qa.training.pages.BlibliHomePage;
import com.gdn.qa.training.pages.BlibliVerifyNumberPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BlibliRegisterSteps {

    BlibliHomePage blibliHomePage;
    BlibliVerifyNumberPage verifyNumberPage;

    @Given("^user open blibli page$")
    public void userOpenBlibliPage() {
        blibliHomePage.open();
    }

    @When("^user click Daftar Button$")
    public void userClickDaftarButton() {
        blibliHomePage.click_daftar();
    }

    @Then("^modal Daftar Akun Baru appeared$")
    public void modalDaftarAkunBaruAppeared() {
        assertThat("Inputs dalam daftar not shown!",
                blibliHomePage.show_daftar_modal(), equalTo(true));
    }

    @When("^user enter \"([^\"]*)\" on input email$")
    public void userEnterOnInputEmail(String email) throws Throwable {
        blibliHomePage.type_in_input("input--email", email);
    }

    @When("^user enter \"([^\"]*)\" on input password$")
    public void userEnterOnInputPassword(String password) throws Throwable {
        blibliHomePage.type_in_input("input--password", password);
    }

    @When("^user click Daftar account Button$")
    public void userClickDaftarAccountButton() {
        blibliHomePage.click_daftar_account();
    }

    @Then("^user redirected to verify phone number Page$")
    public void userRedirectedToVerifyPhoneNumberPage() throws InterruptedException {
        assertThat("Verifikasi phone page is not opened!",
                verifyNumberPage.isDisplayed(), equalTo(true));
    }

    @When("^user click on Verifikasi Nanti$")
    public void userClickOnVerifikasiNanti() throws InterruptedException {
        Thread.sleep(2000);
        verifyNumberPage.click_verifikasi_nanti();
        verifyNumberPage.modal_show_click_lanjutkan();
    }

    @Then("^check on user profile \"([^\"]*)\"$")
    public void checkOnUserProfile(String email) throws Throwable {
        Thread.sleep(1000);
        assertThat("Email is not matched!", blibliHomePage.check_profile_name(),
                equalTo(email));
    }
}
