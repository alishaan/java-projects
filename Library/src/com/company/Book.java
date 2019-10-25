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
}
