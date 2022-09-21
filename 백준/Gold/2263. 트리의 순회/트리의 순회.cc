#include <iostream>

using namespace std;

int N;
int inorder[100001];
int postorder[100001];
int index[100001];

void init();
void solve();
void recursion(int ,int ,int ,int);

void init() {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> inorder[i];
		index[inorder[i]] = i;
	}

	for (int i = 1; i <= N; i++) {
		cin >> postorder[i];
	}
}

void solve() {
	recursion(1, N, 1, N);
}

void recursion(int inStart, int inEnd, int postStart, int postEnd) {
	if (inStart > inEnd || postStart > postEnd)
		return;

	int cur_root = index[postorder[postEnd]];
	int left_size = cur_root - inStart;
	int right_size = inEnd - cur_root;

	cout << postorder[postEnd] << " ";

	recursion(inStart, cur_root - 1, postStart, postStart + left_size - 1);
	recursion(cur_root + 1, inEnd, postStart + left_size, postEnd - 1);
}

int main() {
	init();
	solve();

	return 0;
}