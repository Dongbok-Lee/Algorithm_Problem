#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    long long N,M;
    
    cin >> N >> M;
    
    cout << max(M,N) - min(M,N);
    
    return 0;
}