package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;

public class PersonalCabinetPage {
    @FindBy(how= How.LINK_TEXT,using="Профиль")
    private SelenideElement profile;
    @FindBy(how= How.LINK_TEXT,using="Конструктор")
    private SelenideElement constructor;
    @FindBy(how= How.CLASS_NAME,using="AppHeader_header__logo__2D0X2")
    private SelenideElement logo;
    @FindBy(how= How.XPATH,using="//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button")
    private SelenideElement logout;
    @Step ("check profile text")
    public   void checkProfileText(){
        profile.shouldHave(exactText("Профиль"));
    }
    @Step("click constructor")
    public void clickConstructor(){
        constructor.click();
    }
    @Step("click logo")
    public void clickLogo(){
        logo.click();
    }
    @Step("click logout")
    public void clickLogout(){
        logout.click();
    }
}