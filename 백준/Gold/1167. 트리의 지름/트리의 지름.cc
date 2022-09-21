#include <iostream>
#include <vector>
#include<string.h>
#define MAX 100001 

using namespace std;

struct vert{
	int vert, dist;
};

vector<vert> graph[MAX];

int V;
int farthest_d = 0;
int farthest_v;
int visited[MAX] = {};
int distance_sum[MAX] = {};

int dfs(int z){
	
	visited[z] = 1;

	for(int i = 0; i < graph[z].size(); i++){

		int vt,dt;

		vt = graph[z][i].vert;
		dt =graph[z][i].dist;

		if(visited[vt] != 1){
			distance_sum[vt] = distance_sum[z] + dt; 

			if(distance_sum[vt] > farthest_d){
				farthest_d = distance_sum[vt];
				farthest_v = vt;
		}

		dfs(vt);
		}
	}
return 0;
}

int main(){

	cin >> V;

	for(int i = 0; i < V; i++){

		int x;
		cin >> x;
		while(1){

			int v, d;

			cin >> v;

			if(v == -1)
				break;

			cin >> d;

			graph[x].push_back({v,d});
		}
	}
	dfs(1);

	farthest_d = 0;
	memset(distance_sum, 0 , MAX*sizeof(int));
	memset(visited, 0, MAX*sizeof(int));

	dfs(farthest_v);

	cout << farthest_d;
	return 0;
}