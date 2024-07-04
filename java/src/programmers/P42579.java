package programmers;

import java.util.*;

public class P42579 {
    private Map<String, Integer> G;
    private Map<String, Queue<int[]>> S;

    public int[] solution(String[] genres, int[] plays) {
        G = new HashMap<>();
        S = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!G.containsKey(genres[i])) {
                G.put(genres[i], 0);
                S.put(genres[i], new PriorityQueue<>((a, b) -> {
                    // 0: 노래 id, 1: 노래 재생수
                    if (a[1] == b[1]) {
                        return a[0] - b[0];
                    }

                    return b[1] - a[1];
                }));
            }
            G.put(genres[i], G.get(genres[i]) + plays[i]);
            S.get(genres[i]).add(new int[]{i, plays[i]});
        }

        List<Map.Entry<String, Integer>> l = new ArrayList<>(G.entrySet());
        l.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : l) {
            Queue<int[]> cur = S.get(e.getKey());
            for (int k = 0; k < 2; k++) {
                if (!cur.isEmpty()) {
                    result.add(cur.poll()[0]);
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        new P42579().solution(genres, plays);
    }
}