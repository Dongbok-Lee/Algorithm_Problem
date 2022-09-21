#include <iostream>
using namespace std;

int hor = 1, ver = 1;
int landnum;
int land[51][51]= {};
int visited[51][51] = {};

int dfs(int v, int h){
	visited[v][h] = 1;
	for(int i = -1; i < 2; i++){
		for(int j = -1; j < 2; j++){
			if(v+i > -1 && h+j > -1 && v+i < ver && h+j < hor){
				if(land[v+i][h+j] == 1 && visited[v+i][h+j] == 0){
				dfs(v+i,h+j);
				}
			}
		}
	}
	return 0;
}

int main() {
	while(hor != 0 && ver != 0){
		cin >> hor >> ver;
		for(int i = 0; i < ver; i++){
			for(int j = 0; j < hor; j++){
				cin >> land[i][j];
			}
		}
		for(int i = 0; i < ver; i++){
			for(int j = 0; j < hor; j++){
				if(land[i][j] == 1 && visited[i][j] == 0){
				landnum++;
				dfs(i,j);
				}
			}
		}
		if(hor != 0)
		cout << landnum <<"\n";
		landnum = 0;
		for(int i = 0; i < ver; i++){
			for(int j = 0; j < hor; j++){
				land[i][j] = 0;
				visited[i][j] = 0;
			}
		}
	}
	return 0;
}
