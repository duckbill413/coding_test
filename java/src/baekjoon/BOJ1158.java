package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 1158 요세푸스 문제
public class BOJ1158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            ll.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int delIdx = M - 1;
        while (true) {
            sb.append(ll.remove(delIdx)).append(", ");
            if (ll.isEmpty()) {
                break;
            }
            delIdx = (delIdx + M - 1) % ll.size();
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}
