#include<iostream>

using namespace std;

struct node {
	char left;
	char right;
};

struct node arr[27];

void preOrder(char root){
	if(root == '.')
		return;
	cout << root;
	preOrder(arr[root-'A'].left);
	preOrder(arr[root-'A'].right);
}

void inOrder(char root){
	if(root == '.')
		return;
	inOrder(arr[root-'A'].left);
	cout << root;	
	inOrder(arr[root-'A'].right);
}

void postOrder(char root){
	if(root == '.')
		return;
	postOrder(arr[root-'A'].left);
	postOrder(arr[root-'A'].right);
	cout << root;
}

int main(){
	int N;
	char dummy;

	cin >> N;

	for(int i = 0; i < N; i++){
		cin >> dummy >>  arr[dummy-'A'].left >> arr[dummy-'A'].right;
	}

	preOrder('A');
	cout << "\n";
	inOrder('A');
	cout << "\n";
	postOrder('A');
	return 0;
}