import sys
N = int(input())
nums = []

for i in range(0,N):
    [a,b] = map(str,sys.stdin.readline().split())
    a = int(a)
    nums.append([a,b])    

nums.sort(key= lambda member: (member[0]))

for i in range(0,N):
    print(nums[i][0], nums[i][1])