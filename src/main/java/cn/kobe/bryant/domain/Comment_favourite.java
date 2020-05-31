package cn.kobe.bryant.domain;

public class Comment_favourite {
    public int getComment_id() {
        return comment_id;
    }

    @Override
    public String toString() {
        return "Comment_favourite{" +
                "comment_id=" + comment_id +
                ", user_id=" + user_id +
                '}';
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private int comment_id;
    private int user_id;

}
