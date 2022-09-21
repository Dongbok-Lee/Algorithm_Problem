import sys
N = int(input())
nums = []

for i in range(0,N):
    [a,b,c,d] = map(str,sys.stdin.readline().split())
    nums.append([a,b,c,d])    

nums.sort(key = lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in range(0,N):
    print(nums[i][0])