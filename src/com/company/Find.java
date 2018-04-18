package com.company;

import java.io.*;
import java.util.*;

public class Find {

    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;


    private static String function(String path, String find, boolean r) throws Exception {

        FileWriter fw = new FileWriter("C:\\Users\\Acer\\IdeaProjects\\Find\\output.txt");

        File f = new File (path);
        String[] list = f.list();
        for (String file: list) {
            if (file.equals(find)){
                String result = path+"\\"+file+ " file found";
                fw.write(result);
                return result;
            }
            else {
                File t = new File (file);
                if (t.isDirectory() && r) {
                   String newPath = path+"\\"+file;
                   function(newPath, find, r);
                }
            }
        }
        fw.write("not found");
        fw.close();
        return "not found";
    }


    public static String action() throws Exception{
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

        return (function(d, fileName, r));

    }

    public static void main(String[] args) throws Exception {
        String result = action();
        out.print(result);
    }



    /*public static void main(String[] args) {
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
*/

}