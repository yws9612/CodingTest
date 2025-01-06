package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek5427 {
    static int N;
    static int W;
    static int H;

    static char graph [][];

    static Queue<int []> fQue;
    static Queue<int []> pQue;

    static int dx [] = {-1, 1, 0, 0};
    static int dy [] = {0, 0, -1, 1};

    static int d = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            graph = new char[H][W];

            fQue = new LinkedList<>();
            pQue = new LinkedList<>();

            for(int j = 0; j < H; j++){
                st = new StringTokenizer(br.readLine());
                String tmp = st.nextToken();
                for(int k = 0; k < W; k++){
                    char t = tmp.charAt(k);
                    graph[j][k] = t;
                    if(t == '*'){
                        fQue.offer(new int[] {j, k, 0});
                    }else if(t == '@'){
                        pQue.offer(new int[] {j, k, 0});
                    }
                }
            }
            d = 0;
            bfs();

            StringBuilder sb = new StringBuilder();

            if(d == 0){
                sb.append("IMPOSSIBLE\n");
            }else{
                sb.append(d).append("\n");
            }

            System.out.print(sb);
        }
    }

    public static void bfs(){

        while(!pQue.isEmpty()){
            int size = fQue.size();

            for(int i = 0; i < size; i++){
                int poll [] = fQue.poll();
                int cur_x = poll[0];
                int cur_y = poll[1];
                for(int j = 0; j < dx.length; j++){
                    int next_x = cur_x + dx[j];
                    int next_y = cur_y + dy[j];

                    if((next_x >= 0 && next_x < H) && (next_y >= 0 && next_y < W)){
                        if(graph[next_x][next_y] == '.'){
                            graph[next_x][next_y] = '*';
                            fQue.offer(new int[] {next_x, next_y, 0});
                        }
                    }
                }
            }

            size = pQue.size();
            for(int i = 0; i < size; i++){
                int poll [] = pQue.poll();
                int cur_x = poll[0];
                int cur_y = poll[1];
                int cur_l = poll[2];

                for(int j = 0; j < dx.length; j++){
                    int next_x = cur_x + dx[j];
                    int next_y = cur_y + dy[j];

                    if((next_x >= 0 && next_x < H) && (next_y >= 0 && next_y < W)){
                        if(graph[next_x][next_y] == '.'){
                            graph[next_x][next_y] = '@';
                            pQue.offer(new int [] {next_x, next_y, cur_l + 1});
                        }
                    }else{
                        d = cur_l + 1;
                        return;
                    }
                }
            }

        }
    }
}
