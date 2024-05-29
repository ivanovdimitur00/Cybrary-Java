package com.project.cybrary.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    private String author;
    
    private String publisher;
    
    private LocalDate year;
    
    private String ISBN;
    
    private String resume;
    
    private Double price;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getYear() {
        return year;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getResume() {
        return resume;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
