package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 16637 괄호 추가하기
public class BOJ16637 {
    private static int N;
    private static List<Integer> nums;
    private static List<Character> opers;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new ArrayList<>();
        opers = new ArrayList<>();

        String tmp = br.readLine();
        for (Character c : tmp.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                opers.add(c);
            } else {
                nums.add(Character.getNumericValue(c));
            }
        }

        answer = Integer.MIN_VALUE;
        dfs(0, nums.get(0));
        System.out.println(answer);
    }

    private static void dfs(int index, int sum) {
        if (index == opers.size()) {
            answer = Math.max(answer, sum);
            return;
        }
        // 괄호 미 적용
        int result = calc(sum, nums.get(index + 1), opers.get(index));
        dfs(index + 1, result);

        // 괄호 적용 (뒤에 연산자가 있을때 사용)
        if (index + 1 < opers.size()) {
            int right = calc(nums.get(index + 1), nums.get(index + 2), opers.get(index + 1));
            int left = calc(sum, right, opers.get(index));
            dfs(index + 2, left);
        }
    }

    private static int calc(int a, int b, char oper) {
        if (oper == '+') return a + b;
        else if (oper == '-') return a - b;
        else return a * b;
    }
}
