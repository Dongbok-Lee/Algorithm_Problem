#include <iostream>
#include <cmath>
#define MAX 300001
using namespace std;
int graph[MAX];

void dfs(int num, int P, int* graph){
	int sum = 0;
	
	graph[num]++;
	
	while(num){
		sum += pow(num%10,P);
		num /= 10;
	}
	
	if(graph[sum] == 3)
		return;
		

	dfs(sum,P,graph);
	return;
}

int main() {

	int A, P, count = 0;
	cin >> A >> P;
	
	dfs(A,P,graph);
	
	for(int i = 0; i < MAX; i++){
		if(graph[i] == 1)
			count++;
	}
	cout << count;
	return 0;
}