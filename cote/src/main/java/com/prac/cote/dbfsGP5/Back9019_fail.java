package com.prac.cote.dbfsGP5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class Back9019_fail {
    static int T;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        BiFunction<String, String, String> dslr = (command, number) -> switch (command) {
            case "D" -> String.valueOf(pasringInt(number).multiply(new BigInteger("2")).remainder(new BigInteger("10000")));
            case "S" -> {
                BigInteger s = pasringInt(number);

                s = s.subtract(BigInteger.valueOf(1L));

                yield Objects.equals(s, new BigInteger("0")) ? "9999" : s.toString();
            }
            case "L" -> {
                Deque<Character> deque = new ArrayDeque<>();

                for(int i = 1; i < number.length(); i++) {
                    deque.addLast(number.charAt(i));
                }

                deque.addLast(number.charAt(0));

                StringBuilder result = new StringBuilder();

                while(!deque.isEmpty()) {
                    result.append(deque.pollFirst());
                }

                yield result.toString();
            }
        case "R" -> {
            Deque<Character> deque = new ArrayDeque<>();

            deque.addFirst(number.charAt(number.length()-1));

            for(int i = 0; i < number.length()-1; i++) {
                deque.addFirst(number.charAt(i));
            }

            StringBuilder result = new StringBuilder();

            while(!deque.isEmpty()) {
                result.append(deque.pollLast());
            }

            yield result.toString();
            }
            default -> null;
        };

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(a, ""));

            String answer = null;

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if(Objects.equals(pasringInt(node.number), pasringInt(b))) {
                    if(answer == null) answer = node.command;
                    else {
                        if(answer.length() > node.command.length()) answer = node.command;
                    }
                    break;
                }

                queue.add(new Node(dslr.apply("D", node.number), node.command.concat("D")));
                queue.add(new Node(dslr.apply("S", node.number), node.command.concat("S")));
                queue.add(new Node(dslr.apply("L", node.number), node.command.concat("L")));
                queue.add(new Node(dslr.apply("R", node.number), node.command.concat("R")));
            }

            System.out.println(answer);
        }

    }

    private static BigInteger pasringInt(String s) {
        BigInteger answer = new BigInteger("0");
        for(int i = 0; i < s.length(); i++){
            answer = answer.add(new BigInteger(String.valueOf(s.charAt(i))));

            answer = answer.multiply(new BigInteger("10"));
        }

        return answer.divide(new BigInteger("10"));
    }

    public static class Node {
        String number;
        String command;

        Node(String number, String command) {
            this.number = number;
            this.command = command;
        }
    }
}