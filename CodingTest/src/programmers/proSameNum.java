package programmers;

import java.util.Objects;
import java.util.Stack;

public class proSameNum {
    public static void main(String[] args) {
        solution(new int [] {1,1,3,3,0,1,1});
    }

    static int[] solution(int [] arr){
        Stack<Integer> stack = new Stack<>();

        for(int i : arr){
            if(stack.isEmpty() || !stack.peek().equals(i)){
                stack.push(i);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray(); //스택을 스트림으로 풀어서 일반 int 배열로 변환
    }
}
