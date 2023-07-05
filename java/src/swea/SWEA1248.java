package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1248 {
    private static Node[] nodes;

    public static void findParent(int parent, int depth) {
        nodes[parent].depth = depth;
        if (nodes[parent].leftIdx != 0) {
            nodes[nodes[parent].leftIdx].parentIdx = parent;
            findParent(nodes[parent].leftIdx, depth + 1);
        }
        if (nodes[parent].rightIdx != 0) {
            nodes[nodes[parent].rightIdx].parentIdx = parent;
            findParent(nodes[parent].rightIdx, depth + 1);
        }
    }

    public static int findDepth(int parent) {
        int count = 1;
        if (nodes[parent].leftIdx != 0) {
            count += findDepth(nodes[parent].leftIdx);
        }
        if (nodes[parent].rightIdx != 0) {
            count += findDepth(nodes[parent].rightIdx);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int V, E, A, B;
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            nodes = new Node[V + 1];
            for (int i = 1; i <= V; i++) {
                nodes[i] = new Node(i);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                if (nodes[parent].leftIdx == 0)
                    nodes[parent].leftIdx = child;
                else
                    nodes[parent].rightIdx = child;
                nodes[parent].parentIdx = parent;
            }
            findParent(1, 0);
            while (A != B) {
                if (nodes[A].depth > nodes[B].depth) {
                    A = nodes[A].parentIdx;
                } else if (nodes[A].depth < nodes[B].depth) {
                    B = nodes[B].parentIdx;
                } else {
                    A = nodes[A].parentIdx;
                    B = nodes[B].parentIdx;
                }
            }
            int size = findDepth(A);
            System.out.printf("#%d %d %d\n", test_case, A, size);
        }
    }

    public static class Node {
        int data;
        int parentIdx, leftIdx, rightIdx;
        int depth;

        Node(int data) {
            this.data = data;
            this.parentIdx = 0;
            this.leftIdx = 0;
            this.rightIdx = 0;
            this.depth = 0;
        }
    }
}