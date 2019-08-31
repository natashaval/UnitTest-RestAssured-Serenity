package com.gdn.qa.training.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.blibli.com")
public class BlibliHomePage extends PageObject {
    @FindBy(id = "gdn-daftar")
    private WebElementFacade daftarButton;

    public void click_daftar(){
        daftarButton.click();
    }

    public boolean show_daftar_modal(){
        Boolean isInputEmailDisplayed = find(By.className("input--email")).waitUntilVisible().isDisplayed();
        Boolean isInputPasswordDisplayed = find(By.className("input--password")).waitUntilVisible().isDisplayed();
        return isInputEmailDisplayed && isInputPasswordDisplayed;
    }

    public void type_in_input(String className, String text){
        find(By.className(className)).waitUntilVisible().type(text);
    }

    public void click_daftar_account(){
        find(By.className("button-submit")).waitUntilVisible().click();
    }

    public String check_profile_name(){
        return find(By.id("header-fullname")).waitUntilVisible().getText();
    }
}
