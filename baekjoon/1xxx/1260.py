# 1260. DFS와 BFS

# IMPORTATION
import sys
input = sys.stdin.readline

# INPUT
v, e, s = map(int, input().split())

# GRAPH REPRESENTATION
graph = [[] for _ in range(v+1)]
for _ in range(e):
    idx, val = map(int, input().split())
    graph[idx].append(val)
    graph[val].append(idx)
for i in range(1, v+1):
    graph[i].sort()

# DFS (recursive)
def recurDFS(cur):
    visited[cur] = True
    res_DFS.append(cur)

    for i in graph[cur]:
        if not visited[i]:
            recurDFS(i)

res_DFS = []
visited = [False] * (v+1)
recurDFS(s)


# BFS
res_BFS = []
visited = [False] * (v+1)
memory = [s]; visited[s] = True

while memory:
    tmp = memory.pop(0)
    res_BFS.append(tmp)
    for i in graph[tmp]:
        if not visited[i]:
            visited[i] = True
            memory.append(i)

# OUTPUT
for num in res_DFS: print(num, end=' ')
print('')
for num in res_BFS: print(num, end=' ')