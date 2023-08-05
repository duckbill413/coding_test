package baekjoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14890 경사로
public class BOJ14890 {
    private static int N;
    private static int L;
    private static int[][] stairsRow;
    private static int[][] stairsCol;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        stairsRow = new int[N][N];
        stairsCol = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stairsRow[i][j] = Integer.parseInt(st.nextToken());
                stairsCol[j][i] = stairsRow[i][j];
            }
        }
        int answer = 0;
        // 가로 길 탐색
        for (int i = 0; i < N; i++) {
            boolean[] slope = new boolean[N];
            if (check(stairsRow[i], slope)) {
                answer += 1;
            }
        }
        // 세로 길 탐색
        for (int i = 0; i < N; i++) {
            boolean[] slope = new boolean[N];
            if (check(stairsCol[i], slope)) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean check(int[] line, boolean[] slope) {
        for (int i = 1; i < N; i++) {
            // 현재와 이전 과의 차이가 1보다 큰 경우
            if (Math.abs(line[i] - line[i - 1]) > 1) {
                return false;
            }
            // 왼쪽 보다 현재가 더 큰 경우 => 현재 포함 X 왼쪽 탐색
            if (line[i] > line[i - 1]) {
                for (int l = 1; l <= L; l++) {
                    /* 
                    탈출 조건
                    1. 범위를 벗어 난다.
                    2. 높이가 중간에 바뀐다.
                    3. 이미 경사로가 설치된 경우를 탐색한 경우
                     */
                    if (i - l < 0 || line[i - 1] != line[i - l] || slope[i - l]) {
                        return false;
                    } else {
                        slope[i - l] = true;
                    }
                }
            }

            // 왼쪽 보다 현재가 더 작은 경우 => 현재 포함 오른쪽 탐색
            if (line[i] < line[i - 1]) {
                for (int l = 0; l < L; l++) {
                    if (i + l >= N || line[i] != line[i + l] || slope[i + l]) {
                        return false;
                    } else {
                        slope[i + l] = true;
                    }
                }
            }
        }
        return true;
    }
}
