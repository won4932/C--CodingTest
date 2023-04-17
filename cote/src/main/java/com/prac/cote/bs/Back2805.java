package com.prac.cote.bs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back2805 {
    static int get[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        get = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            get[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(get);
        long left = 1;
        long right = get[N-1];
        while(left<=right) {
            long mid = (left+right)/2;
            long len = division(mid);

            if(len<M) {
                right = mid -1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
    private static long division(long n) {
        long ans = 0;
        for(int i : get) {
            if(i>n) ans+= i-n;
        }
        return ans;
    }
}
