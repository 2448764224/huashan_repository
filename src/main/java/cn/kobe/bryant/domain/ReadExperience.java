package cn.kobe.bryant.domain;

public class ReadExperience {
    private  int id ;
    private  int use_id ;
    private  String book_name;

    public String getRead_experience() {
        return read_experience;
    }

    public void setRead_experience(String read_experience) {
        this.read_experience = read_experience;
    }

    private  String read_experience;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private  String author ;
    private  String time;
    private  String topic;

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "ReadExperience{" +
                "id=" + id +
                ", use_id=" + use_id +
                ", book_name='" + book_name + '\'' +
                ", read_experience='" + read_experience + '\'' +
                ", author='" + author + '\'' +
                ", time='" + time + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
