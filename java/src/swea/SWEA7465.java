package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA7465 {
    public static int[] parent;

    public static int findParent(int root) {
        if (parent[root] == root) {
            return root;
        } else {
            parent[root] = findParent(parent[root]);
            return parent[root];
        }
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a > b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N, M;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N + 1];
            for (int n = 0; n < N + 1; n++) {
                parent[n] = n;
            }
            for (int m = 0; m < M; m++) {
                int a, b;
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                unionParent(a, b);
            }
            ;
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!result.contains(findParent(i))) {
                    result.add(findParent(i));
                }
            }
            System.out.printf("#%d %d\n", test_case, result.size());
        }
    }

}