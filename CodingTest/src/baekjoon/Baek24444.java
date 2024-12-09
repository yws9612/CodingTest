package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek24444 {
    static int M;
    static int N;
    static int cnt = 1;
//    static int graph [][];

    static ArrayList<ArrayList<Integer>> graph =  new ArrayList<>();
    static boolean visited[];
    static int result[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        bfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        visited[x] = true;
        result[x] = cnt++;
        q.offer(x);
        while(!q.isEmpty()){
            int poll = q.poll();

            for(int val : graph.get(poll)){
                if(!visited[val]){
                    visited[val] = true;
                    q.offer(val);
                    result[val] = cnt++;
                }
            }
        }
    }
}
