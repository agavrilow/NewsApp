package com.example.android.newsapp;

public class News {

    private String topic, title, date, url, author;

    public News(String topic, String title, String date, String url, String author) {
        this.topic = topic;
        this.title = title;
        this.date = date;
        this.url = url;
        this.author = author;
    }

    public News(String topic, String title, String date, String url) {
        this.topic = topic;
        this.title = title;
        this.date = date;
        this.url = url;
    }

    public String getTopic() {
        return topic;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }
}

