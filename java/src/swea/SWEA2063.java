package swea;

import java.util.*;

// 2063 중간값 찾기
public class SWEA2063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(sc.nextInt());
        }
        Collections.sort(nums);

        int mid = (int) (N / 2.0);

        System.out.println(nums.get(mid));
    }
}
