package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 2493 탑
public class BOJ2493 {
    private static int N;
    private static Stack<Building> s;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        s = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (true) {
                // 스택이 빈 경우 데이터 추가
                if (s.isEmpty()) {
                    s.add(new Building(height, i));
                    sb.append(0).append(" ");
                    break;
                } else {
                    /*
                    스택의 맨 위 값이 현재 높이 보다 같거나 높은 경우
                    해당 스택의 맨 위 데이터의 인덱스 출력 이후
                    현재 데이터를 스택에 추가
                    스택의 맨 위 값이 현재 보다 작은 경우 pop하여 다음 데이터 탐색
                     */
                    if (s.peek().height >= height) {
                        sb.append(s.peek().index).append(" ");
                        s.add(new Building(height, i));
                        break;
                    } else {
                        s.pop();
                    }
                }
            }
        }

        System.out.println(sb);
    }

    private static class Building {
        int height;

        int index;

        public Building(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
