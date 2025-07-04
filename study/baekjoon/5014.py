from collections import deque

# INPUT
f, s, g, u, d = map(int, input().split())

# BFS
direction = [u, -d]
visited = [False]*(f+1); visited[0] = True

queue = deque()
queue.append((s, 0))
visited[s] = True

res = -1; cnt = 0
while queue:
    (tmp, cnt) = queue.popleft()
    if tmp == g:
        res = cnt
        break

    for i in direction:
        n_tmp = tmp + i
        if 0 < n_tmp <= f and not visited[n_tmp]:
            visited[n_tmp] = True
            queue.append((n_tmp, cnt + 1))

            if n_tmp == g:
                res = cnt + 1
                break

# OUTPUT
if res != -1:
    print(res)
else:
    print("use the stairs")