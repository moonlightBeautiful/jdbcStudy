package com.java1234.c03prestatement.model;


public class Book {

    private int id;
    private String bookName;
    private float price;
    private String author;
    private int bookTypeId;


    public Book(int id, String bookName, float price, String author,
                int bookTypeId) {
        super();
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.bookTypeId = bookTypeId;
    }

    public Book(String bookName, float price, String author, int bookTypeId) {
        super();
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.bookTypeId = bookTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }


}
