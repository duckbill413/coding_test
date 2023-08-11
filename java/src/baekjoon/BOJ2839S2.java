package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2839 설탕 배달 (메모리: 11480kb, 시간: 72ms)
public class BOJ2839S2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int bag = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                bag += N / 5;
                System.out.println(bag);
                return;
            }
            N -= 3;
            bag++;
        }
        System.out.println(-1);
    }
}
