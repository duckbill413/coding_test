package swea;

import java.util.Scanner;

// 2058 자리수 더하기
public class SWEA2058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int result = 0;
        while (N > 0){
            result += N % 10;
            N /= 10;
        }
        System.out.println(result);
    }
}
