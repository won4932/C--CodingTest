package com.prac.cote.stringSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Back1764 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        var duddo = new ArrayList<String>();
        var duddoMap = new HashMap<String, Integer>();
        var dudbo = new ArrayList<String>();

        for(int i = 0; i < N; i++) {
            String duddoo = br.readLine();
            int duddooHash = duddoo.hashCode();
            duddoMap.put(duddoo, i);
            // duddo.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String bodo = br.readLine();
            if(duddo.contains(bodo)) {
                dudbo.add(bodo);
            }
        }

        Collections.sort(dudbo);

        System.out.println(dudbo.size());

        for (String s : dudbo) {
            System.out.println(s);
        }


    }
}