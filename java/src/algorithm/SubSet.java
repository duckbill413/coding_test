package algorithm;

// 부분 집합 (Power Set)
public class SubSet {
    private static final int[] arr = {1, 2, 3};
    private static int N;

    public static void main(String[] args) {
        N = arr.length;
        boolean [] visited = new boolean[N];

        System.out.println("Power Set Recursion");
        powerSet(0, visited);
        System.out.println("Power Set Bit");
        bit();
    }

    private static void bit() {
        for (int i=0; i< 1 << N; i++){
            for (int j=0; j<N; j++){
                if ((i & 1 << j) != 0){
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void powerSet(int idx, boolean[] visited) {
        if (idx == N){
            print(visited);
            return;
        }

        visited[idx] = false;
        powerSet(idx+1, visited);
        visited[idx] = true;
        powerSet(idx+1, visited);
    }

    private static void print(boolean[] visited) {
        for (int i=0; i<N; i++){
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
