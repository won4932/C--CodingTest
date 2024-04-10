package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back5014 {

    static int FTotal, SNow, Goal, Up, Down;

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        List<Integer> list = new ArrayList<>();

        Set<Integer> s = new HashSet<>();



        List.of(1, 2);
        st = new StringTokenizer(br.readLine());

        FTotal = Integer.parseInt(st.nextToken());
        SNow = Integer.parseInt(st.nextToken());
        Goal = Integer.parseInt(st.nextToken());
        Up = Integer.parseInt(st.nextToken());
        Down = Integer.parseInt(st.nextToken());

        visited = new int[FTotal + 1];

        int result = bfs(SNow);

        if(result == -1) System.out.println("use the stairs");
        else System.out.println(result);
    }

    public static int bfs(int now) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);

        visited[now] = 1;

        while (!queue.isEmpty()) {
            int next = queue.poll();

            int nUp = next + Up;
            int nDown = next - Down;

            if(next == Goal) return visited[next] - 1;

            if(nUp <= FTotal && visited[nUp] == 0) {
                visited[nUp] = visited[next] + 1;
                queue.add(nUp);
            }

            if(nDown > 0 && visited[nDown] == 0) {
                visited[nDown] = visited[next] + 1;
                queue.add(nDown);
            }
        }

        return -1;
    }
}