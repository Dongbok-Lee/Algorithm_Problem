#include <iostream>
#include <string>

using namespace std;

string str;
int num[10] = {};
int sum = 0;
int main(){

    cin >> str;

    int len = str.length();

    for(int i = 0; i < len; i++){
        num[str[i]-48] ++;
    }


    for(int i = 9; i > 0; i--) sum += num[i]*i;
    if(num[0] != 0 && sum%3 == 0){
        for(int i = 9; i >= 0; i--) for(int j = 0; j < num[i]; j++) cout << i;
    }
    else{
        cout << "-1";
    }
}