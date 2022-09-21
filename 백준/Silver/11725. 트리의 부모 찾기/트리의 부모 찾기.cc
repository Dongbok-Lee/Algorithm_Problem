#include <iostream>
#include <vector>
#define MAX 100001 

using namespace std;
int N;
int parents[MAX] = {};
vector<int> tree[MAX];



void dfs(int v){
	while(!tree[v].empty()){
		int x = tree[v].back();
		tree[v].pop_back();
		if(x != 1 &&parents[x] == 0){
			parents[x] = v; 
			dfs(x);
		}
	}
	return;
}

int main(){
	int x, y;
	cin >> N;
	for(int i = 0; i < N-1; i++){
		cin >> x >> y;
	tree[x].push_back(y);
	tree[y].push_back(x);
	}
	dfs(1);

	for(int j = 2; j <= N; j++){
		cout << parents[j] << "\n";
	}
	return 0;
}