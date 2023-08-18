import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Back1005 {

    @Test
    public void test() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int t = reader.read();
//
//        for(int i = 0; i < t; i++) {
//
//            int n = reader.read();
//            int k = reader.read();
//
//            int[] building = new int[n];
//            String[][] seq = new String[n][n];
//
//            for(int j = 0; j < n; j++) {
//                building[j] = reader.read();
//            }
//
//            int index = 1;
//            String multi = "";
//            String[] subSeq = new String[n];
//
//            for(int a = 0; a < k; a++) {
//                int start = reader.read();
//                String end = reader.readLine();
//
//                if(start != index) {
//                    subSeq[index] = multi;
//                    multi = "";
//                    index = start;
//                    continue;
//                }
//
//                multi += end + " ";
//            }
//
//            for(int c = 0; c < subSeq.length; c++) {
//                seq[c] = subSeq[c].split(" ");
//            }
//
//            int w = reader.read();
//
//            int time = building[0];
//
//            for(int b = 1; b < w - 1; b++) {
//                Arrays.sort(seq[b]);
//                time += building[Integer.parseInt(seq[b][0])];
////                if(seq[b-1].length < 2) {
////                    time += building[Integer.parseInt(seq[b][0])];
////                } else {
////                    Arrays.sort(seq[b]);
////                    time += building[Integer.parseInt(seq[b][0])];
////                }
//            }
//            System.out.println(time);
//        }

    }
}
