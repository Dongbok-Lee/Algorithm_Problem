#include<iostream>
#define MAX 2200
using namespace std;

int paper[MAX][MAX];
int num[3] = {};
int N;

void calc_num(int x, int y, int n){

    for(int i = x; i < x+n; i++){
        for(int j = y; j < y+n;  j++){
            if(paper[i][j] != paper[x][y]){

                if( n >= 9){
                    n = n/3;
                    for(int k =0; k < 3; k++) for(int l = 0; l < 3; l++) calc_num(x+(k*n),y+(l*n),n);
                    return;                    
                } 
                else{
                    for(int a = 0; a < 3; a++) for(int b = 0; b < 3; b++){
                        num[paper[x+a][y+b]+1]++;
                    } 
                    return;
                }
            } 
        }
    }

    num[paper[x][y]+1]++;

    return;
}

int main(){

    cin >> N;

    for(int i = 1; i <= N; i++) for(int j = 1; j <= N; j++) cin >> paper[i][j];

    calc_num(1,1,N);

    cout << num[0]<< "\n" << num[1] << "\n" << num[2];

    return 0;
}