#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <queue>
using namespace std;
int t;
int n, k, d, w;
int Time[1001];
int total_time[1001];
int entry[1001];
vector<int> build[1001];

void init();
void solve();

void init() {
    memset(Time, 0, sizeof(Time));
    memset(total_time, 0, sizeof(total_time));
    memset(entry, 0, sizeof(entry));
    for (int i = 0; i < 1001; i++) build[i].clear();

    cin >> n >> k;

    for (int i = 1; i <= n; i++)
        cin >> Time[i];

    for (int i = 0; i < k; i++) {
        int a, b;
        cin >> a >> b;
        build[a].push_back(b);
        entry[b]++;
    }
    cin >> w;
}

void solve() {
    queue<int> q;
    for (int i = 1; i <= n; i++) {
        if (entry[i] == 0) {
            q.push(i);
            total_time[i] = Time[i];
        }
    }

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int i = 0; i < build[cur].size(); i++) {
            int next = build[cur][i];
            total_time[next] = max(total_time[next], total_time[cur] + Time[next]);
            entry[next]--;

            if (entry[next] == 0)
                q.push(next);
        }
    }
    cout << total_time[w] << "\n";
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    cin >> t;

    for (int T = 0; T < t; T++) {
        init();
        solve();
    }

	return 0;
}