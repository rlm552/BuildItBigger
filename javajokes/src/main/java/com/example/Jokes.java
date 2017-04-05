package com.example;

public class Jokes {
    public Jokes(){}

    String[] jokes = new String [3];

    public String[] setJokes() {
        jokes[0] = "Q: how many programmers does it take to change a light bulb?\n" +
                "A: None that's a hardware problem.";
        jokes[1] = "Why programmers like UNIX:\n" +
                "\n" +
                "unzip, strip, touch, finger, grep, mount, fsck, more, yes, fsck, fsck, fsck, umount, sleep";
        jokes[2] = "Q: Why did the programmer quit his job?\n" +
                "A: Because he didn't get arrays.";

        return jokes;
    }
}
