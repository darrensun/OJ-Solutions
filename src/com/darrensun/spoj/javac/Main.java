package com.darrensun.spoj.javac;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 1163 - Java vs C ++
 * Created by Darren on 14-7-18.
 */
public class Main {
    public final static String ERROR = "Error!";
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        String identifier;
        while ((identifier = in.readLine()) != null)
            convertIdentifier(identifier);
        out.flush();
    }

    /**
     * Conver an identifier from one language to another
     * @param identifier The given identifier
     */
    void convertIdentifier(String identifier) {
        // Special handling of the first character
        char firstLetter = identifier.charAt(0);
        if (firstLetter >= 'A' && firstLetter <= 'Z' || firstLetter == '_') {
            out.println(ERROR);
            return;
        }

        StringBuilder converted = new StringBuilder();
        int status = 0; // 0: unknown; 1: C++; 2: Java
        boolean underscore = false; // Last character is an underscore
        int i;
        for (i = 0; i < identifier.length(); i++) {
            char c = identifier.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (underscore) { // Converted to uppercase if the last character is an underscore
                    c = (char)(c-32);
                    underscore = false;
                }
                converted.append(c);
            } else if (c == '_') {
                if (status == 2 || underscore) { // No underscore for Java, or double underscores
                    underscore = false;
                    out.println(ERROR);
                    break;
                }
                status = 1;
                underscore = true;
            } else if (c >= 'A' && c <= 'Z') {
                if (status == 1) {      // No uppercase character for C++
                    underscore = false;
                    out.println(ERROR);
                    break;
                }
                status = 2;
                converted.append('_');
                converted.append((char)(c+32));
            }
        }
        if (underscore)     // Trailing underscore
            out.println(ERROR);
        else if (i == identifier.length())  // No error occurs
            out.println(converted.toString());
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
