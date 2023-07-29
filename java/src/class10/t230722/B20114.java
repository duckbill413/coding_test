package class10.t230722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] board = new char[H][];
        for (int i = 0; i < H; i++) {
            board[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        boolean find;
        for (int j = 0; j < W * N - W + 1; j += W) {
            find = false;
            for (int x = 0; x < H; x++) {
                for (int y = j; y < j + W; y++) {
                    if (board[x][y] != '?') {
                        sb.append(board[x][y]);
                        find = true;
                        break;
                    }
                }

                if (find)
                    break;
            }

            if (!find)
                sb.append('?');
        }

        System.out.println(sb);
    }
}
