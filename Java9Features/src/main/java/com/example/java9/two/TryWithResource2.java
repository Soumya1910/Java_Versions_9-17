package com.example.java9.two;

import java.io.*;

public class TryWithResource2 {
    public static void main(String[] args) throws IOException {
        String file = "test.txt";
        getContentFromFile(file);
        System.out.println("--------------------------");
        getContentFromFileWithImproveVersion(file);
        System.out.println("--------------------------");
        getContentFromFileWithImproveVersion2(file);
    }

    // before Java 9
    private static void getContentFromFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try(BufferedReader reader2 = reader) { // try-with-resource after java 7
            String line;
            while((line = reader2.readLine())!= null){
                System.out.println(line);
            }
        }
    }

    private static void getContentFromFileWithImproveVersion(String file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try(br) {
            String line;
            while((line = br.readLine())!= null){
                System.out.println(line);
            }
        }
    }

    private static void getContentFromFileWithImproveVersion2(String file) throws IOException {
        // we are creating an input stream to read the file and create output stream
        // introduced in JDK 12
        new FileInputStream(file).transferTo(System.out);
    }
}
