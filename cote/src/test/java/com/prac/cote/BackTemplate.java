package com.prac.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTemplate {

    public void main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        String t1 = st.nextToken();

        int t2 = Integer.parseInt(st.nextToken());

        String test = reader.readLine();

        String test2;

        while((test = reader.readLine()) != null) {

        }
    }
}
