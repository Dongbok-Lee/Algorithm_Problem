import sys
N = int(input())
nums = []

for i in range(0,N):
    [a,b] = map(int,sys.stdin.readline().split())
    nums.append([a,b])    

sorted_array = sorted(nums)

for i in range(0,N):
    print(sorted_array[i][0], sorted_array[i][1])
