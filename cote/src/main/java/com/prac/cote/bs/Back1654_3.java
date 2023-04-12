package com.prac.cote.bs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back1654_3 {
    static int get[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        get = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++) {
            get[i] = Integer.parseInt(br.readLine());
            sum += get[i];
        }
        Arrays.sort(get);
        long left = 1;
        long right = get[N-1];
        while(left<=right) {
            long mid = (left+right)/2;
            long ans = 0;
            for(int i : get) {
                ans+= i/mid;
            }
            if(K>ans) {
                right = mid -1;
            }
            else if(K<=ans){
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}
