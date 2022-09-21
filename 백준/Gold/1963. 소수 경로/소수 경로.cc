#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

int T;
int x,y;
int xs[4],ys[4];
int cnt = 0;

bool pnum[10000] = {true,true,};

int arr_to_int(int* num){
    int result;
    result = num[0]*1000+num[1]*100+num[2]*10+num[3];
    return result;
}

int *int_to_arr(int num, int result[]){
    result[0] = num/1000; result[1] = num/100%10;
    result[2] = num%100/10; result[3] = num%10;
    return result;
}

int eratosthenes_sieve(int max){

    for(int i = 2; i*i <= max; i++){
        for(int j = i+1; j < max; j++){
            if(j % i == 0) pnum[j] = true;
        }
    }
    return 0;
}

int bfs(){

    bool visited[10000] = {};
    queue<pair<int, int>> q;

    q.push({x,0});


    while(q.empty() == false){
        int ab[4];
        pair<int, int> a = q.front();
        q.pop();
        visited[a.first] = true;
        
        int_to_arr(a.first,ab);

        for(int i = 0; i < 4; i++){
            int tmp = ab[i];
            for(int j = 0; j < 10; j++){
                ab[i] = j;

                if(ab[0] != 0 && visited[arr_to_int(ab)] == false && pnum[arr_to_int(ab)] == 0)
                    q.push({arr_to_int(ab),a.second+1});
                if(arr_to_int(ab) == y){
                    cnt = a.second+1;
                    return 0;
                }
            }
            ab[i] = tmp;
        }
    }
    return 0;
}

int main(){
    
    eratosthenes_sieve(10000);
    
    cin >> T;

    for(int i = 0; i< T; i++){
        cin >> x >> y;

        int_to_arr(y,ys);

    bfs();
    if(x==y) 
        cout << "0" << "\n";
    else
        cout << cnt << "\n";
    cnt = 0;
    }
    return 0;
}