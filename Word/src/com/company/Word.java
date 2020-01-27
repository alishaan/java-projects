package com.company;

public class Word {

    //Private Data
    private String myWord;

    //Constructors
    public Word(){
        myWord = "";
    }

    public Word(String word){
        myWord = word;
    }

    //Methods
    public void append(String toAppend){
        myWord += toAppend;
    }

    public boolean isVowel(String character){
        if (character.equals("a")
                || character.equals("e")
                || character.equals("i")
                || character.equals("o")
                || character.equals("u")
                || character.equals("y")){
            return true;
        }else{
            return false;
        }
    }

    //toString
    public String toString(){
        return myWord;
    }

    //Setters and Getters
    public String getMyWord() {
        return myWord;
    }

    public void setMyWord(String myWord) {
        this.myWord = myWord;
    }
}
