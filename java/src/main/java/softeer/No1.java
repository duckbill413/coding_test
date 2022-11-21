package softeer;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1 {
    // StringBuilder, StringBuffer(멀티 쓰레드 동기화 지원)
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static int [][] array;

    public static void compress(int x, int y, int size){
        int root = array[x][y];
        Boolean flag = Boolean.TRUE;

        for (int i=x; i<x+size; i++){
            for (int j=y; j<y+size; j++){
                if (root != array[i][j]){
                    flag = Boolean.FALSE;
                    break;
                }
            }
            if (!flag)
                break;
        }
        if (!flag) {
            sb.append("(");
            compress(x, y, size / 2);
            compress(x, y + size/2, size / 2);
            compress(x + size/2, y, size / 2);
            compress(x + size/2, y + size/2, size / 2);
            sb.append(")");
        }
        else{
            sb.append(root);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int [8][8];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String [] tmp = st.nextToken().split("");
            for (int j=0; j<tmp.length; j++){
                array[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        compress(0, 0, n);
        System.out.println(sb);
    }
}
