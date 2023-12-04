package com.prac.cote.class1;

import com.prac.cote.dbfs.Back1012;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SpringBootApplication
public class Class1Test {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Class1Test.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();

        if(str.equals(" ")) {
            System.out.println(0);
        }else {
            System.out.println(str.trim().split(" ").length);
        }


    }
}
