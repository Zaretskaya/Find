package com.company;

import java.io.*;
import java.util.*;

public class Find {

    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    private static String function(String path, String find, boolean r){
        File f = new File (path);
        String[] list = f.list();
        for (String file: list) {
            if (file.equals(find)){
                return path+file+ " file found";
            }
            else {
                File t = new File (file);
                if (t.isDirectory() && r) {
                   String newPath = path+"\\"+file;
                   function(newPath, find, r);
                }
            }
        }
        return "not found";
    }

    public static void main(String[] args) {
        String commandLine = in.nextLine();
        String[] list = commandLine.split(" ");            //find [-r] [-d directory] filename.txt

        String fileName = list[list.length - 1];
        boolean r = false;
        String d = "C:\\Users\\Acer\\IdeaProjects\\Find";

        for (int i = 1; i < list.length; i++) {
            if (list[i].equals("-r"))
                r = true;
            if (list[i].equals("-d"))
                d = list[i+1];
        }

        out.print(function(d, fileName, r));

    }
}