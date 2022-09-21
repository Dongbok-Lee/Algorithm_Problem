import sys
sys.setrecursionlimit(100000)
from collections import deque
k = int(input())
for _ in range(k):
    v,e = map(int,input().split())
    graph = [[] for i in range(v+1)]
    for i in range(e):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
    visited = [0]*(v+1)
    def dfs(graph, v, visited,color):
        visited[v] = 1 if color== 2 else 2
        color = visited[v]
        for i in graph[v]:
            if visited[i] == 0:
                dfs(graph, i, visited,color)
        return visited
    visited = dfs(graph,1,visited,2)
    for i in range(2,v+1): 
        if visited[i] == 0:
            visited = dfs(graph,i,visited,2) 
    def solve():
        for i in range(1,v+1):
            for j in graph[i]:
                if visited[i] == visited[j]: 
                    return 'NO'
        return 'YES'
    print(solve())