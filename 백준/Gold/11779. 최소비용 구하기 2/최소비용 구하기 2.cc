#include<iostream>
#include<vector>
#include<queue>

using namespace std;

void init();
void solve();

int N, M;
int Start, End;
int Dist[1010];
int Route[1010];
vector<pair<int ,int>> V[1010];
vector<int> Route_V;
void init() {
	cin >> N >> M;
	for (int i = 1; i <= N; i++)
		Dist[i] = 2100000000;
	for (int i = 0; i < M; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		V[a].push_back(make_pair(b, c));
	}
	cin >> Start >> End;
}

void solve() {
	priority_queue<pair<int, int>> PQ;
	PQ.push(make_pair(0, Start));
	Dist[Start] = 0;

	while (!PQ.empty()) {
		int Cost = -PQ.top().first;
		int Cur = PQ.top().second;
		PQ.pop();

		if (Cost > Dist[Cur])
			continue;
        
		for (int i = 0; i < V[Cur].size(); i++) {
			int Next = V[Cur][i].first;
			int nCost = V[Cur][i].second;

			if (Dist[Next] > Cost + nCost) {
				Route[Next] = Cur;
				Dist[Next] = Cost + nCost;
				PQ.push({ -Dist[Next], Next });
			}
		}
	}

	cout << Dist[End] << "\n";
	int Temp = End;
	while (Temp) {
		Route_V.push_back(Temp);
		Temp = Route[Temp];
	}

	cout << Route_V.size() << "\n";

	for (int i = Route_V.size()-1; i >= 0; i--) {
		cout << Route_V[i] << " ";
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	init();
	solve();
	return 0;
}