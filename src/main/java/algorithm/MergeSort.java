package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class MergeSort {
    public static int[] array;
    public static int[] temp;

    public static void mergeSort(int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid || right <= end) {
            if (right > end || (left <= mid && (array[left] < array[right]))) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }

        for (int i = start; i <= end; i++) {
            array[i] = temp[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            final int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            temp = new int[N];
            mergeSort(0, N - 1);

            for (int i = 0; i < array.length; i++) {
                bw.write(array[i] + " ");
            }
            bw.write("\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }
}
