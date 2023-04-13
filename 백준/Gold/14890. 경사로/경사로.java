import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, L, result;
    static int[][] map;
    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //가로
        for(int i = 0; i < N; i++){

            int cnt = 1;

            for(int j = 0; j < N; j++){

                if(j == N-1){
                    result++;
                    break;
                }

                if(map[i][j] == map[i][j+1])
                    cnt ++;
                else if(map[i][j] == map[i][j+1] + 1){

                    for(int k = 0; k < L-1; k++){
                        j++;
                        if(j == N-1){
                            break;
                        }
                        if(map[i][j] != map[i][j + 1]){
                            j = N-1;
                            break;
                        }
                    }
                    cnt = 0;

                }else if(map[i][j] == map[i][j+1]-1){

                    if(cnt >= L){
                        cnt = 1;
                    }else{
                        break;
                    }

                }else
                    break;
            }
        }

        //세로
        for(int i = 0; i < N; i++){

            int cnt = 1;

            for(int j = 0; j < N; j++){

                if(j == N-1){
                    result++;
                    break;
                }

                if(map[j][i] == map[j+1][i])
                    cnt ++;
                else if(map[j][i]  == map[j+1][i] + 1){

                    for(int k = 0; k < L-1; k++){
                        j++;
                        if(j == N-1){
                            break;
                        }
                        if(map[j][i] != map[j + 1][i]){
                            j = N-1;
                            break;
                        }
                    }
                    cnt = 0;

                }else if(map[j][i] == map[j+1][i]-1){

                    if(cnt >= L){
                        cnt = 1;
                    }else{
                        break;
                    }

                }else
                    break;
            }
        }

        System.out.println(result);
    }
}