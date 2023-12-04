package com.prac.cote.class1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class Back1157_stream_fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String alpa = br.readLine().toUpperCase();

        Map<String, Long> sortedAlphabetCount = Arrays
                .stream(alpa.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
                ));
        int index = 0;
        long max = -1;
        String result = null;

        for(Map.Entry<String, Long> entry : sortedAlphabetCount.entrySet()) {
            if(index==0) {
                max = entry.getValue();
                result = entry.getKey();
                index++;
            }else {
                if(max == entry.getValue()) {
                    System.out.println("?");
                    return;
                }else {
                    System.out.println(result);
                    return;
                }
            }
        }

    }
}