package com.company;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FindTest {

    private static void assertFileContent(String name, String expectedContent) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(name));
            String curr;
            while ((curr = br.readLine()) != null) {
                content.append(curr);
                content.append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        int length = content.length();
        if (length > 0) content.deleteCharAt(length - 1);
        assertEquals(expectedContent, content.toString());

    }





    @Test
    void main() throws Exception {
        String[] arg = {"find ", "-r ", " test.txt"};
        Find.main(arg);
        assertFileContent("output.txt", "exp.txt");
    }

}