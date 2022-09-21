#include <iostream>
#include <algorithm>
#define MAX 4000002

using namespace std;

int N;
bool arr[MAX] = {true, true,};
int start = 0;
int finish = 0;
int sum = 0;
int cnt = 0;

int init(){
    cin >> N;
    return 0;
}

int sieve(){
    
    for(int i = 2; i*i <= N; i++){
        if(arr[i] == false){
            for(int j = i*i ; j <=N; j += i){
                arr[j] = true;
            }
        }
    }

    return 0;
}

int twopointer(){

    while(start <= finish){
        if(sum >= N){
           
            if(sum == N){
                cnt ++;
            }
                
            if(arr[start] == true){
                while(arr[start] == true && start <= N){
                    start++;
                }
            }

            sum -= start;
            start++;

        }
        
        else{
            if(arr[finish] == true){
                while(arr[finish] == true && finish <= N){
                    finish++;
                }
            }

            sum += finish;
            finish++;

        }

        if(finish > N+1)
            break;

    }
   
    return 0;
}

int main(){

    init();

    sieve();

    twopointer();

    cout << cnt;

    return 0;
}
