import sys
input = sys.stdin.readline

# INPUT
a, b = map(int, input().split())
field = [list(map(int, input().split())) for _ in range(a)]
visited = [[False] * b for _ in range(a)]

# VARIABLES
cnt = 0; max_v = 0

# BFS
movable = [(0, 1), (1, 0), (0, -1), (-1, 0)]

for i in range(a):
    for j in range(b):
        if field[i][j] == 1 and not visited[i][j]:
            tmp_v = 1
            cnt += 1
            visited[i][j] = True
            queue = [(i, j)]
            while queue:
                x, y = queue.pop()
                for dx, dy in movable:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < a and 0 <= ny < b and field[nx][ny] == 1 and not visited[nx][ny]:
                        queue.append((nx, ny))
                        tmp_v += 1
                        visited[nx][ny] = True
            max_v = max(max_v, tmp_v)

# OUTPUT
print(cnt)
print(max_v)