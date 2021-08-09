#include <iostream>
#include <queue>
#include <vector>
#include <set>
#include <string>

using namespace std;

set<string> visited;
queue<pair<string,int>> q;
string table;

bool isinside(int x, int y){
    return (0 <= x && 0 <= y && x < 3 && y < 3);
}

int result = 0;
int xx[4] = { -1, 0, 1, 0};
int yy[4] = {  0, 1,  0, -1};

int bfs(){

    pair<string,int> a;

    q.push({table,0});
    

    while(q.empty() == 0){
            
            a = q.front();
            visited.insert(a.first);
            q.pop(); 
            if(a.first == "123456780"){
                return a.second;
            }
            int findz = a.first.find("0");
            int x = findz /3;
            int y = findz %3;

            for(int i = 0; i < 4; i++){

                string temps;
                temps = a.first;

                if(isinside(x+xx[i],y+yy[i])){

                   char tmp = temps[(x+xx[i])*3+(y+yy[i])%3];

                   temps[(x+xx[i])*3+(y+yy[i])%3] = temps[x*3+y%3];
                   temps[x*3+y%3] = tmp;
                    if(visited.find(temps) == visited.end())
                        q.push({temps,a.second+1});
                }
            }
    }
    return -1;
}
 
int main(){

    for(int i = 0; i < 9; i++){
        char a;
        cin >> a;
        table = table + a;
    }

    cout << bfs();
}

//2021.08.09 solved
