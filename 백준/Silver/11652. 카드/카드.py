import sys
N = int(input())
dict = {}

for _ in range(N):
	tmp = int(input())
	if tmp in dict:
		dict[tmp] += 1
	else:
		dict[tmp] = 1
dict = sorted(dict.items(), key = lambda x : (-x[1],x[0]))
print(dict[0][0])