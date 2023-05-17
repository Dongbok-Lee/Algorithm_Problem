import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String str = "" + N;
        int result = 0;
        Queue<Node> q = new LinkedList<>();
        boolean visited[][] = new boolean[1000001][11];

        if(N < 10){
            System.out.println(-1);
            return;
        }



        if(N < 100 && N % 10 == 0){
            System.out.println(-1);
            return;
        }


        for(int i = 0; i < str.length() - 1; i++){
            for(int j = i + 1; j < str.length(); j++){
                String cur = swap(str, i, j);
                q.add(new Node(cur,1));
            }
        }

        while(!q.isEmpty()){
            Node curNode = q.poll();

            if(curNode.k == K){
                result = Math.max(result, Integer.parseInt(curNode.n));
                continue;
            }


            for(int i = 0; i < str.length() - 1; i++){
                for(int j = i + 1; j < str.length(); j++){
                    String cur = swap(curNode.n, i, j);

                    if(!visited[Integer.parseInt(cur)][curNode.k + 1] && cur.charAt(0) != '0'){
                        visited[Integer.parseInt(cur)][curNode.k + 1] = true;
                        q.add(new Node(cur,curNode.k+1));
                    }
                }
            }
        }

        System.out.println(result);
    }

    static String swap(String n, int i, int j){
        char[] charArr = n.toCharArray();

        char tmp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = tmp;
        return String.valueOf(charArr);
    }


    static class Node{
        String n;
        int k;
        public Node(String n, int k) {
            this.n = n;
            this.k = k;
        }
    }
}