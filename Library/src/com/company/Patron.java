package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Patron {
    private String firstName;
    private String lastName;
    private static int idNum = 0;
    private ArrayList<Book> books;
    private LocalDateTime joinDate;

    //Default Patron Constructor
    public Patron(){
        firstName = "John";
        lastName = "Smith";
        idNum += 1;
        joinDate = LocalDateTime.now();
        books = new ArrayList<Book>();
    }

    //Fill Patron Constructor
    public Patron(String firstNamePass, String lastNamePass){
        firstName = firstNamePass;
        lastName = lastNamePass;
        idNum += 1;
        joinDate = LocalDateTime.now();
        books = new ArrayList<Book>();
    }

    //Method to check out book
    public void checkOutBook(Book passedBook){
        passedBook.checkOut();
        books.add(passedBook);
    }

    //Method to return book
    public void returnBook(Book passedBook){
        passedBook.returnBook();
        books.remove(passedBook);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static int getIdNum() {
        return idNum;
    }

    public static void setIdNum(int idNum) {
        Patron.idNum = idNum;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        String returnString = "";
        returnString += firstName + " " + lastName + " joined " + joinDate.toString() + System.lineSeparator();
        returnString += "Books Check Out: " + System.lineSeparator();
        if (books.size() > 0){
            for (int i = 0; i < books.size(); i++){
                returnString += books.get(i).toString() + System.lineSeparator();
            }
        }else{
            return "No books checked out.";
        }
        return returnString;
    }
}