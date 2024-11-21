package inflearn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class infQueueDeQueue {
    public static void main(String[] args) {
        /*
        deque : Doubly Ended Queue의 줄임말
        Queue와 Deque 는 모두 비슷한 구조를 갖고 있지만, Deque는 양방향 구조를 갖고있음.
        Queue는 자바에서 Queue 객체를 사용하면 되지만, Deque는 Inteface이기 때문에 링크드 리스트로 객체 선언을 해줘야함.
        Queue는 단독으로 잘 나오지 않고, 다른 알고리즘 문제(너비우선 탐색 - BFS)에서 자주 사용됨.
        FIFO(First In Frist Out)
         */
        Deque<Integer> deque = new LinkedList<>();


    }
}
