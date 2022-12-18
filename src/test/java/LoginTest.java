import page.*;
import user.FakerUser;
import user.UserClient;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import user.User;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
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
    }

    @Test
    @DisplayName("check login button on the main page")
    public void checkLoginButtonOnTheMainPage (){
        url="https://stellarburgers.nomoreparties.site/";
        MainPage mainPage = open(url, MainPage.class);
        mainPage.clickSingInButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(fakerUser.getEmail(), fakerUser.getPassword());
        mainPage.checkLogin();

    }

    @Test
    @DisplayName("check login button personal cabinet")
    public void checkLoginButtonPersonalCabinet(){
        url="https://stellarburgers.nomoreparties.site/";
        MainPage mainPage = open(url, MainPage.class);
        mainPage.clickPersonalCabinetButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(fakerUser.getEmail(), fakerUser.getPassword());
        mainPage.checkLogin();

    }

    @Test
    @DisplayName("check login button on the registration page")
    public void checkLoginButtonOnTheRegistrationPage(){
        url ="https://stellarburgers.nomoreparties.site/register";
        RegistrationPage registrationPage = open(url, RegistrationPage.class);
        registrationPage.clickInButtonSingIn();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(fakerUser.getEmail(), fakerUser.getPassword());
        MainPage mainPage = page(MainPage.class);
        mainPage.checkLogin();

    }

    @Test
    @DisplayName("check login button sing in on the password reset page")
    public void checkLoginButtonSingInOnThePasswordResetPage(){
        url="https://stellarburgers.nomoreparties.site/forgot-password";
        PasswordResetPage passwordResetPage = open(url,PasswordResetPage.class);
        passwordResetPage.clickButtonSingIn();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(fakerUser.getEmail(), fakerUser.getPassword());
        MainPage mainPage = page(MainPage.class);
        mainPage.checkLogin();
    }

    @After
    public void end (){
        webdriver().driver().close();
        userClient.delete(accessToken);
    }
}