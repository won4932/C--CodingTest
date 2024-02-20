package com.prac.cote.class2;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Back2751_quick_fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] q = new int[N];

        for(int i = 0; i < N; i++) {
            q[i] = Integer.parseInt(br.readLine());
        }

        l_pivoting(q, 0, N-1);

        for (int i : q) {
            System.out.println(i);
        }

    }

    private static void l_pivoting(int[] q, int left, int right) {
        if(left >= right) return;

        int pivot = partition(q, left, right);

        l_pivoting(q, left, pivot -1);
        l_pivoting(q, pivot +1, right);
    }

    public static int partition(int[] q, int l, int r) {
        int left = l;
        int right = r;
        int pivot = q[l];

        while(left < right) {

            while(q[right] > pivot && left < right) {
                right--;
            };

            while(q[left] <= pivot && left < right) {
                left++;
            }

            swap(q, left, right);
        }

        swap(q, l, left);

        return left;
    }

    private static void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }
}