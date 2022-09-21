import sys
N = int(input())
number = [0]*10001

for _ in range(N):
	number[int(sys.stdin.readline())]+=1

for num in range(10001):
	if number[num] != 0:
		for j in range(number[num]):
			print(num)