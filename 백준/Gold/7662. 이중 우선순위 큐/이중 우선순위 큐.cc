#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <cstring>
#include <functional>

using namespace std;

int T, k;
int qsize = 0;
bool visited[1000001] = { 0, };

void init();
void solve();
string chk_delete();

void init(){
	cin >> T;
	for (int i = 0; i < T; i++) {
			qsize = 0;
			cin >> k;
			solve();
	}
}

void solve() {
	memset(visited, false, 1000001);
	priority_queue<pair<int, int>,vector<pair<int,int>>> max_q;
	priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> min_q;
	

	char command;
	for (int j = 0; j < k; j++) {
		int tmp;

		cin >> command;

		switch (command)
		{
			case 'I':

				cin >> tmp;

				max_q.push(make_pair(tmp,j));
				min_q.push(make_pair(tmp,j));

				qsize++;
				break;
			case 'D':

				if(qsize)
					qsize--;

				if (chk_delete() == "max") {
					while (max_q.size() && visited[max_q.top().second]) {
						max_q.pop();
					}
					if (max_q.size()) {
						visited[max_q.top().second] = true;
						max_q.pop();
					}
				}
				else {
					while (min_q.size() && visited[min_q.top().second] ) {
						min_q.pop();
					}
					if (min_q.size()) {
						visited[min_q.top().second] = true;
						min_q.pop();
					}
				}
				break;
		}
	}

	while (min_q.size() && visited[min_q.top().second]) {
		min_q.pop();
	}
	while (max_q.size() && visited[max_q.top().second]) {
		max_q.pop();
	}

	if (qsize) {
		cout << max_q.top().first << ' ' << min_q.top().first << "\n";
	}
	else {
		cout << "EMPTY\n";
	}
}

string chk_delete(){
	int tmp;
	cin >> tmp;
	return (tmp > 0 ? "max" : "min");
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); 
	cout.tie(NULL);

	init();
	return 0;
}
