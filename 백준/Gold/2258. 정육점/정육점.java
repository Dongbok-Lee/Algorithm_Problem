import java.util.*;
import java.io.*;

class Main{
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long sum = 0;
    static long minPrice = 2222222222L;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Meat[] arr = new Meat[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Meat(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr,(x, y)-> {
            if(x.price == y.price)
                return y.weight - x.weight;
            else
                return x.price - y.price;
        });

        long tmp = -1;
        long price = 0;
        for(int i = 0; i < N; i++){
            if(sum < M){
                sum += arr[i].weight;
                if(tmp == arr[i].price)
                    price += arr[i].price;
            }

            if(tmp != arr[i].price)
                price = arr[i].price;

            if(sum >= M){
                minPrice = Math.min(minPrice, price);
            }

            tmp = arr[i].price;
        }


        if(minPrice == 2222222222L)
            System.out.println(-1);
        else
            System.out.println(minPrice);
    }
}

class Meat{
    int weight, price;

    public Meat(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}