package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Finder {
    private List<String> result = new ArrayList<>();

    List<String> find(String[] args) throws Exception {
        //find [-r] [-d directory] filename.txt
        String fileName = args[args.length - 1];
        boolean r = false;
        String d = "./";

        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("-r")) {
                r = true;
            }
            if (args[i].equals("-d")) {
                d = args[i + 1];
            }
        }

        return searchDirectory(new File(d), fileName, r);
    }

    private List<String> searchDirectory(File directory, String fileNameToSearch, boolean r) {
        if (directory.isDirectory()) {
            search(directory, fileNameToSearch, r);
        } else {
            System.out.println(directory.getAbsoluteFile() + " is not a directory!");
        }
        return result;
    }


    private void search(File file, String fileNameToSearch, boolean r) {
        if (file.isDirectory()) {
            System.out.println("Searching directory ... " + file.getAbsoluteFile());
            for (File temp : Objects.requireNonNull(file.listFiles())) {
                if (temp.isDirectory()) {
                    if (r) {
                        search(temp, fileNameToSearch, r);
                    }
                } else if (fileNameToSearch.equals(temp.getName().toLowerCase())) {
                    result.add(temp.getAbsoluteFile().toString());
                }
            }
        }
    }
}
