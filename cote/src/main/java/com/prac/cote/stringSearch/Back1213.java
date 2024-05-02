package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1213 {
    static HashMap<Character, Integer> map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        String imHansu = br.readLine();

        var set = new HashSet<Character>();
        map = new HashMap<>();

        int imHansuKey = imHansu.length();

        for(int i = 0; i < imHansu.length(); i ++) {
            char now = imHansu.charAt(i);
            set.add(now);

            map.put(now, map.getOrDefault(now, 0) +1);
        }

        var list = new ArrayList<Character>(set);

        Collections.sort(list);

        if(imHansuKey % 2 == 0) {
            for (Character c : list) {
                if(notEven(c)) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }else {
                    addRepeat(c, map.get(c) / 2);
                }
            }
            String reverse = sb.reverse().toString();
            sb.reverse().append(reverse);
        }else {
            int ck = 0;
            char middle = 0;

            for (Character c : list) {
                if(notEven(c)) {
                    ck++;
                    middle = c;
                }
                addRepeat(c, map.get(c) / 2);
            }

            if(ck != 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }

            String reverse = sb.reverse().toString();
            sb.reverse().append(middle).append(reverse);
        }

        System.out.println(sb.toString());

    }

    public static boolean notEven(char ch) {
        return map.get(ch) % 2 != 0;
    }

    public static void addRepeat(char ch, int repeat) {
        for(int i = 0; i < repeat; i++) {
            sb.append(ch);
        }
    }
}