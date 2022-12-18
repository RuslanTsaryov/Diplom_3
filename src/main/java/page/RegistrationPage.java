package page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    @FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement mailField;

    @FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/input[1]")
    private SelenideElement passwordField;
    //ошибка ввода пароля при нажатии на кнопку регистрации

    //заголовок Регистрация
    @FindBy(how = How.XPATH,using = "//h2[contains(text(),'Регистрация')]")
    private SelenideElement registerHeader;
    //кнопка Зарегистрироваться
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/button")
    private SelenideElement regButton;

    //кнопка Войти
    @FindBy(how = How.XPATH,using = "//*[contains(@class, 'Auth_link')][contains(text(), 'Войти')]")
    private SelenideElement inRegButton;
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p")
    private SelenideElement errorPassword;
    @FindBy(how=How.LINK_TEXT,using = "Войти")
    private SelenideElement  buttonSignIn;
    @Step("register user")
    public void registerUser (String userName,String userEmail,String userPassword){
        nameField.click();
        nameField.setValue(userName);
        mailField.click();
        mailField.setValue(userEmail);
        passwordField.click();
        passwordField.setValue(userPassword);
        inRegButton.scrollIntoView(false);
        regButton.click();
    }
    @Step( "check error")
    public void checkErr() {
        errorPassword.shouldHave(Condition.exactText("Некорректный пароль"));
    }
    @Step("check header")
    public void checkHeader() {
        registerHeader.shouldHave(Condition.exactText("Регистрация"));
    }
    @Step("click in button")
    public void clickInButton() {
        inRegButton.shouldBe(Condition.exist).click();
    }
    @Step("click in button sing in")
    public void clickInButtonSingIn(){
        buttonSignIn.click();
    }

}