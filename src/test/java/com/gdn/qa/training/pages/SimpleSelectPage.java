package com.gdn.qa.training.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class SimpleSelectPage extends PageObject {
    @FindBy(xpath = "//select[@id='select-demo']")
    private WebElementFacade daySelect;

    public void selectDayByValue(String value){
        daySelect.selectByValue(value);
    }

    public boolean isSelectVisible(){
        return daySelect.waitUntilVisible().isVisible();
    }

    public String getMessage(){
        // untuk dynamic (contohnya v-if) findBy nya dengan cara manggil pakai method biasa
        // kalau pakai annotasi bisa error karena sebelumnya belum ada
        return find(By.xpath("//p[@class='selected-value']"))
                .waitUntilVisible()
                .getText();
    }
}
