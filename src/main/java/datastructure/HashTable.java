package datastructure;

import java.util.Scanner;

public class HashTable {
    static class Hash {
        String key;
        String data;
    }

    int capacity;
    Hash[] tb;

    public HashTable(int capacity) {
        this.capacity = capacity;
        tb = new Hash[capacity];
        for (int i = 0; i < capacity; i++) {
            tb[i] = new Hash();
        }
    }

    private int hash(String str) {
        int hash = 5381;

        for (int i = 0; i < str.length(); i++) {
            int c = (int) str.charAt(i);
            hash = ((hash << 5) + hash) + c;
        }
        if (hash < 0) hash *= -1;
        return hash % capacity;
    }

    public String find(String key) {
        int h = hash(key);
        int cnt = capacity;
        while (tb[h].key != null && (--cnt) != 0) {
            if (tb[h].key.equals(key)) {
                return tb[h].data;
            }
            h = (h + 1) % capacity;
        }
        return null;
    }

    void add(String key, String data) {
        int h = hash(key);
        while (tb[h].key != null) {
            if (tb[h].key.equals(key)) {
                return;
            }
            h = (h + 1) % capacity;
        }
        tb[h].key = key;
        tb[h].data = data;
    }
}

class Solution {
    final static int MAX_TABLE = 4096;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            HashTable tb = new HashTable(MAX_TABLE);
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                String k = sc.next();
                String d = sc.next();
                tb.add(k, d);
            }
            System.out.printf("#%d\n", test_case);
            int Q = sc.nextInt();
            for (int i = 0; i < Q; i++) {
                String k = sc.next();
                String d = tb.find(k);
                if (d != null) {
                    System.out.printf("%s\n", d);
                } else {
                    System.out.print("not find\n");
                }
            }
        }
        sc.close();
    }
}