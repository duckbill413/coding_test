package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3289 서로소 집합 (메모리: 104840KB, 시간: 775ms)
public class SWEA3289 {
    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            for (int i = 0; i < N + 1; i++) {
                parent[i] = i;
            }

            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int o = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (o == 0) {
                    if (isSameParent(a, b) == 0) { // 같은 부모가 아니라면
                        unionParent(a, b);
                    }
                } else if (o == 1) {
                    int answer = isSameParent(a, b);
                    sb.append(answer);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a != b)
            parent[a] = b;
    }

    private static int isSameParent(int a, int b) {
        if (findParent(a) == findParent(b)) return 1;
        else return 0;
    }
}
