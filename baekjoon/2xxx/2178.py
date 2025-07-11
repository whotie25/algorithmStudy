# 2178. 미로 탐색

# IMPORTATION
from sys import stdin
input = stdin.readline
from collections import deque

# INPUT
n, m = map(int, input().split())

# GRAPH REPRESENTATION
graph = [[] for _ in range(n)]
for i in range(n):
    tmp = (input().split())[0]
    for j in tmp:
        graph[i].append(int(j))

# SHORTEST PATH
dir = ((0, 1), (1, 0), (0, -1), (-1, 0))
visited = [[False] * m for _ in range(n)]

queue = deque()
queue.append(((0, 0), 1))
graph[0][0] = True

while queue:
    (x, y), cnt = (queue.popleft())
    if (x, y) == (n-1, m-1):
        break

    for dx, dy in dir:
        nx, ny = x + dx, y + dy
        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1 and not visited[nx][ny]:
            visited[nx][ny] = True
            queue.append(((nx, ny), cnt+1))

        if (nx, ny) == (n-1, m-1) and visited[nx][ny]:
            cnt += 1
            break

# OUTPUT
print(cnt)