package com.prac.cote.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Back1202 {
    static long result = 0;
    static int[] bag;
    static Jewelry[] jewelry;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewelry = new Jewelry[N];
        bag = new int[K];


        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken()); // M
            int p = Integer.parseInt(st.nextToken()); // K

            jewelry[i] = new Jewelry(w, p);
        }

        for(int i=0; i<K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jewelry);
        Arrays.sort(bag);


        //	for(int i=0; i<N; i++) {
        //		for(int j=0; j<2; j++) {
        //			System.out.print(jewelry[i][j] + " ");
        //		}
        //		System.out.println();
        //	}
        stil();
        System.out.println(result);
    }
    private static void stil() {
        Queue<Integer> q = new PriorityQueue<>();
        // 시간효울성을 위해 우선순위 큐 사용
        // 삽입삭제 시 O(1)시간복잡도, O(가방개수 * 보석개수) -> O(가방개수 + 보석개수)
        int index = 0;
        for(int i=0; i<K; i++) {
            while(index < N && jewelry[index].weight <= bag[i]) {
                q.offer(-jewelry[index].price);
                index++;
            }

            if(!q.isEmpty()) {
                result +=Math.abs(q.poll());
            }
        }
    }
}

class Jewelry implements Comparable<Jewelry> {
    int weight;
    int price;

    Jewelry(int weight, int price){
        this.weight = weight;
        this.price = price;
    }

    public int compareTo(Jewelry o) {
        // TODO Auto-generated method stub
        return this.weight - o.weight;
    }


}