package com.company;

import java.time.LocalDateTime;

public class Book {
    private String title;
    private String author;
    private LocalDateTime checkedInDate;
    private LocalDateTime checkedOutDate;
    private LocalDateTime dueDate;
    private boolean isCheckedOut;

    //Default constructor
    public Book(){
        title = "Harry Potter";
        author = "J.K. Rowling";
        checkedInDate = LocalDateTime.now();
        isCheckedOut = false;
    }

    //Fill Constructor
    public Book(String titlePass, String authorPass){
        title = titlePass;
        author = authorPass;
        checkedInDate = LocalDateTime.now();
        isCheckedOut = false;
    }

    //Method to check out the book
    public void checkOut() {
        if (isCheckedOut == false) {
            checkedOutDate = LocalDateTime.now();
            dueDate = LocalDateTime.now().plusDays(14);
            isCheckedOut = true;
        }
    }

    //Method to return book
    public void returnBook(){
        if (isCheckedOut == true){
            isCheckedOut = false;
            checkedInDate = LocalDateTime.now();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCheckedInDate() {
        return checkedInDate;
    }

    public void setCheckedInDate(LocalDateTime checkedInDate) {
        this.checkedInDate = checkedInDate;
    }

    public LocalDateTime getCheckedOutDate() {
        return checkedOutDate;
    }

    public void setCheckedOutDate(LocalDateTime checkedOutDate) {
        this.checkedOutDate = checkedOutDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    @Override
    public String toString() {
        String returnString = "";
        if(isCheckedOut == true){
            returnString+= "Title: " + title + System.lineSeparator();
            returnString+= "Author: " + author + System.lineSeparator();
            returnString+= "Due: " + dueDate.toString() + System.lineSeparator();
            returnString+= "Checked Out: " + checkedOutDate.toString() + System.lineSeparator();
            return returnString;
        }else{
            returnString+= "Title: " + title + System.lineSeparator();
            returnString+= "Author: " + author + System.lineSeparator();
            returnString+= "Checked In: " + checkedInDate.toString() + System.lineSeparator();
            return returnString;
        }
    }
}
