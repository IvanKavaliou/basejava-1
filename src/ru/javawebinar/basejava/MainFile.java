package ru.javawebinar.basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * gkislin
 * 21.07.2016
 */
public class MainFile {
    public static void main(String[] args) {
        String filePath = "C:\\Projects\\basejava-1\\src";

        File file = new File(filePath);

        print(file);

    }

    public static void print(File file){
        System.out.println("##"+file.getName());
        for (File f:file.listFiles()){
            if (!f.isDirectory()){
                System.out.println("--"+ f.getName());
            } else {
                print(new File(f.getAbsolutePath()));
            }
        }
    }
}
