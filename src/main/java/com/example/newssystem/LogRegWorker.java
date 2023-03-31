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

        File file = new File(".files/file.txt");
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

    public boolean checkData(String data, char dataType) throws IOException {
        RandomAccessFile file = new RandomAccessFile(".files/file.txt", "r");
        file.seek(0);
        String line;
        while ((line = file.readLine()) != null){
            if(dataType == 'l' && line.startsWith("login: ")){
                if(("login: " + data).equals(line))
                    return true;
            }else if(dataType == 'p' && line.startsWith("password: ")){
                if(("password: " + data).equals(line))
                    return true;
            }else if(dataType == 'e' && line.startsWith("email: ")){
                if(("email: " + data).equals(line))
                    return true;
            }
        }


        return false;
    }

    public boolean checkPassword(String login, String password) throws IOException {
        RandomAccessFile file = new RandomAccessFile(".files/file.txt", "r");
        file.seek(0);
        String buff;
        while ((buff = file.readLine()) != null){
            if(buff.equals("login: " + login)){
                buff = file.readLine();
                if(buff.equals("password: " + password)){
                    return true;
                }else{
                    return false;
                }
            }
        }

        return false;
    }
    public void addData(String login, String email, String password) throws IOException {
        RandomAccessFile file = new RandomAccessFile(".files/file.txt", "rw");
        file.seek(file.length());
        file.writeBytes("login: " + login + "\n");
        file.writeBytes("password: " + password + "\n");
        file.writeBytes("email: " + email + "\n");
        file.writeBytes("\n");

    }
}
