#include <iostream>
#include <algorithm>


using namespace std;

int row, col, result = 64;
char table[52][52];

void init();
void solve();
int colorcheck(int, int);

void init() {

    cin >> row >> col;

    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            cin >> table[i][j];
        }
    }
}

void solve() {

    for (int i = 0; i <= row - 8; i++) {
        for (int j = 0; j <= col - 8; j++) {
            result = min(result, colorcheck(i,j));
        }
    }
}

int colorcheck(int cur_r, int cur_c) {
    //col row 더한후 짝수일때, 홀수일때 체크 보드판의 절반 이상인지 확인
    int oddchk = 0, evenchk = 0;
    int total;

    for (int k = cur_r; k < cur_r + 8; k++) {
        for (int l = cur_c; l < cur_c + 8; l++) {
            
            if ((k + l )% 2 == 0 && table[k][l] == 'W')  oddchk++;
            if((k + l) % 2 == 1 && table[k][l] == 'B')    evenchk++;
        }
    }
    total = oddchk + evenchk;

    return (total < 32 ? total : 64 - total);
}

int main(){

    init();
    solve();
    cout << result;
    return 0;
}//2021-12-26 solved
