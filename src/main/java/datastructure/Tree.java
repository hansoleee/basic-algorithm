package datastructure;

import java.util.Scanner;

public class Tree {

    static final int MAX_CHILD_NUM = 2;

    static class TreeNode {
        int parent;
        int[] child = new int[MAX_CHILD_NUM];

        public TreeNode(int parent) {
            this.parent = parent;
            for (int i = 0; i < MAX_CHILD_NUM; i++) {
                child[i] = -1;
            }
        }
    }

    TreeNode[] treeNode;
    int nodeNum;

    public Tree(int nodeNum) {
        this.nodeNum = nodeNum;
        treeNode = new TreeNode[nodeNum + 1];
        for (int i = 0; i <= nodeNum; i++) {
            treeNode[i] = new TreeNode(-1);
        }
    }

    public void addChild(int parent, int child) {
        int found = -1;
        for (int i = 0; i < MAX_CHILD_NUM; i++) {
            if (treeNode[parent].child[i] == -1) {
                found = i;
                break;
            }
        }
        if (found == -1) return;

        treeNode[parent].child[found] = child;
        treeNode[child].parent = parent;
    }

    public int getRoot() {
        for (int i = 1; i < nodeNum; i++) {
            if (treeNode[i].parent == -1) {
                return i;
            }
        }
        return -1;
    }

    public void preOrder(int root) {
        System.out.printf("%d ", root);

        for (int i = 0; i < MAX_CHILD_NUM; i++) {
            int child = treeNode[root].child[i];
            if (child != -1) {
                preOrder(child);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            int node = sc.nextInt();
            int edge = sc.nextInt();

            Tree tree = new Tree(node);

            for (int i = 0; i < edge; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                tree.addChild(parent, child);
            }
            int root = tree.getRoot();
            System.out.printf("#%d ", test_case);
            tree.preOrder(root);
            System.out.println();
        }

        sc.close();
    }
}

