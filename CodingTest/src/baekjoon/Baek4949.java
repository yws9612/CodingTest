package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek4949 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String sen = "";
            Stack<String> stack = new Stack<>();
            sen = br.readLine();

            boolean chk = true;
            if(sen.equals(".")){
                break;
            }else{
                for(int i = 0; i < sen.length(); i++){
                    if(sen.contains("(") || sen.contains(")") || sen.contains("[") || sen.contains("]")){
                        if(sen.charAt(i) == '('){
                            stack.add("(");
                        }else if(sen.charAt(i) == ')'){
                            if(!stack.isEmpty() && stack.peek().equals("(")){
                                stack.pop();
                            }else{
                                chk = false;
                                break;
                            }
                        }else if(sen.charAt(i) == '['){
                            stack.add("[");
                        }else if(sen.charAt(i) == ']'){
                            if(!stack.isEmpty() && stack.peek().equals("[")){
                                stack.pop();
                            }else{
                                chk = false;
                                break;
                            }
                        }
                    }
                }
            }
            if(!stack.isEmpty() || !chk){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }
        }
    }
}
