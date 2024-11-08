import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQueueTest {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>(); //자바 내부 우선순위 큐 객체 생성
        PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());


        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            priorityQueueLowest.add(val);
            priorityQueueHighest.add(val);
        }


        /*우선순위 큐를 출력하기 위해 링크드리스트로 변경하면 값의 변동이 발생
        poll()메소드를 사용하먄 값 반환 후 큐에서 제거하며 출력하기 때문에 반복문 사용 시 고정된 size값으로 조건을 주어야함*/
        for(int i = 0; i < row; i++){
            System.out.println(i + "번째 우선순위 낮음 큐 : " + priorityQueueLowest.poll());
        }

        System.out.println("=======================================");

        for(int j = 0; j < row; j++){
            System.out.println(j + "번째 우선순위 높음 큐 : " + priorityQueueHighest.poll());
        }
    }
}
