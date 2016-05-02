package com.company;

/**
 * Created by jamesonstone on 5/1/16.
 */

import java.util.Scanner;
import java.io.*;

public class FileIn {
    String fname;
    String hashTable[];
    int tabLen;
    int numSmashes;

    public FileIn(int hashTableLen) {
        int j;
        tabLen = hashTableLen;
        numSmashes = 0;
        hashTable = new String[tabLen];

        for (j = 0; j < tabLen; j++) {
            hashTable[j] = "#";
        }

        getFileName();
        readFileContents();
        showHashTable();
    }

    public void readFileContents() {
        boolean looping = true;
        DataInputStream in;
        String line;
        int len, hashIndex, hInc, spot;

        try {
            in = new DataInputStream(new FileInputStream(fname));

            while (looping) {
                if (null == (line = in.readLine())) {
                    looping = false;
                    in.close();
                } else {
                    System.out.println(line);
                    hashIndex = hashFun(line);
                    hashTable[hashIndex] = fname;
                }
            }
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    public void showHashTable() {
        int c;

        for (int j = 0; j < tabLen; j++) {
            System.out.println(hashTable[j]);

        }

        System.out.println("Number of Hash Clashes = ");
    }

    public int hashFun(String name) {
        //use prime for more unique values
//        int hashVal = 7;
//
//        for(int i = 0; i < name.length(); i++) {
//            hashVal = hashVal * 31 + name.charAt(i);
//        }

        return name.length();
    }

    public void getFileName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file name please.");
        fname = in.nextLine();
        System.out.println("You entered " + fname);
    }
}
