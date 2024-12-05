package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek11725 {
    /*
    graph[x][y] = graph[y][x] = 1
    과
    tree.get(x).add(y)
    tree.get(y).add(x)는 같은 코드임. 헷갈리지 말고 둘 다 쓸줄 알 것!
     */

    static int parentNode [];
    static int N;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited [];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        parentNode = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i ++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs(1);
        for(int result : parentNode){
            if(result != 0){
                System.out.println(result);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;

        q.offer(start);
        while(!q.isEmpty()){
            int poll = q.poll();

            for(int val : graph.get(poll)){
                if(!visited[val]){
                    visited[val] = true;
                    parentNode[val] = poll;
                    q.offer(val);
                }
            }
        }
    }
}
