package com.company;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> booksList = new ArrayList<Book>();
    ArrayList<Patron> patronList = new ArrayList<Patron>();

    public Library(){
        patronList.add(new Patron());
    }
    public Library(Patron patronPass){
        patronList.add(patronPass);
    }
    public void addPatron(Patron patronPass){
        patronList.add(patronPass);
    }
    public void removePatron(Patron patronPass){
        patronList.remove(patronPass);
    }
    public void addBook(Book bookPass){
        booksList.add(bookPass);
    }
    public void removeBook(Book bookPass){
        booksList.remove(bookPass);
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<Book> booksList) {
        this.booksList = booksList;
    }

    public ArrayList<Patron> getPatronList() {
        return patronList;
    }

    public void setPatronList(ArrayList<Patron> patronList) {
        this.patronList = patronList;
    }

    @Override
    public String toString() {
        String returnString = "";
        returnString += "Patrons: " + System.lineSeparator();
        if (booksList.size() > 0){
            for (int i = 0; i < patronList.size(); i++){
                returnString += patronList.get(i).toString() + System.lineSeparator();
            }
        }else{
            return "No patrons present.";
        }
        returnString += "Books: " + System.lineSeparator();
        if (booksList.size() > 0){
            for (int i = 0; i < booksList.size(); i++){
                returnString += booksList.get(i).toString() + System.lineSeparator();
            }
        }else{
            return "No books present.";
        }
        return returnString;
    }
}
