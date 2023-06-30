package swea;

import java.io.IOException;
import java.util.*;

public class SWEA1204 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            int t = sc.nextInt();
            sc.nextLine();
            List<Integer> scores = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                scores.add(sc.nextInt());
            }
            sc.nextLine();

            Collections.sort(scores);

            int result = scores.get(0);
            int max_count = 1;
            int count = 1;
            for (int i = 1; i < scores.size(); i++) {
                if (Objects.equals(scores.get(i), scores.get(i - 1))) {
                    count += 1;
                } else {
                    if (max_count <= count) {
                        max_count = count;
                        result = scores.get(i - 1);
                    }
                    count = 1;
                }
            }
            if (max_count < count) {
                result = scores.get(1000 - 1);
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }
}
