package com.company;

import java.util.Scanner;

public class LibraryTester {

    public static void main(String[] args) {
        //String input for commands
        Library mainLibrary = new Library();
        int restart = 0;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter /books to check all books or /account or /library to manage the library to check your current information or enter 'exit' to exit: ");
            String textPass = input.nextLine();
            if (textPass.equals("exit")){
                restart = 1;
            }
            else if (textPass.equals("/library")) {
                System.out.println("Enter /addbook to add a book or /delbook to delete a book or /patrons: ");
                textPass = input.nextLine();
                if (textPass.equals("/addbook")){
                    System.out.println("Enter the author: ");
                    String author = input.nextLine();
                    System.out.println("Enter the book title: ");
                    String title = input.nextLine();
                    //create new book and add it to library
                    mainLibrary.addBook(new Book(title, author));
                }else if (textPass.equals("/delbook")){
                    System.out.println("Enter the author: ");
                    String author = input.nextLine();
                    System.out.println("Enter the book title: ");
                    String title = input.nextLine();
                    //find book in array and delete it
                    for (int i = 0; i < mainLibrary.getBooksList().size(); i++){
                        if(mainLibrary.getBooksList().get(i).getAuthor().equals(author) && mainLibrary.getBooksList().get(i).getTitle().equals(title)){
                            mainLibrary.getBooksList().remove(i);
                        }
                    }
                }else if (textPass.equals("/patrons")){
                    for (int i = 0; i < mainLibrary.getPatronList().size(); i++){
                        System.out.println(mainLibrary.getPatronList().get(i).toString());
                    }
                }
            }else if(textPass.equals("/books")){
                System.out.println("Enter 'available' for all available books or 'all' for all books: ");
                textPass = input.nextLine();
                if(textPass.equals("available")){
                    for (int i = 0; i < mainLibrary.getBooksList().size(); i++){
                        if (mainLibrary.getBooksList().get(i).isCheckedOut() == false){
                            System.out.println(mainLibrary.getBooksList().get(i).toString() + System.lineSeparator());
                        }
                    }
                }else if (textPass.equals("all")){
                    for (int i = 0; i < mainLibrary.getBooksList().size(); i++){
                        System.out.println(mainLibrary.getBooksList().get(i).toString());
                    }
                }
            }else if (textPass.equals("/account")){
                System.out.println("Enter 'create' to create an account or 'access' to access your account: ");
                textPass = input.nextLine();
                if (textPass.equals("create")){
                    System.out.println("Enter your first name: ");
                    String firstName = input.nextLine();
                    System.out.println("Enter your last name: ");
                    String lastName = input.nextLine();
                    mainLibrary.addPatron(new Patron(firstName, lastName));
                }else if (textPass.equals("access")){
                    System.out.println("Enter 'checkout' to checkout a book, 'return' to return a book or 'info' to view your info: ");
                    textPass = input.nextLine();
                    if (textPass.equals("checkout")){
                        System.out.println("Enter the author: ");
                        String author = input.nextLine();
                        System.out.println("Enter the book title: ");
                        String title = input.nextLine();
                        //find book in array and delete it
                        System.out.println("Enter your first name and last name: ");
                        String accountInfo = input.nextLine();
                        for (int i = 0; i < mainLibrary.getPatronList().size(); i++){
                            if ((mainLibrary.getPatronList().get(i).getFirstName() + " " + mainLibrary.getPatronList().get(i).getLastName()).equals(accountInfo)){
                                Patron selectedPatron = mainLibrary.getPatronList().get(i);
                                for (int j = 0; j < mainLibrary.getBooksList().size(); j++){
                                    if(mainLibrary.getBooksList().get(j).getAuthor().equals(author) && mainLibrary.getBooksList().get(j).getTitle().equals(title)){
                                        selectedPatron.checkOutBook(mainLibrary.getBooksList().get(j));
                                    }
                                }
                            }
                        }
                    }else if (textPass.equals("return")){
                        System.out.println("Enter the author: ");
                        String author = input.nextLine();
                        System.out.println("Enter the book title: ");
                        String title = input.nextLine();
                        //find book in array and delete it
                        System.out.println("Enter your first name and last name: ");
                        String accountInfo = input.nextLine();
                        for (int i = 0; i < mainLibrary.getPatronList().size(); i++){
                            if ((mainLibrary.getPatronList().get(i).getFirstName() + " " + mainLibrary.getPatronList().get(i).getLastName()).equals(accountInfo)){
                                Patron selectedPatron = mainLibrary.getPatronList().get(i);
                                for (int j = 0; j < selectedPatron.getBooks().size(); j++){
                                    if(selectedPatron.getBooks().get(j).getAuthor().equals(author) && selectedPatron.getBooks().get(j).getTitle().equals(title)){
                                        selectedPatron.returnBook(selectedPatron.getBooks().get(j));
                                    }
                                }
                            }
                        }
                    }else if (textPass.equals("info")){
                        System.out.println("Enter your first name and last name: ");
                        String accountInfo = input.nextLine();
                        for (int i = 0; i < mainLibrary.getPatronList().size(); i++) {
                            if ((mainLibrary.getPatronList().get(i).getFirstName() + " " + mainLibrary.getPatronList().get(i).getLastName()).equals(accountInfo)) {
                                Patron selectedPatron = mainLibrary.getPatronList().get(i);
                                System.out.println(selectedPatron.toString());
                                System.out.println("Enter book title to check if you have it borrowed: ");
                                String bookTitle = input.nextLine();
                                System.out.println(mainLibrary.getPatronList().get(i).hasBorrowed(bookTitle));
                            }
                        }
                    }
                }
            }
        }while(restart == 0);
    }
}
