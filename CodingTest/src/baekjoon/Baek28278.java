package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek28278 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "1":
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                case "2":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack.pop());
                    }
                    break;
                case "3":
                    System.out.println(stack.size());
                    break;
                case "4":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "5":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack.peek());
                    }
                    break;
            }

        }
    }
}
