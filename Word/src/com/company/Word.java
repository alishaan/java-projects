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

    private boolean leTest(){
        String c = myWord.substring(myWord.length() - 2, myWord.length());
        if ((c.equals("le") || c.equals("el"))
                &&  !isVowel(myWord.substring(myWord.length() - 3, myWord.length() - 2)))
            return true;
        return false;
    }

    public int syllables(){
        int vowel = 0;
        int score = 0;
        int eflag = 0;
        for (int i = 0; i < myWord.length(); i++)
            if (isVowel(myWord.substring(i, i + 1))){
                vowel++;
                score++;
                if (i > 0){
                    if (isVowel(myWord.substring(i-1, i))
                            &&  !myWord.substring(i-1,i).equals("y")){
                        score--;
                        vowel--;
                    }
                    if (myWord.substring(i, i + 1).equals("e")
                            &&  vowel == 2
                            &&  !isVowel(myWord.substring(i-1,i))
                            &&  isVowel(myWord.substring(i-2,i-1))
                            &&  !myWord.substring(i-2,i-1).equals("u")
                            &&  !myWord.substring(i-2,i-1).equals("y")
                    ){
                        score--;
                        eflag = 1;
                        vowel = 0;
                    }
                }
            }
        if (myWord.length() > 2)
            if (leTest() && eflag == 1){
                score++;
            }
        if (score <= 0){score = 1;}
        return score;
    }

    //toString
    public String toString(){
        return myWord + " Syllables: " + syllables();
    }

    //Setters and Getters
    public String getMyWord() {
        return myWord;
    }

    public void setMyWord(String myWord) {
        this.myWord = myWord;
    }
}
