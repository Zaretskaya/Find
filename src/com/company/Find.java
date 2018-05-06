package com.company;

import java.io.*;
import java.util.*;

public class Find {

    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static String action() throws Exception{
        Logic logic = new Logic();
        String commandLine = in.nextLine();
        String[] list = commandLine.split(" ");            //find [-r] [-d directory] filename.txt

        String fileName = list[list.length - 1];
        boolean r = false;
        String d = "Find";

        for (int i = 1; i < list.length; i++) {
            if (list[i].equals("-r"))
                r = true;
            if (list[i].equals("-d"))
                d = list[i+1];
        }

        return (logic.function(d, fileName, r));

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
        String d = "C:/Users/Acer/IdeaProjects/Find";

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