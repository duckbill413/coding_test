package swea;

import java.util.Scanner;

public class SWEA1936 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        switch (a) {
            case 1:
                if (b == 2)
                    System.out.println('B');
                else if (b == 3) {
                    System.out.println('A');
                }
                break;
            case 2:
                if (b == 1) {
                    System.out.println('A');
                } else if (b == 3) {
                    System.out.println('B');
                }
                break;
            case 3:
                if (b == 1) {
                    System.out.println('B');
                } else if (b == 2) {
                    System.out.println('A');
                }
                break;
        }
    }
}