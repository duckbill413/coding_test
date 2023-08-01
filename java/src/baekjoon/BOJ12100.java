package baekjoon;

import java.io.*;
import java.util.stream.Stream;

public class BOJ12100 {
	private static int N;
	private static int[][] board;
	private static int answer;

	public static void moveLeft(int[][] array) {
		for (int i = 0; i < N; i++) {
			int index = 0;
			int size = 0;
			for (int j = 0; j < N; j++) {
				if (array[i][j] != 0) {
					if (array[i][j] == size) {
						array[i][index - 1] = size * 2;
						size = 0;
						array[i][j] = 0;
					} else {
						size = array[i][j];
						array[i][j] = 0;
						array[i][index++] = size;
					}
				}
			}
		}
	}

	public static void moveRight(int[][] array) {
		for (int i = 0; i < N; i++) {
			int index = N-1;
			int size = 0;
			for (int j = N - 1; j >= 0; j--) {
				if (array[i][j] != 0) {
					if (array[i][j] == size) {
						array[i][index + 1] = size * 2;
						size = 0;
						array[i][j] = 0;
					} else {
						size = array[i][j];
						array[i][j] = 0;
						array[i][index--] = size;
					}
				}
			}
		}
	}

	public static void moveUp(int[][] array) {
		for (int j = 0; j < N; j++) {
			int index = 0;
			int size = 0;
			for (int i = 0; i < N; i++) {
				if (array[i][j] != 0) {
					if (array[i][j] == size) {
						array[index -1][j] = size * 2;
						size = 0;
						array[i][j] = 0;
					} else {
						size = array[i][j];
						array[i][j] = 0;
						array[index++][j] = size;
					}
				}
			}
		}
	}

	public static void moveDown(int[][] array) {
		for (int j = 0; j < N; j++) {
			int index = N-1;
			int size = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (array[i][j] != 0) {
					if (array[i][j] == size) {
						array[index+1][j] = size * 2;
						size = 0;
						array[i][j] = 0;
					} else {
						size = array[i][j];
						array[i][j] = 0;
						array[index--][j] = size;
					}
				}
			}
		}
	}

	public static int[][] copyedBoard(int[][] array) {
		int[][] copyedArray = new int[N][];
		for (int i = 0; i < N; i++) {
			copyedArray[i] = array[i].clone();
		}
		return copyedArray;
	}

	public static void dfs(int count, int[][] array) {
		if (count == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (answer < array[i][j]) {
						answer = array[i][j];
					}
				}
			}
			return;
		}
		int[][] left = copyedBoard(array);
		moveLeft(left);
		dfs(count + 1, left);
		int[][] right = copyedBoard(array);
		moveRight(right);
		dfs(count + 1, right);
		int[][] up = copyedBoard(array);
		moveUp(up);
		dfs(count + 1, up);
		int[][] down = copyedBoard(array);
		moveDown(down);
		dfs(count + 1, down);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][];
		for (int i = 0; i < N; i++) {
			board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		answer = 0;

		dfs(0, board);
		System.out.println(answer);
	}
}
