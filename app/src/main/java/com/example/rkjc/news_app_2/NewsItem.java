package com.example.rkjc.news_app_2;

/**
 * Created by tricialuz on 11/9/18.
 */

public class NewsItem {
    private String title;
    private String description;
    private String url;
    private String publishedAt;
    private String author;
    private String urlToImage;

    public NewsItem(String title, String description, String url, String publishedAt, String author, String urlToImage){
        this.title = title;
        this.description = description;
        this.url = url;
        this.publishedAt = publishedAt;
        this.author = author;
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getpublishedAt() {
        return publishedAt;
    }

    public void setpublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
