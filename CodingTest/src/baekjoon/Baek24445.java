package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek24445 {
    static int M;
    static int N;
    static int result [];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited [];
    static int cnt = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        result = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        bfs(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < result.length; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        result[start] = cnt++;

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
