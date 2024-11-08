import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        int pop = 0;

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()){
                case "push":
                    pop = Integer.parseInt(st.nextToken());
                    stack.push(pop);
                    break;

                case "pop":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack.pop());
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;

                case "top":
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
