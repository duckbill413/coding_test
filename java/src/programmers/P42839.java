package programmers;

import java.util.HashSet;
import java.util.Set;

public class P42839 {
    private Set<Integer> nums;

    private char[] arr;
    private int[] p;
    private boolean[] visited;
    private char[] result;

    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    private void permutation(int depth, int target) {
        if (depth == target) {
            nums.add(Integer.parseInt(String.valueOf(result)));
            return;
        }

        for (int i = 0; i < p.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[p[i]];
                permutation(depth + 1, target);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        int answer = 0;

        // 숫자 저장
        arr = new char[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }
        // 인덱스 배열, visit 배열 생성
        p = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            p[i] = i;
        }

        nums = new HashSet<>();
        // permutation 모든 경우 구하기
        for (int i = 1; i <= numbers.length(); i++) {
            result = new char[i];
            permutation(0, i);
        }

        for (int n : nums) {
            if (isPrime(n)) {
                answer += 1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(new P42839().solution(numbers));
        // answer
        // 2
    }
}
