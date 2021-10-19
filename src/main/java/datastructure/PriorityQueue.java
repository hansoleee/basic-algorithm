package datastructure;

import java.io.*;
import java.util.StringTokenizer;

public class PriorityQueue {
    public static final int MAX_N = 100;
    public static int heapSize = 0;
    public static int[] heap = new int[MAX_N];

    public static void heapInit() {
        heapSize = 0;
    }

    public static void heapPush(int value) {
        if (heapSize >= MAX_N) {
            return;
        }

        heap[heapSize] = value;
        int index = heapSize;

        while (index > 0) {
            if (heap[index] < heap[(index - 1) / 2]) {
                int temp = heap[index];
                heap[index] = heap[(index - 1) / 2];
                heap[(index - 1) / 2] = temp;
            } else {
                break;
            }
            index = (index - 1) / 2;
        }
        heapSize++;
    }

    public static int heapPop() {
        if (heapSize <= 0) {
            return -1;
        }

        int result = heap[0];
        heapSize--;
        heap[0] = heap[heapSize];
        int index = 0;

        while (true) {
            int min;
            if (heap[(index * 2) + 1] < heap[(index * 2) + 2]) {
                min = (index * 2) + 1;
            } else {
                min = (index * 2) + 2;
            }

            if (min >= heapSize || heap[min] >= heap[index]) {
                break;
            }

            int temp = heap[min];
            heap[min] = heap[index];
            heap[index] = temp;

            index = min;
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

            heapInit();
            for (int i = 0; i < N; i++) {
                heapPush(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < N; i++) {
                bw.write(heapPop() + " ");
            }
            bw.write("\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }
}