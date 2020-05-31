package cn.kobe.bryant.domain;

/**
 * 书评回复
 */
public class BookCommentReply {
    private int id;
    private String username;
    private String reply_content;
    private String time;
    private int comment_id;
    private String user_image;
    private int good;

    @Override
    public String toString() {
        return "BookCommentReply{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", reply_content='" + reply_content + '\'' +
                ", time='" + time + '\'' +
                ", comment_id=" + comment_id +
                ", user_image='" + user_image + '\'' +
                ", good=" + good +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }
}
