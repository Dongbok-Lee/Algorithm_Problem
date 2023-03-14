import java.io.*;
import java.util.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Stack<Node> stack;
    static long result = 0;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        stack = new Stack<Node>();

        stack.push(new Node(Integer.parseInt(br.readLine()),0));

        while( --N != 0){
            int num = Integer.parseInt(br.readLine());
            int sameHeightNum = 0;

            while(!stack.isEmpty()){


                if(stack.peek().height > num){
                    result++;
                    break;
                }
                else if(stack.peek().height < num){
                    result += stack.peek().sameHeightNum;
                    result++;
                    stack.pop();
                }
                else{
                    result += stack.peek().sameHeightNum + 1;
                    sameHeightNum += stack.peek().sameHeightNum + 1;
                    stack.pop();
                }
            }

            stack.push(new Node(num, sameHeightNum));

        }

        System.out.println(result);
    }
}

class Node{
    int height, sameHeightNum;

    public Node(int height, int sameHeightNum) {
        this.height = height;
        this.sameHeightNum = sameHeightNum;
    }
}