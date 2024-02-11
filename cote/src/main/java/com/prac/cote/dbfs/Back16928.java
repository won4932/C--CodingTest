package com.prac.cote.dbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back16928 {
    static int ladder, snake;
    static Map<Integer, Integer> ladderInfo;
    static Map<Integer, Integer> snakeInfo;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        ladder = Integer.parseInt(st.nextToken());
        snake = Integer.parseInt(st.nextToken());

        visited = new boolean[101];

        ladderInfo = new HashMap<>();
        snakeInfo = new HashMap<>();

        for(int i = 0 ; i < ladder ; i++) {
            st = new StringTokenizer(br.readLine());
            ladderInfo.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0 ; i < snake ; i++) {
            st = new StringTokenizer(br.readLine());
            snakeInfo.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(bfs(1));


    }

    public static int bfs(int idx) {
        Queue<Dice> queue = new LinkedList<>();
        queue.add(new Dice(idx, 0));
        visited[idx] = true;

        int min = 100;

        while(!queue.isEmpty()) {
            Dice dice = queue.poll();

            for(int i = 1; i <= 6; i++) {
                int nx = dice.now + i;

                if(nx > 100) break;
                else if(nx < 100 && !visited[nx]) {
                    visited[nx] = true;
                    if(ladderInfo.containsKey(nx)) {
                        nx = ladderInfo.get(nx);
                    }else if(snakeInfo.containsKey(nx)) {
                        nx = snakeInfo.get(nx);
                    }
                    visited[nx] = true;
                    queue.add(new Dice(nx, dice.count+1));
                }

                if(nx == 100)  min = Math.min(min, dice.count+1);

            }
        }

        return min;

    }

    public static class Dice {
        int now;
        int count;
        public Dice(int now, int count) {
            this.now = now;
            this.count = count;
        }
    }
}