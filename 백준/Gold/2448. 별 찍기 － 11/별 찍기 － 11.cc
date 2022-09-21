#include<iostream>

using namespace std;

int N;
char arr[3072][6143];

int star(int row, int col){
	arr[row][col] = '*';

	arr[row+1][col-1] = '*';
	arr[row+1][col+1] = '*';

	for(int i = col-2; i < col+3; i++) arr[row+2][i] = '*';
	return 0;
}

int triangle(int len, int row, int col){

	if(len == 3){
		star(row,col);
		return 0;
	}

	triangle(len/2,row,col);
	triangle(len/2,row+len/2,col-len/2);
	triangle(len/2,row+len/2,col+len/2);
	return 0;
}

int main(){
	cin >> N;

	for(int i = 0; i < N; i++) for(int j = 0; j < N*2-1; j++) arr[i][j] = ' ';

	triangle(N,0,N-1);

	for(int i = 0; i < N; i++){
		 for(int j = 0; j < N*2-1; j++) cout << arr[i][j];
		 cout << "\n";
	}
	return 0;
}