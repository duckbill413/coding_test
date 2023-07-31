// 14499 주사위 굴리기
package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ14499 {
	private static int[][] dice;
	private static int[][] map;
	private static int[] orders;
	private static int N, M, x, y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dice = new int[4][3];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		orders = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < k; i++) {
			if (orders[i] == 1 && inRange(x, y + 1)) { // 동
				moveRight();
				y += 1;
				checkBottom(x, y);
			} else if (orders[i] == 2 && inRange(x, y - 1)) { // 서
				moveLeft();
				y -= 1;
				checkBottom(x, y);
			} else if (orders[i] == 3 && inRange(x - 1, y)) { // 북
				moveNorth();
				x -= 1;
				checkBottom(x, y);
			} else if (orders[i] == 4 && inRange(x + 1, y)) { // 남
				moveSouth();
				x += 1;
				checkBottom(x, y);
			}
		}

	}

	public static void checkBottom(int x, int y) {
		if (map[x][y] == 0) {
			map[x][y] = dice[3][1];
		} else {
			dice[3][1] = map[x][y];
			map[x][y] = 0;
		}
		System.out.println(dice[1][1]);
	}

	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < M;
	}

	private static void moveSouth() {
		int tmp = dice[3][1];
		for (int i = 3; i > 0; i--) {
			dice[i][1] = dice[i - 1][1];
		}
		dice[0][1] = tmp;
	}

	private static void moveNorth() {
		int tmp = dice[0][1];
		for (int i = 0; i < 3; i++) {
			dice[i][1] = dice[i + 1][1];
		}
		dice[3][1] = tmp;
	}

	private static void moveLeft() {
		int tmp = dice[1][0];
		for (int i = 0; i < 2; i++) {
			dice[1][i] = dice[1][i + 1];
		}
		dice[1][2] = tmp;

		tmp = dice[1][2];
		dice[1][2] = dice[3][1];
		dice[3][1] = tmp;
	}

	private static void moveRight() {
		int tmp = dice[1][2];
		for (int i = 2; i > 0; i--) {
			dice[1][i] = dice[1][i - 1];
		}
		dice[1][0] = tmp;

		tmp = dice[1][0];
		dice[1][0] = dice[3][1];
		dice[3][1] = tmp;
	}
}
