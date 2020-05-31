package cn.kobe.bryant.domain;
import java.util.List;

public class Comment {
    private String username;
    private String book_comment;
    private String user_image;
    private String time;
    private int user_id;
    private int good;
    private int reply_id;

    private List replys;

    public int getReply_id() {
        return reply_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "username='" + username + '\'' +
                ", book_comment='" + book_comment + '\'' +
                ", user_image='" + user_image + '\'' +
                ", time='" + time + '\'' +
                ", user_id=" + user_id +
                ", good=" + good +
                ", reply_id=" + reply_id +
                ", replys=" + replys +
                ", id=" + id +
                ", book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                '}';
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public List getReplys() {
        return replys;
    }

    public void setReplys(List replys) {
        this.replys = replys;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }



    public String getBook_comment() {
        return book_comment;
    }


    public void setBook_comment(String book_comment) {
        this.book_comment = book_comment;
    }
    private int id;
    private int book_id;
    public int getUser_id() {
        return user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    private String book_name;

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }


    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
