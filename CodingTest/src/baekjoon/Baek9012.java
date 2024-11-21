package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());

        for(int i = 0; i < row; i++){
            String val = "";
            st = new StringTokenizer(br.readLine());
            val = st.nextToken();

            Stack<String> stack = new Stack<>();
            boolean chk = true;

            for(int j = 0; j < val.length(); j++){
                if(val.charAt(j) == '('){
                    stack.push("(");
                }else if(val.charAt(j) == ')'){
                    if(stack.isEmpty()){
                        chk = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty() || !chk){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }

    }
}
