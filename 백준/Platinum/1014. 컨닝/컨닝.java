import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, C;
    static int[][] room;
    static int[][] scopes = {{-1, 1}, {-1, 0}, {-1, -1}, {1, 1}, {1, 0},{1, -1}};
    static boolean[][] nodes;
    static int visitCount;
    static int[] visit;
    static int[] matched;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());

        while(C-- > 0){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            boolean[][] canSeat = new boolean[N][M];

            int numbering = 1;

            int broken = 0;

            room = new int[N][M];
            nodes = new boolean[N*M][N*M];

            visitCount = 1;

            for(int n = 0; n < N; n++){
                String str = br.readLine();

                for(int m = 0; m < M; m++){
                    room[n][m] = numbering++;

                    if(str.charAt(m) == '.')
                        canSeat[n][m] = true;
                    else{
                        canSeat[n][m] = false;
                        broken++;
                    }
                }
            }

            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m+=2){
                    if(canSeat[n][m]){
                        for(int[] scope : scopes){
                            int no = n +scope[1];
                            int mo = m + scope[0];

                            if(no > -1 && mo > -1 && mo < M && no < N && canSeat[no][mo])
                                nodes[room[n][m]-1][room[no][mo]-1] = true;
                        }
                    }
                }
            }

            int result = bipartite();

            System.out.println(N * M - broken - result);
        }
    }

    static int bipartite(){
        int size = 0;

        visit = new int[N * M];
        matched = new int[N * M];

        Arrays.fill(matched, -1);

        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m += 2){
                visitCount++;

                size += dfs(room[n][m] - 1);
            }
        }
        return size;
    }

    static int dfs(int num){
        if(visit[num] != visitCount){
            visit[num] = visitCount;

            for(int i = 0; i < N * M; i++){
                if(nodes[num][i]){
                    if(matched[i] == -1 || dfs(matched[i]) == 1){
                        matched[i] = num;
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

}