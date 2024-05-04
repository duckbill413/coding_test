package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Upper_Lower_Bound {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(Arrays.asList(13, 13, 15, 17, 17, 17, 17, 20, 20));
        int lower = lowerBound(data, 17);
        int upper = upperBound(data, 17);
        System.out.println("lower_bound: " + lower); // 찾는 원소가 있는 첫번째 index
        System.out.println("upper_bound: " + upper); // 찾는 원소가 있는 index + 1
        System.out.println("item count: " + (upper - lower));

        int index = Collections.binarySearch(data, 17);
        System.out.println("binarySearch: " + index);
        index = Collections.binarySearch(data, 18);
        System.out.println("binarySearch: " + index);
        // target이 18일때의 결과값은 -8이다.
        // 만약 target 18을 data에 삽입할려고 할때의 위치는 (-8) * (-1) - 1 = 7
        // 즉 7의 위치에 삽입할 경우 정렬된 상태를 유지할 수 있다.
        System.out.println("insert data 18 to index 7");
        data.add(7, 18);
        System.out.println(data);
    }

    private static int lowerBound(List<Integer> data, int target) {
        int start = 0;
        int end = data.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (data.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private static int upperBound(List<Integer> data, int target) {
        int start = 0;
        int end = data.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (data.get(mid) > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
