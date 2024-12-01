package example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CodingTestEx {
    public static int[][] branch; //부모-자식 노드 정보
    public static boolean[] visit; //방문 노드
    public static Queue<Integer> queue;
    public static int N; //정점 개수
    public static int V; //탐색 시작 정점 번호
    public static int M; //간선 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        branch = new int[1001][1001]; //정점의 범위가 1 <= x <= 1000 이기 때문에 범위 설정
        visit = new boolean[1001]; //방문 정점 범위는 위와 동일하기 때문에 크기 설정 동일

        for (int i = 0; i < M; i++) { //간선 개수만큼 반복
            int a = sc.nextInt();
            int b = sc.nextInt();
            //입력받은 배열 branch[a][b]의 값을 1로 설정, 예시로 1-4, 4-1은 같은 노드임으로 동일 취급
            branch[a][b] = branch[b][a] = 1;
        }

//        dfs(V); //dfs 함수 호출
//        System.out.println();

//        Arrays.fill(visit, false);
        bfs(V);
    }

    public static void dfs(int start) {
        visit[start] = true; //방문점을 true로 변경
        System.out.print(start + " "); //방문지 출력
        for (int i = 1; i <= N; i++) { //정점 개수만큼 반복
            if (branch[start][i] == 1 && visit[i] == false) {
                dfs(i); //재귀를 함으로써 방문한 i의 visit값을 true로 만듦
            }

        }
    }

    public static void bfs(int start) {
        queue = new LinkedList<Integer>();
        queue.add(start); //queue에 인자 값 추가
        visit[start] = true; //추가된 인자 값 true 설정
        System.out.print(start + " "); //최초 시작 값 출력

        while (!queue.isEmpty()) { //queue가 빌 때 까지
            int temp = queue.poll(); //방문한 인자를 큐에서 제거 및 제거된 인자 값을 temp에 저장

            for (int i = 1; i < branch.length; i++) {
                if (branch[temp][i] == 1 && visit[i] == false) {
                    queue.add(i); //인접 노드 추가
                    visit[i] = true; //추가된 노드는 중복추가되지 않도록 true로 설정
                    System.out.print(i + " "); // 결과값 출력
                }
            }
        }
    }
}
