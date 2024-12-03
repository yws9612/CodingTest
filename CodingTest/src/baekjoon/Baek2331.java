package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek2331 {

    static int n;
    static int graph[];
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(x);

        while(true){
            int tmp = arr.get(arr.size() - 1);
            int result = 0;

            while(tmp != 0){
                result += (int) Math.pow(tmp % 10, (double) y);
                tmp /= 10;
            }

            if(arr.contains(result)){
                int ans = arr.indexOf(result);
                System.out.println(ans);
                break;
            }
            arr.add(result);
        }
    }
}
