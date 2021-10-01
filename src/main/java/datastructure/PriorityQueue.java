package datastructure;

import java.io.*;
import java.util.StringTokenizer;

public class PriorityQueue {
    public static final int MAX_N = 100;

    public static int[] heap = new int[MAX_N];
    public static int heapSize = 0;

    public static void heapInit() {
        heapSize = 0;
    }

    public static void heapPush(int value) {
        if (heapSize >= MAX_N) {
            System.out.println("Heap overflow");
            return;
        }

        heap[heapSize] = value;

        int current = heapSize;
        while (current > 0 && heap[current] < heap[(current - 1) / 2]) {
            int temp = heap[(current - 1) / 2];
            heap[(current - 1) / 2] = heap[current];
            heap[current] = temp;
            current = (current - 1) / 2;
        }
        heapSize += 1;
    }

    public static int heapPop() {
        if (heapSize <= 0) {
            return -1;
        }

        //1순위 반환
        int result = heap[0];
        int i = 0;

        heapSize -= 1;
        heap[0] = heap[heapSize];

        while (i < heapSize) {
            int minChild;
            if (heap[(i * 2) + 1] < heap[(i * 2) + 2]) {
                minChild = (i * 2) + 1;
            } else {
                minChild = (i * 2) + 2;
            }

            if (minChild >= heapSize || heap[minChild] >= heap[i]) {
                break;
            }

            int temp = heap[i];
            heap[i] = heap[minChild];
            heap[minChild] = temp;

            i = minChild;
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
                final int input = Integer.parseInt(st.nextToken());
                heapPush(input);
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
