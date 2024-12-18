package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1325 {
    static int M;
    static int N;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int result [];
    static boolean visited [];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N+1];


        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
        }

        for(int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            bfs(i);
        }
        int big = 0;
        for (int i = 1; i <= N; i++) {
            big = Math.max(big, result[i]);
        }
        for (int i = 1; i <= N; i++) {
            if (result[i] == big) {
                System.out.print(i + " ");
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
                    result[val]++;
                    visited[val] = true;
                    q.offer(val);
                }
            }
        }
    }
}
