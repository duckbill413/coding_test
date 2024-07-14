package programmers;

import java.util.Stack;

public class P131704 {
    public int solution(int[] order) {
        Stack<Integer> s = new Stack<>();

        int answer = 0;
        int idx = 0;
        int id = 1;
        while (idx < order.length) {
            if (order[idx] == id) {
                answer += 1;
                idx += 1;
                id += 1;
            } else {
                if (s.isEmpty()) {
                    s.push(id++);
                } else {
                    if (s.peek() == order[idx]) {
                        idx += 1;
                        answer += 1;
                        s.pop();
                    } else if (id < order.length + 1) {
                        s.push(id++);
                    } else {
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        System.out.println(new P131704().solution(order));
        // answer
        // 2
    }
}
