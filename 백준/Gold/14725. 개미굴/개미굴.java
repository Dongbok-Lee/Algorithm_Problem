import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, ArrayList> tree;
    static int N, K;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        Tree root = new Tree();

        while(N-- != 0){
            st = new StringTokenizer(br.readLine());

            Tree cur = root;
            K = Integer.parseInt(st.nextToken());

            for(int i = 0; i < K; i++){
                String str = st.nextToken();

                if(!cur.children.containsKey(str)){
                    cur.children.put(str, new Tree());
                }
                cur = cur.children.get(str);
            }
        }

        print(root,"");
    }

    public static void print(Tree tree, String str){
        Object[] array = tree.children.keySet().toArray();
        Arrays.sort(array);

        for(Object o : array){
            System.out.println(str + o);
            print(tree.children.get(o),str + "--");
        }

    }

}

class Tree{
    HashMap<String, Tree> children = new HashMap<>();
}