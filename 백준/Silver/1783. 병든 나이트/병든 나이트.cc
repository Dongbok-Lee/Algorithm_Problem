#include <iostream>
#include <algorithm>

using namespace std;

int N,M;

int main(){
    
    cin >> N >> M;

    if(N>=3){
        if(M<5){
            cout<< M;
        }
        else if(M<7){
            cout << "4";
        }
        else{
            cout << M-2;
        }
    }
    else if(N==2){
        if(M >= 7){
            cout << "4";
        }
        else{
            cout << (M+1)/2;
        }

    }
    else{
        cout << "1";
    }
    return 0;
}