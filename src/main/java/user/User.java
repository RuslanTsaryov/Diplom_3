package user;

public class User{

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }
    public  static User from (FakerUser fakerUser){
        return  new User(fakerUser.getEmail(), fakerUser.getPassword());
    }
}

