package com.prac.cote.stringSearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back25206 {
    static int N;
    static int M;

    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        var S = new String[N];

        int count = 0;

        for(int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();

            for(int j = 0; j < N; j++) {
                if(S[j].length() != str.length()) continue;

                if(S[j].charAt(0) == str.charAt(0)) {
                    if(S[j].charAt(S[j].length()-1) == str.charAt(str.length()-1)) {
                        boolean flag = true;
                        for(int a = str.length()-1; a >= 0; a--) {
                            if(S[j].charAt(a) != str.charAt(a)) {
                                flag = false;
                                break;
                            }
                        }

                        if(flag) {
                            count++;
                            break;
                        }

//                        if(S[j].equals(str)) {
//                            count++;
//                            break;
//                        }
                    }
                }
//                stringMatching(S[j], str);
            }
        }

        System.out.println(count);
    }

//    public static void stringMatching(String S, String check) {
//
//        for(int i = 0; i < S.length()-1; i++) {
//            if(S.charAt(i) == check.charAt(0)) {
//                if(S.charAt(S.length()-1) == check.charAt(check.length()-1)) {
//
//                }
//            }
//        }
//
//        if(S.contains(check.charAt(0) + "")) {
//           if(S.contains(check.charAt(check.length()-1) + "")) {
//
//           }
//        }
//
//
//    }
}