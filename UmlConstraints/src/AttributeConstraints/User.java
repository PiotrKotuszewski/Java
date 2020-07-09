package AttributeConstraints;

import Exceptions.WrongFormatException;

public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username.trim().length() < 3)
            throw new WrongFormatException("Nazwa uzytkownika musi posiadac conajmniej 3 znaki");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(!password.matches("[A-Za-z0-9 ]*"))
            throw new WrongFormatException("Haslo moze zawierac jedynie cyfry i liczby");
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
