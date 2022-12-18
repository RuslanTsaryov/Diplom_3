import page.LoginPage;
import page.MainPage;
import page.PersonalCabinetPage;
import user.FakerUser;
import user.User;
import user.UserClient;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class PersonalCabinetTest {
    private String url;
    private FakerUser fakerUser;
    private UserClient userClient;
    private String accessToken;

    @Before
    public void start() {
        Configuration.browserSize = "1920x1080";
        fakerUser = FakerUser.getRandom(6);
        userClient = new UserClient();
        accessToken = userClient.createUser(fakerUser).then().extract().path("accessToken");
        url="https://stellarburgers.nomoreparties.site/";
        MainPage mainPage = open(url, MainPage.class);
        mainPage.clickPersonalCabinetButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(fakerUser.getEmail(), fakerUser.getPassword());
        mainPage.clickPersonalCabinetButton();
    }

    @Test
    @DisplayName("check link personal cabinet")
    public void checkLinkPersonalCabinet(){
        PersonalCabinetPage personalCabinetPage = page(PersonalCabinetPage.class);
        personalCabinetPage.checkProfileText();
    }

    @Test
    @DisplayName("check link personal cabinet in the constructor")
    public void checkLinkPersonalCabinetInTheConstructor(){
        PersonalCabinetPage personalCabinetPage = page(PersonalCabinetPage.class);
        personalCabinetPage.clickConstructor();
        MainPage mainPage = page( MainPage.class);
        mainPage.checkConstructor();
    }

    @Test
    @DisplayName("check link personal cabinet in the logo")
    public void checkLinkPersonalCabinetInTheLogo(){
        PersonalCabinetPage personalCabinetPage = page(PersonalCabinetPage.class);
        personalCabinetPage.clickLogo();
        MainPage mainPage = page( MainPage.class);
        mainPage.checkConstructor();
    }

    @Test
    @DisplayName("check logout")
    public void checkLogout(){
        PersonalCabinetPage personalCabinetPage = page(PersonalCabinetPage.class);
        personalCabinetPage.clickLogout();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkLogout();
    }

    @After
    public void end (){
        webdriver().driver().close();
        userClient.delete(accessToken);
    }
}