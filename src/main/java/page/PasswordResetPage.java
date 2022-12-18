package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordResetPage {
    @FindBy(how= How.LINK_TEXT,using ="Войти")
    private SelenideElement buttonSingIn;
    @Step("click button sing in")
    public void clickButtonSingIn(){
        buttonSingIn.click();
    }
}