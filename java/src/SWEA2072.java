import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA2072 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int result = 0;
            for (int num : nums) {
                if (num % 2 != 0) {
                    result += num;
                }
            }
            System.out.printf("#%d %d%n", test_case, result);
        }
    }
}
