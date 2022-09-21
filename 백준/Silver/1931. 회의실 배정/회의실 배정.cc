#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N;
int result = 0;
vector<pair<int,int>> v;

bool compare(pair<int, int> A, pair<int,int> B){
    if(A.second == B.second){
        return A.first < B.first;
    }
    else{
        return A.second < B.second;
    }
}

int main(){
    cin >> N;

    int s, f;
    int tmp = 0;

    for(int i = 0; i < N;  i++){
        cin >> s;
        cin >> f;
    
        v.push_back({s,f});
    }

    sort(v.begin(),v.end(),compare);

     for(int i = 0; i < N; i++){

        if(v[i].first >= tmp ){
            tmp = v[i].second;
            result++;
         }
   }
   cout  << result;    
}