#include <iostream>

using namespace std;

int N,K;
int result[21] = {0,1,};

void h_result(int n){
    for(int i = 2; i <= n; i++)  result[i] = result[i-1]*2 +1;
    return;
}

void hanoi(int n, int start, int destination){
    int another = 6 - start - destination;
    if(n > 0){
    hanoi(n-1,start,another);
    cout << start << " " << destination<<"\n";
    hanoi(n-1,another,destination);
    }
    return;
}

int main(){

    cin >> N;
    h_result(N);
    cout << result[N] << "\n";

    hanoi(N, 1, 3);

    return 0;
}