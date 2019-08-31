package com.gdn.qa.training.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.blibli.com/verify-phone-number/?step=1")
public class BlibliVerifyNumberPage extends PageObject {
    @FindBy(xpath = "//h1[@class='phoneVerification__form-header']")
    private WebElementFacade verifikasiTitle;

    @FindBy(xpath = "//div[@class='phoneVerification__country-code']")
    private WebElementFacade countryCodeText;

    @FindBy(xpath = "//input[@id='gdn-pnv-field']")
    private WebElementFacade phoneInput;

    @FindBy(xpath = "//a[@id='gdn-pnv-later']")
    private WebElementFacade verifikasiNantiLink;

    public boolean isDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        Boolean isTitle = verifikasiTitle.waitUntilVisible().isDisplayed();
        Boolean isCountryCodeText = countryCodeText.waitUntilVisible().isDisplayed();
        Boolean isPhoneInput = phoneInput.waitUntilVisible().isDisplayed();
        return isTitle && isCountryCodeText && isPhoneInput;
    }

    public void click_verifikasi_nanti() {
        verifikasiNantiLink.click();
    }

    public void modal_show_click_lanjutkan(){
        find(By.xpath("//a[@class='modal-buttons__continue button modal-continue-button']"))
                .waitUntilVisible().click();
    }
}
