import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //버퍼 입력 객체 추가
        StringTokenizer st = new StringTokenizer(br.readLine()); //한 열에 입력될 객체 생성(엔터 시 입력 종료)

        int row = Integer.parseInt(st.nextToken()); //입력 할 라인 수
        LinkedList<String> queue = new LinkedList<String>(); //링크드리스트 객체 생성, 제네렉 안 자료형 수정 가능

        for(int i = 0; i < row; i++){ //12번 라인에서 입력받은 row 수 만큼 반복
            st = new StringTokenizer(br.readLine()); //횟수가 반복 될 때마다 입력 받는 객체 생성(엔터 시 입력 종료)
            queue.offer(st.nextToken()); //큐에 순서대로 값 추가(FIFO)
        }

        String pollData = queue.poll(); //큐의 요소 제거(제일 처음 입력된 항목)
        System.out.println("꺼낸 데이터 : " + pollData);

        for(int i = 0; i < queue.size(); i++){ //큐 사이즈 만큼 반복
            System.out.println(i + "번째 데이터 : " + queue.get(i));
        }

    }
}
