package com.prac.cote.corporation;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back11401 {

//    static int N, K;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long numer = factorial(N);

        // 분모 (K! * (N-K)!) mod p
        long denom = factorial(K) * factorial(N - K) % 1000000007;


        // N! * 분모의 역((K! * (N-K)!)
        System.out.println(numer * pow(denom, 1000000007 - 2) % 1000000007);

    }

    public static long factorial(long N) {
        long fac = 1L;

        while(N > 1) {
            fac = (fac * N) % 1000000007;
            N--;
        }
        return fac;
    }

    // base : 밑 / expo : 지수
    // 거듭 제곱 <- 분할 정복 방식
    public static long pow(long base, long expo) {
        if(expo == 1) {
            return base % 1000000007;
        }

        long temp = pow(base, expo / 2);

        if(expo % 2 == 1) {
            return (temp * temp % 1000000007) * base % 1000000007;
        }
        return temp * temp % 1000000007;

    }
}