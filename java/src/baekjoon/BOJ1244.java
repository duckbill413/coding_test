package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class BOJ1244 {
	private static int N;
	private static int M;
	private static int[] switches;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		switches = new int[N + 1];
		switches[0] = 0;
		for (int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// 남자
			if (A == 1) {
				for (int i = B; i <= N; i += B) {
					switches[i] = switches[i] == 0 ? 1 : 0;
				}
			} else if (A == 2) { // 여자
				switches[B] = switches[B] == 0 ? 1 : 0;
				int flap = 1;
				while (B - flap > 0 && B + flap <= N) {
					if (switches[B - flap] == switches[B + flap]) {
						switches[B - flap] = switches[B - flap] == 0 ? 1 : 0;
						switches[B + flap] = switches[B + flap] == 0 ? 1 : 0;
					} else {
						break;
					}
					flap++;
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(switches[i] + " ");
			if (i % 20 == 0) {
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
}
