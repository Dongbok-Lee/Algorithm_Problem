#include <iostream>
using namespace std;

int dfs(int v,int* visit,int* cycle){
	visit[v] = 1;
	if(visit[cycle[v]] == 0){
		dfs(cycle[v],visit,cycle);
	}
	return 0;
}

int main() {
	int Tcase, N, num;
	cin >> Tcase;
	for(int j = 0; j < Tcase; j++){
		cin >> N;
		int count = 0;
		int visit[N+1],cycle[N+1];
		for(int i = 1; i <= N; i++){
			cin >> num;
			cycle[i] = num;
			visit[i] = 0;
		}
		for(int k = 1; k <= N; k++){
			if(visit[k] == 0){
				count++;
				dfs(k,visit,cycle);
			}
		}
		cout << count << endl;
	}
	return 0;
}