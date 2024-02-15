package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@SpringBootApplication
public class Back1759 {

    static int L, C;
    static char[] alpa;
    static char[] code;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        code = new char[L];
        alpa = new char[C];

        alpa = br.readLine().toCharArray();

        Arrays.sort(alpa);

        factorial(0, 0);
    }

    public static void factorial(int x, int index) {
        if(index == L) {
            if(isValid()) {
                System.out.println(code);
            }
            return;
        }

        for(int i = x; i < C; i++) {
            code[index] = alpa[i];
            factorial(i+1, index+1);
        }
    }

    public static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}