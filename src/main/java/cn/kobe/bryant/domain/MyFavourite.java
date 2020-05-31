package cn.kobe.bryant.domain;

public class MyFavourite {
    @Override
    public String toString() {
        return "MyFavourite{" +
                "user_id=" + user_id +
                ", book_name='" + book_name + '\'' +
                ", book_id='" + book_id + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    private int user_id;
    private String book_name;
    private String book_id;

}
