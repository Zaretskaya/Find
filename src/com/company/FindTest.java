package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FindTest {
    private Finder finder = new Finder();

    @Test
    void testNonRecursiveWithoutDir() throws Exception {
        final String[] args = {"find", "test.txt"};
        assertEquals(finder.find(args).size(), 1);
    }

    @Test
    void testRecursiveWithoutDir() throws Exception {
        final String[] args = {"find", "-r", "test.txt"};
        assertEquals(finder.find(args).size(), 2);
    }

    @Test
    void testRecursiveWithDir() throws Exception {
        final String[] args = {"find", "-r", "-d", "testdir", "test.txt"};
        assertEquals(finder.find(args).size(), 1);
    }

    @Test
    void testNonRecursiveWithDir() throws Exception {
        final String[] args = {"find", "-d", "testdir", "test.txt"};
        assertEquals(finder.find(args).size(), 1);
    }
}