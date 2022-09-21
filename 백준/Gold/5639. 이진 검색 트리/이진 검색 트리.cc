#include<iostream>
#include<algorithm>

using namespace std;

void init();
void solve();
void recursion(int, int);

unsigned int arr[10001]; unsigned int index = 0;

void init() {
	while (1) {
		if (scanf("%u", &arr[index]) == EOF) { break;  }
		index++;
	}
}

void solve() {
	recursion(0, index-1);
}

void recursion(int start, int finish) {
	int left = start + 1, right = start + 1;
	//cout << i << " " << finish << "\n";
	while (right <= finish ) {
		if (arr[right] > arr[start]) {
			break;
		}
		right++;
	}

	//왼쪽
	if (left + 1 == right)
		cout <<  arr[left] << "\n";
	else if(left < right)
		recursion(left, right-1);
		

	//오른쪽
	if (right == finish)
		cout << arr[right] << "\n";
	else if(right < finish)
		recursion(right, finish);
		

	//루트
	cout << arr[start] << "\n";
}

int main() {
	init();
	solve();
	return 0;
}