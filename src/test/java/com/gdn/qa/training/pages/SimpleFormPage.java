package com.gdn.qa.training.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-first-form-demo.html")
public class SimpleFormPage extends PageObject {
    @FindBy(id = "user-message")
    private WebElementFacade enterMessageInput;

    @FindBy(xpath = "//button[contains(text(),'Show Message')]")
    private WebElementFacade showMessageButton;

    @FindBy(xpath = "//span[@id='display']")
    private WebElementFacade textMessageDisplay;

    public boolean isFieldInputMessageDisplayed(){
        return enterMessageInput.waitUntilVisible()
                .isDisplayed();
    }

    public void enterMessage(String text){
        enterMessageInput.type(text);
    }

    public void showMessageButtonClick(){
        showMessageButton.waitUntilClickable().click();
    }

    public String isMessageDisplayed(){
        return textMessageDisplay.getText();
    }
}
