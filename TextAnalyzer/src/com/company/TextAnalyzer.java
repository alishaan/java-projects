package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextAnalyzer {
    private ArrayList words;


    //Constructors
    //Default
    public TextAnalyzer(){
        words = new ArrayList();
    }
    //Fill
    public TextAnalyzer(ArrayList wordsToPass){
        words = wordsToPass;
    }
    //File
    public TextAnalyzer(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        words = new ArrayList();
        ArrayList strings = new ArrayList();
    }
}
