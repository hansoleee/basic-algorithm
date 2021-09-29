package datastructure;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2    //testCase
 * 5    //testCase #1 N
 * 1 2 3 4 5
 * 5    //testCase #2 N
 * 5 4 3 2 1
 */
public class Stack {
    static final int MAX_N = 100;

    static int top = 0;
    static int[] stack = new int[MAX_N];

    static void stackInit() {
        top = 0;
    }

    static boolean stackIsEmpty() {
        return top == 0;
    }

    static boolean stackIsFull() {
        return top == MAX_N;
    }

    static boolean stackPush(int value) {
        if (stackIsFull()) {
            System.out.println("stack overflow!");
            return false;
        }

        stack[top] = value;
        top = top + 1;
        return true;
    }

    static Integer stackPop() {
        if (stackIsEmpty()) {
            System.out.println("stack is empty!");
            return null;
        }

        top = top - 1;
        return stack[top];
    }

    static Integer stackPeek() {
        if (stackIsEmpty()) {
            System.out.println("stack is empty!");
            return null;
        }

        return stack[top - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            stackInit();
            for (int i = 0; i < N; i++) {
                stackPush(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < N; i++) {
                bw.write(stackPop() + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
