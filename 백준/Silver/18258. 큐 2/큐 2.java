import java.io.*;
import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque q = new ArrayDeque<Integer>();
    static int N;
    public static void main(String[] ars) throws IOException {

        N = Integer.parseInt(reader.readLine());

        for(int i = 0; i < N; i++){
            String s = reader.readLine();
            String command[] = s.split(" ");

            switch(command[0]){
                case "push":
                    q.offer(command[1]);
                    break;
                case "front":
                    if(!q.isEmpty())
                        writer.write(q.peek().toString() + "\n");
                    else
                        writer.write(-1+ "\n");
                    break;
                case "back" :
                    if(!q.isEmpty())
                        writer.write(q.peekLast().toString()+ "\n");
                    else
                        writer.write(-1+ "\n");
                    break;
                case "size" :
                    writer.write(q.size()+ "\n");
                    break;
                case "pop" :
                    Object pop = q.poll();
                    if(pop == null)
                        writer.write(-1+ "\n");
                    else
                        writer.write(pop.toString()+ "\n");
                    break;
                case "empty" :
                    if(q.isEmpty())
                        writer.write(1+ "\n");
                    else
                        writer.write(0+ "\n");
            }


        }
        writer.flush();
        writer.close();
    }
}
