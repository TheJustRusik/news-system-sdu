package com.example.newssystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LogRegWorker {
    public void createFolder(){
        File folder = new File(".files");
        if(folder.mkdir()){
            System.out.println("Folder created!\n");
        }else{
            System.out.println("Folder already exist...\n");
        }

        File file = new File("file.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public void checkData() throws FileNotFoundException {
        try {
            RandomAccessFile raf = new RandomAccessFile(".files/file.txt", "r");
        } catch (FileNotFoundException e){

        } catch (IOException e){

        }
    }
}
