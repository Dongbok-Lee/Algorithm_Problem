#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int A, B, C;
bool visited[201][201][201] = {};
bool cbottle[201] = {};
queue<pair<int,pair<int,int>>> q;

int bfs(){

q.push({0,{0,C}});
visited[0][0][C] = true;


while(q.empty() == 0){

    int a = q.front().first;
    int b = q.front().second.first;
    int c = q.front().second.second;
    if(a == 0){
        cbottle[c] = true;
    }
    
    q.pop();
    if(a!=0){
        if(B-b >= a && visited[0][b+a][c] ==0){
            q.push({0,{b+a,c}}); visited[0][b+a][c] = true;
        }
        else if(B-b < a && visited[a-(B-b)][B][c] == 0){
            q.push({a-(B-b),{B,c}}); visited[a-(B-b)][B][c] = true;
        }
        if(C-c >= a &&  visited[0][b][c+a] == 0){
            
            q.push({0,{b,c+a}}); visited[0][b][c+a] = true;
        }
        else if(C-c < a && visited[a-(C-c)][b][C]==0){
            q.push({a-(C-c),{b,C}}); visited[a-(C-c)][b][C] = true;
        }
    }
        if(b!=0){
            if(A-a >= b &&  visited[a+b][0][c]==0){
                q.push({a+b,{0,c}}); visited[a+b][0][c] = true;
            }
            else if(A-a < b &&visited[A][b-(A-a)][c]==0){
                q.push({A,{b-(A-a),c}}); visited[A][b-(A-a)][c] = true;
            }

            if(C-c >= b &&  visited[a][0][b+c]==0){
             
                q.push({a,{0,b+c}}); visited[a][0][b+c] = true;
            }
            else if(C-c < b && visited[a][b-(C-c)][C]==0){
                q.push({a,{b-(C-c),C}}); visited[a][b-(C-c)][C] = true;
            }
        }
        
        if(c!=0){
            if(A-a >= c &&  visited[a+c][b][0] ==0){
                q.push({a+c,{b,0}}); visited[a+c][b][0] = true;
            }
            else if(A-a < c && visited[A][b][c-(A-a)]==0){
                q.push({A,{b,c-(A-a)}}); visited[A][b][c-(A-a)] = true;
            }

            if(B-b >= c &&  visited[a][c+b][0] ==0){
                q.push({a,{c+b,0}}); visited[a][c+b][0] = true;
            }
            else if(B-b < c &&visited[a][B][c-(B-b)] ==0){
                q.push({a,{B,c-(B-b)}}); visited[a][B][c-(B-b)] = true;
            }   
    }
   
}
    return 0;
}

int main(){
   int cnt = 0;

    cin >> A >> B >> C;

    bfs();

    for(int i = 0; i < 201; i++){
        if(cbottle[i] != 0){
            cout << i << " ";
        }
    }

    return 0;
}
// 2021 - 08 - 08 solved
