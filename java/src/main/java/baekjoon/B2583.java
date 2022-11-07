package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class B2583 {
    public static int count = 0;
    public static int [] dx = {-1, 1, 0, 0};
    public static int [] dy = {0, 0, -1, 1};
    public static int m, n, k;

    public static void dfs(int x, int y, int[][] area){
        area[x][y] = -1;
        count += 1;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            if (area[nx][ny] == 1)
                dfs(nx, ny, area);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int [][] area = new int[m][n];
        for (int i=0; i<m; i++){
            Arrays.fill(area[i], 1);
        }

        for (int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int [] point = new int[4];
            for (int j=0; j<4; j++){
                point[j] = Integer.parseInt(st.nextToken());
            }

            for (int c = point[0]; c < point[2]; c++){
                for (int r = point[1]; r< point[3]; r++){
                    area[r][c] = 0;
                }
            }
        }

        Vector<Integer> answer = new Vector<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (area[i][j] == 1){
                    dfs(i, j, area);
                    answer.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        System.out.println(answer.size());
        for (int i=0; i<answer.size(); i++){
            sb.append(answer.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
