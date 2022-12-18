package page;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;

public class LoginPage {
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/h2")
    private SelenideElement enterText;
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement emailFiledLogin;
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/label")
    private SelenideElement emailNoActFiledLogin;
    @FindBy(how = How.NAME,using = "Пароль")
    private SelenideElement passwordFiledLogin;
    @FindBy(how=How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/button")
    private SelenideElement comeInButton;
    @Step("login")
    public void login(String email,String password){
        emailNoActFiledLogin.click();
        emailFiledLogin.shouldBe(enabled).click();
        emailFiledLogin.setValue(email);
        passwordFiledLogin.shouldBe(enabled).click();
        passwordFiledLogin.setValue(password);
        comeInButton.click();
    }
    @Step("check logout")
    public   void checkLogout(){
        enterText.shouldHave(exactText("Вход"));
    }
}