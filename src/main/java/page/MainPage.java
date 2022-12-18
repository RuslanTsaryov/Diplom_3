package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class MainPage {
    @FindBy(how=How.XPATH,using = "//*[@id=\"root\"]/div/main/section[2]/div/button")
    private SelenideElement order;
    @FindBy(how=How.XPATH,using = "//*[@id=\"root\"]/div/main/section[2]/div/button")
    private SelenideElement singInButton;
    @FindBy(how=How.LINK_TEXT,using="Личный Кабинет")
    private SelenideElement personalCabinetButton;
    @FindBy(how=How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/h1")
    private SelenideElement header;
    @FindBy(how=How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]")
    private SelenideElement bunButton;
    @FindBy(how=How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]")
    private SelenideElement souseButton;
    @FindBy(how=How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]")
    private SelenideElement fillingButton;
    @Step ("check login")
    public void checkLogin(){
        order.shouldHave(exactText("Оформить заказ"));
    }
    @Step("click sing in button")
    public void clickSingInButton(){
        singInButton.click();
    }
    @Step("click personal cabinet button")
    public void clickPersonalCabinetButton(){
        personalCabinetButton.click();
    }
    @Step("check constructor")
    public void checkConstructor(){
        header.shouldHave(exactText("Соберите бургер"));
    }
    @Step(" check buns")
    public void checkBuns (){
        souseButton.click();
        bunButton.click();
        bunButton.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }
    @Step (" check souse")
    public void checkSouse(){
        souseButton.click();
        souseButton.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }
    @Step("check filling")
    public void checkFilling(){
        fillingButton.click();
        fillingButton.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }
}