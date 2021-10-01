package datastructure;

import java.io.*;
import java.util.StringTokenizer;

public class Queue {
    public static final int MAX_N = 100;
    public static final int[] queue = new int[MAX_N];
    public static int front;
    public static int rear;

    public static void queueInit() {
        front =  0;
        rear = 0;
    }

    public static boolean queueIsEmpty() {
        return (front == rear);
    }

    public static boolean queueIsFull() {
        return ((rear + 1) % MAX_N == front);
    }

    public static void queueEnqueue(int value) {
        if (queueIsFull()) {
            System.out.println("Queue overflow");
            return;
        }
        queue[rear] = value;
        rear++;

        if ((rear + 1) == MAX_N) {
            rear = 0;
        }
    }

    public static Integer queueDequeue() {
        if (queueIsEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }

        int result = queue[front];
        front++;

        if (front == MAX_N) {
            front = 0;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            final int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            queueInit();
            for (int i = 0; i < N; i++) {
                queueEnqueue(Integer.parseInt(st.nextToken()));
            }

            while (!queueIsEmpty()) {
                bw.write(queueDequeue() + " ");
            }
            bw.write("\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }
}
