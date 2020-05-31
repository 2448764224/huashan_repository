package cn.kobe.bryant.domain;

public class User {
    private String user_photo;
    private String birthday;
    private String username;
    private String telephone;
    private String qq;
    private String email;
    private String sex;
    private int id;
    private String password;

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }


    @Override
    public String toString() {
        return "User{" +
                "user_photo='" + user_photo + '\'' +
                ", birthday='" + birthday + '\'' +
                ", username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    public String  getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
