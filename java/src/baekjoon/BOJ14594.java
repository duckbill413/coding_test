package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14594 동방 프로젝트 (Small)
public class BOJ14594 {
    private static int N, M;
    private static int[] rooms;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        rooms = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            rooms[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int id = rooms[A];
            for (int r = A; r <= B; r++) {
                rooms[r] = id;
            }
        }

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (i == rooms[i])
                answer++;
        }
        System.out.println(answer);
    }
}
