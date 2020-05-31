package cn.kobe.bryant.domain;

public class NewWorld {
    private  String topic;
    private  String user_photo;
    private  String username;
    private  String read_experience;
    private  String time;
    private  String book_name;
    private  String author;
    private  int use_id;

    public int getUse_id() {
        return use_id;
    }

    public void setUse_id(int use_id) {
        this.use_id = use_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRead_experience() {
        return read_experience;
    }

    public void setRead_experience(String read_experience) {
        this.read_experience = read_experience;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NewWorld{" +
                "topic='" + topic + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", username='" + username + '\'' +
                ", read_experience='" + read_experience + '\'' +
                ", time='" + time + '\'' +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", user_id=" + use_id +
                '}';
    }
}
