package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Timus 1723 - Sandro's Book
 * Created by Darren on 14-7-10.
 * If a spell is the most powerful, each of its characters as a subspell is also the most
 * powerful, since the number of appearances of each character is no less than the superspell as
 * a whole. As any of the most powerful spells is acceptable, we just need to find a character
 * with the most number of appearances.
 */
public class Q1723 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String universalSpell = in.readLine();
            Map<Character, Integer> stat = new HashMap<Character, Integer>();

            // Count the number of appearances of each character
            for (int i = 0; i < universalSpell.length(); i++) {
                char spell = universalSpell.charAt(i);
                if (stat.containsKey(spell))
                    stat.put(spell, stat.get(spell)+1);
                else
                    stat.put(spell, 1);
            }

            // Find the character with the most number of appearances
            char mostPowerfulSpell = 0;
            int mostFrequency = 0;
            for (Map.Entry<Character, Integer> entry : stat.entrySet()) {
                if (entry.getValue() > mostFrequency) {
                    mostFrequency = entry.getValue();
                    mostPowerfulSpell = entry.getKey();
                }
            }

            System.out.println(mostPowerfulSpell);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
