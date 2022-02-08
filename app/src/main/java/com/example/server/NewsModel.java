package com.example.server;

import java.util.ArrayList;

public class NewsModel {
    String status;
    int totalResults;
    ArrayList<ArticlesModel> articles;
    public NewsModel() {
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public ArrayList<ArticlesModel> getArticles() {
        return articles;
    }
}

class ArticlesModel{
    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String publishedAt;
    String content;
    SoursModel source;

    public ArticlesModel() {
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public SoursModel getSource() {
        return source;
    }
}
class SoursModel{
    String id;
    String name;

    public SoursModel() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
