package com.example.practice.RecyclerView;

public class Movie {
    // create 3 strings
    private String title, genre, date;

    // create a constructor
    public Movie(String title, String genre, String date) {
        this.title = title;
        this.genre = genre;
        this.date = date;
    }
    public Movie(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
