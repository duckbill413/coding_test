package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 1218. 괄호 짝짓기
public class SWEA1218 {
    private static final int T = 10;
    private static Stack<Character> a, b, c, d;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            char[] array = br.readLine().toCharArray();

            a = new Stack<>();
            b = new Stack<>();
            c = new Stack<>();
            d = new Stack<>();
            boolean check = true;

            for (int i = 0; i < N; i++) {
                if (array[i] == '(') {
                    a.add('(');
                } else if (array[i] == ')') {
                    if (a.empty()) {
                        check = false;
                        break;
                    }
                    a.pop();
                } else if (array[i] == '[') {
                    b.add('[');
                } else if (array[i] == ']') {
                    if (b.empty()) {
                        check = false;
                        break;
                    }
                    b.pop();
                } else if (array[i] == '{') {
                    c.add('{');
                } else if (array[i] == '}') {
                    if (c.empty()) {
                        check = false;
                        break;
                    }
                    c.pop();
                } else if (array[i] == '<') {
                    d.add('<');
                } else if (array[i] == '>') {
                    if (d.empty()) {
                        check = false;
                        break;
                    }
                    d.pop();
                }
            }
            if (!check || !a.empty() || !b.empty() || !c.empty() || !d.empty()) {
                sb.append("#").append(test_case).append(" ").append(0).append("\n");
            } else {
                sb.append("#").append(test_case).append(" ").append(1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
