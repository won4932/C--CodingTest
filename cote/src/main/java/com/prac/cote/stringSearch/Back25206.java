package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back25206 {
    static String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
    static Double[] subjectRating = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        var majorRating = new HashMap<String, Double>();

        for(int i = 0; i < grades.length; i++) {
            majorRating.put(grades[i], subjectRating[i]);
        }

        double sumUnit = 0.0;
        double sum = 0.0;

        for(int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String subjectName = st.nextToken();

            double unit = Double.parseDouble(st.nextToken());

            String grade = st.nextToken();

            if(grade.equals("P")) continue;

            sumUnit+= unit;

            sum += (unit * majorRating.get(grade));
        }

        System.out.println(String.format("%.6f", sum / sumUnit));
    }

}