package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int max = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        int start = 0;

        boolean chk = true;

        for(int i = 0 ; i < max; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if(num > start) {
                for (int j = start + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = num;
            }
            if(stack.peek() == num){
                stack.pop();
                sb.append('-').append('\n');
            }else{
                System.out.println("NO");
                return;
            }

        }
        System.out.println(sb);
    }
}
