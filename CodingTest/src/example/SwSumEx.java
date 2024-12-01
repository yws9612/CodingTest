package example;

import java.util.Scanner;

public class SwSumEx {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[100][100];

        int answer = 0;

        int temp = 0;
        int temp2 = 0;


        for(int i = 0; i < 10; i++){
            int tRow = 0;
            int tCol = 0;
            int tCro = 0;
            int tRcro = 0;

            for(int j = 0; j < 100; j++){
                for(int k = 0; k < 100; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            for(int j = 0; j < 100; j++){
                int col = 0;
                int row = 0;
                int cross = 0;
                int rCross = 0;

                for(int k = 0; k < 100; k++){
                    row += arr[k][j];
                    col += arr[j][k];
                }
                cross += arr[j][j];
                rCross += arr[j][99-j];
                tRow = Math.max(tRow, row);
                tCol = Math.max(tCol, col);
                tCro = Math.max(tCro, cross);
                tRcro = Math.max(tRcro, rCross);
            }
            temp = Math.max(tCol, tRow);
            temp2 = Math.max(tCro, tRcro);
            answer = Math.max(temp2, temp);

            System.out.println("#" + (i+1) + ' ' + answer);
        }
        sc.close();
    }
}
