package org.example.UserInfo;

public class UserInfo {

    private String name;
    private String password;
    private String email;

    public UserInfo(){}

    public UserInfo(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
