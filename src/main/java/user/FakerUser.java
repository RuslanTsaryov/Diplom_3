package user;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class FakerUser {
    static Faker fakerUser = new Faker(new Locale("en_EN"));
    private String email;
    private String password;
    private String name;

    public FakerUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;

    }

    public static FakerUser getRandom(int charPass) {
        final String email = fakerUser.internet().emailAddress();
        final String password = RandomStringUtils.randomAlphabetic(charPass);
        final String name = fakerUser.name().firstName();
        return new FakerUser(email, password, name);

    }

    public String getEmail() {
        return email;
    }

    public FakerUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public FakerUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public FakerUser setName(String name) {
        this.name = name;
        return this;
    }
}