#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int k = 1;
int S[13];
bool visited[13];

int init(){
    
    cin >> k;

    for(int i = 0; i < k; i++){
        cin >> S[i];
    }
    return 0;
}

int dfs(int v, int count, int num){


    visited[v] = true;

    for(int i = 0; i <= count; i++){
        if(num != 0 && visited[v+i+1] == false && count-i >= 0){
            dfs(v+i+1,count-i, num-1);
        }   
    }

   

    if(num == 0){
        for(int j = 0; j < k; j++){
            if(visited[j] == true){

                cout << S[j]<< " ";
            }
        }
        cout << "\n";
    }

    visited[v] = false;

    return 0;
}


int main(){

    while(1){

        init();

        if(k == 0){
            return 0;
        }

        for(int i = 0; i <= k-6; i++){
            dfs(i,k-6-i,5);
        }

        cout << "\n" ;
        
    }
    
    return 0;
}
//2021-09-01 solved
