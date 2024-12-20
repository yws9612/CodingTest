package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek15900 {
    static int R;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];

    static int totDep = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        visited = new boolean[R + 1];

        for(int i = 0; i <= R; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < R - 1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        dfs(1, 0);


        if(totDep % 2 == 1){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static void dfs(int start, int p){
        visited[start] = true;
        boolean chk = true;

        for(int val : graph.get(start)){
            if(!visited[val]){
                dfs(val, p+1);
                chk = false;
            }
        }

        if(chk){
            totDep += p;
        }
    }
}
