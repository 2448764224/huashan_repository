package cn.kobe.bryant.domain;

import java.util.Date;

public class Movie {
    private String movie_id;
    private String director;
    private String actor;
    private String movie_type;
    private int movie_length;
    private String introduce;
    private int visit;
    private int collect;
    public String getMovie_id() {
        return movie_id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id='" + movie_id + '\'' +
                ", director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                ", movie_type='" + movie_type + '\'' +
                ", movie_length=" + movie_length +
                ", introduce='" + introduce + '\'' +
                ", visit=" + visit +
                ", collect=" + collect +
                ", release_date='" + release_date + '\'' +
                ", movie_imgae='" + movie_imgae + '\'' +
                ", movie_name='" + movie_name + '\'' +
                ", movie_grade=" + movie_grade +
                ", region='" + region + '\'' +
                '}';
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(String movie_type) {
        this.movie_type = movie_type;
    }

    public int getMovie_length() {
        return movie_length;
    }

    public void setMovie_length(int movie_length) {
        this.movie_length = movie_length;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getMovie_imgae() {
        return movie_imgae;
    }

    public void setMovie_imgae(String movie_imgae) {
        this.movie_imgae = movie_imgae;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getMovie_grade() {
        return movie_grade;
    }

    public void setMovie_grade(int movie_grade) {
        this.movie_grade = movie_grade;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    private String release_date;
    private String movie_imgae;
    private String movie_name;
    private int movie_grade;
    private String region;
}
