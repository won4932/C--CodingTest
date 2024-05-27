package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Back5635 {
    static Pattern pattern = Pattern.compile("(\\D+) (\\d+) (\\d+) (\\d+)");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        var infos = new ArrayList<Infomation>();

        for(int i = 0; i < n; i++) {
            String info = br.readLine();
            Matcher matcher = pattern.matcher(info);

            if(matcher.matches()) {
                infos.add(new Infomation(matcher.group(1)
                    , Integer.parseInt(matcher.group(2))
                    , Integer.parseInt(matcher.group(3))
                    , Integer.parseInt(matcher.group(4))));
            }
        }

        Collections.sort(infos, new Comparator<Infomation>() {
            @Override
            public int compare(Infomation o1, Infomation o2) {
                if(o1.year == o2.year) {
                    if(o1.month == o2.month) {
                        return Integer.compare(o1.day, o2.day);
                    }else {
                        return Integer.compare(o1.month, o2.month);
                    }
                }else {
                    return Integer.compare(o1.year, o2.year);
                }
            }
        });

        System.out.println(infos.get(infos.size() - 1).name);
        System.out.println(infos.get(0).name);

    }

    private static class Infomation {
        String name;
        int day;
        int month;
        int year;

        private Infomation(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}