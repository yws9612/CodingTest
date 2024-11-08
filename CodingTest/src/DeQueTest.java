import java.util.Deque;
import java.util.LinkedList;

public class DeQueTest {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>(); //DeQue는 인터페이스로만 지원하기 때문에 링크드리스트로 생성

        /*
        getFirst()
        맨 앞의 원소를 리턴
        덱이 비어있는 경우 예외 발생

        getLast()
        마지막 원소를 리턴
        덱이 비어있는 경우 예외 발생

        peek()
        맨 앞의 원소를 리턴
        덱이 비어있는 경우 null 리턴

        peekFirst()
        맨 앞의 원소를 리턴
        덱이 비어있는 경우 null 리턴

        peekLast()
        마지막 원소를 리턴
        덱이 비어있는 경우 null 리턴

        이 외 사용법 스택, 큐와 동일
        */
    }
}
