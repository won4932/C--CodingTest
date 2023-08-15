package com.prac.cote.dp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back1005 {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1005.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] seq = new int[n+1][];

            int[] building = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int index = 0;
            String multi = "";

            String[] subSeq = new String[k+1];

            for(int a = 0; a < k; a++) {
                StringTokenizer st2 = new StringTokenizer(reader.readLine());

                String start = st2.nextToken();
                int end = Integer.parseInt(st2.nextToken());

                subSeq[end] += start + " ";
            }

            subSeq[index] = multi;

            for(int c = 2; c < subSeq.length; c++) {
                seq[c] = Arrays.stream(subSeq[c].split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

//            for(int c = 0; c < subSeq.size(); c++) {
//                seq.add(Arrays.stream(subSeq.get(c).split(" "))
//                        .mapToInt(Integer::parseInt)
//                        .toArray());
//            }

            int w = Integer.parseInt(reader.readLine());

            int[] time = new int[n+1];
            time[1] = building[0];

            for(int b = 2; b < w + 1; b++) {
                if(seq[b].length < 2) {
                    time[b] = time[seq[b][0]] + building[b-1];
                } else {
                    int max = Integer.MIN_VALUE;
                    for (int s : seq[b]) {
                        max = Math.max(max, time[s]);
                    }

                    time[b] = max + building[b-1];
                }
                System.out.println(b + " : " + time[b]);
            }
            System.out.println(time[w]);
        }
    }
}
