package com.prac.cote;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N + 1];

        // 2부터 N까지의 index를 가지는 배열의 각 index에 index값을 삽입
        for (int num = 2; num <= N; num++) {
            A[num] = num;
        }

        // 2부터 N의 제곱근까지 반복
        for (int i = 2; i <= Math.sqrt(N); i++) {
            // 요소값이 0이면 지워진 것으로 판별
            if (A[i] == 0) {
                continue;
            }

            // i의 배수를 배열에서 모두 지움
            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            }
        }

        // 최소 범위부터 시작하여, 요소가 0이 아니면 소수로 판별
        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
