package ssafy10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2800 {
    static char[] array;
    static boolean[] checked;
    static int[] pair;
    static StringBuilder sb;
    static Set<String> answer;
    static int target;

    public static void dfs(int dept) {
        if (dept == target) {
            answer.add(sb.toString());
            return;
        }

        char now = array[dept];
        if (now == '(') {
            checked[dept] = true;
            dfs(dept + 1);
            checked[dept] = false;
        }
        if (now == ')' && checked[pair[dept]]) {
            dfs(dept + 1);
            checked[dept] = false;
        } else {
            sb.append(now);
            dfs(dept + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        array = input.toCharArray();
        checked = new boolean[array.length];
        Stack<Integer> stack = new Stack<>();
        sb = new StringBuilder();
        answer = new HashSet<>();
        pair = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(i);
            } else if (array[i] == ')') {
                pair[i] = stack.peek();
                pair[stack.pop()] = i;
            }
        }
        target = array.length;
        dfs(0);
        answer.remove(input);

        List<String> ans = new ArrayList<>(answer);
        Collections.sort(ans);
        StringBuilder s = new StringBuilder();
        for (String tmp : ans){
            s.append(tmp + "\n");
        }
        System.out.println(s);
    }
}
