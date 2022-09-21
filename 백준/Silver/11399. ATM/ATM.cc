#include <iostream>
#include <algorithm>

using namespace std;

int N;
int time[1001];
int cnt = 0;
int result = 0;

int main(){
    
    cin >> N;

    for(int i = 0; i < N; i++) cin >> time[i];

    sort(time,time+N);

    for(int i = 0; i < N; i++){

        result += cnt + time[i];
        cnt += time[i];
    }

    cout << result;

    return 0;
}