package cn.kobe.bryant.domain;

import java.text.DateFormat;
import java.util.Date;

public class Books {
    private double grade;
    private  int book_id;

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Books{" +
                "grade=" + grade +
                ", book_id=" + book_id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", publishing_house='" + publishing_house + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", publication_year='" + publication_year + '\'' +
                ", images='" + images + '\'' +
                ", content_information='" + content_information + '\'' +
                ", author_information='" + author_information + '\'' +
                ", introduce='" + introduce + '\'' +
                ", series='" + series + '\'' +
                ", past_name='" + past_name + '\'' +
                ", translator='" + translator + '\'' +
                '}';
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    private  String author;
    private  String name;
    private  String publishing_house;
    private  String category;
    private  double price;
    private  int pages;
    private String publication_year;
    private String images;
    private String content_information;
    private String author_information;
    private String introduce;
    private String series;
    private String past_name;
    private String translator;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishing_house() {
        return publishing_house;
    }

    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getContent_information() {
        return content_information;
    }

    public void setContent_information(String content_information) {
        this.content_information = content_information;
    }

    public String getAuthor_information() {
        return author_information;
    }

    public void setAuthor_information(String author_information) {
        this.author_information = author_information;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPast_name() {
        return past_name;
    }

    public void setPast_name(String past_name) {
        this.past_name = past_name;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

}
