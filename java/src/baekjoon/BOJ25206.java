package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 25206 너의 평점은
public class BOJ25206 {
    private static Map<String, Double> sc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sc = new HashMap<>();
        sc.put("A+", 4.5);
        sc.put("A0", 4.0);
        sc.put("B+", 3.5);
        sc.put("B0", 3.0);
        sc.put("C+", 2.5);
        sc.put("C0", 2.0);
        sc.put("D+", 1.5);
        sc.put("D0", 1.0);
        sc.put("F", 0.0);
        String[][] subjects = new String[20][3];
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            subjects[i][0] = st.nextToken();
            subjects[i][1] = st.nextToken();
            subjects[i][2] = st.nextToken();
        }

        double grade = 0;
        double score = 0.0;
        for (int i = 0; i < 20; i++) {
            if (subjects[i][2].equals("P")) continue;
            grade += Double.parseDouble(subjects[i][1]);
            score += Double.parseDouble(subjects[i][1]) * sc.get(subjects[i][2]);
        }

        System.out.printf("%.6f", score / grade);
    }
}
