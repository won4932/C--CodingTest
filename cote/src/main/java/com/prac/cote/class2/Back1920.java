package com.prac.cote.class2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back1920 {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1920.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] list = new int[N];

        int[] result = new int[N];


        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
//            list.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(list);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());
            int mid = (list.length/2);

            if(a >= list[mid]) {
                for(int j = mid; j < list.length; j++) {
                    if(list[j] == a) {
                        result[i] = 1;
                        break;
                    }

                }
            }else {
                for(int j = mid-1; j >=0; j--) {
                    if(list[j]==a) {
                        result[i] = 1;
                        break;
                    }
                }
            }


        }

        for (int i1 : result) {
            System.out.println(i1);
        }
    }
}