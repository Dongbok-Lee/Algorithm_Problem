import sys
 
def dfs(v):
  visit[v] = 1
  for i in range(1, N+1):
    if visit[i] == 0 and arr[v][i] == 1:
      dfs(i)
 
count = 0
N,M = map(int,sys.stdin.readline().split())
visit = [0 for i in range(N+1)]
arr = [[0]*(N+1) for i in range(N+1)]
for i in range(M):
  a,b = map(int,input().split())
  arr[a][b] = arr[b][a] = 1
 
for i in range(1,N+1):
  if visit[i] == 0:
    dfs(i)
    count += 1
print(count)