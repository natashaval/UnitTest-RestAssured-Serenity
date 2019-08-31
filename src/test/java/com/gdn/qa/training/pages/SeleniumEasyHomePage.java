package com.gdn.qa.training.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://www.seleniumeasy.com/test/")
public class SeleniumEasyHomePage extends PageObject {

//  @FindBy(xpath = "//a[@id='btn_basic_example']")
//  jika xPath diambil dari chroPath relativePath yang atas
    @FindBy(id = "btn_basic_example")
    private WebElementFacade startPractisingButton;

//    @FindBy(className = "list-group-item:nth-of-type(1)")
    @FindBy(xpath = "//a[@class='list-group-item']")
//    lebih sering pakai xPath; jika class nya lebih dari satu bisa dimasukkan ke list
    private List<WebElementFacade> listMenu;

    public void click_start(){
        startPractisingButton.click();
    }

    public void clickMenuList(String menu){ // jika ingin click menu di salah satu list
        // harus dalam bentuk list yang ketemu di @FindBy sehingga bisa di-stream
        WebElementFacade menuListButton = listMenu.stream().filter(webElementFacade ->
            webElementFacade.getText().equalsIgnoreCase(menu))
                .findFirst().get();
        evaluateJavascript("arguments[0].scrollIntoView(true)", menuListButton);
        // ini jadi kaya ke scroll kebawah; ada beberapa testcase kalau tidak ke scroll ke element nya maka Error
        menuListButton.click();
    }
}
