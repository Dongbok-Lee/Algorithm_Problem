#include<iostream>
using namespace std;

int main(){
	int hour, min, plus;
	cin >> hour >> min;
	cin >> plus;
	min += plus;
	if(min>59){
		hour += min/60;
		min %= 60;
		if(hour>23){
			hour %= 24;
		}
	}
	cout << hour << " " << min;
}