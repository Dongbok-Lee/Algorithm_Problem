import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        minHeap.add(Integer.parseInt(br.readLine()));
        sb.append(minHeap.peek() + "\n");

        for(int i = 0; i < N-1; i++){
            int num = Integer.parseInt(br.readLine());

            if(num > minHeap.peek()){
                maxHeap.add(num);
                if(minHeap.size() < maxHeap.size())
                    minHeap.add(maxHeap.poll());
            }
            else{
                minHeap.add(num);
                if(minHeap.size() > maxHeap.size() + 1)
                    maxHeap.add(minHeap.poll());
            }

            sb.append(minHeap.peek() + "\n");
        }

        System.out.println(sb);
    }
}
