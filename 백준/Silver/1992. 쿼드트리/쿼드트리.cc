#include <iostream>

using namespace std;

int N;
int screen[66][66];

int compression(int x, int y, int n){

    for(int i = x; i < x + n; i++) for(int j = y; j < y + n; j++){

        if(n < 2){
            cout << screen[i][j];
        }

        else if(screen[x][y] != screen[i][j]){
            n = n/2;
            cout << "(";

            for(int k = 0; k < 2; k++) for(int l = 0; l < 2; l++)   compression(x+(n*k),y+(n*l),n);             
           
            cout << ")";
            
            return 0;
        }
    }

    if(n > 1){
        cout << screen[x][y] ;
    }
    
    return 0;
 }



int main(){
    cin >> N;

    for(int i = 1; i <= N; i++) for(int j = 1; j <= N; j++) scanf("%1d",&screen[i][j]);
   
    compression(1,1,N);
    
    return 0;
}