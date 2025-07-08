from collections import deque

# function definition
def shortestPath(graph:list, start:tuple, end:tuple) -> int:
    dir = ((0, 1), (1, 0), (0, -1), (-1, 0))
    reachable = False

    cnt = 0
    visited = [[False] * len(graph[0]) for _ in range(len(graph))]

    queue = deque()
    queue.append((start, 0))
    visited[start[0]][start[1]] = True

    while queue:
        (x, y), cnt = queue.popleft()
        if (x, y) == end: # start = end ?
            reachable = True
            return cnt
            
        for dx, dy in dir:
            nx, ny = x + dx, y + dy
            if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]) and not visited[nx][ny] and graph[nx][ny] != 1:
                visited[nx][ny] = True
                queue.append(((nx, ny), cnt + 1))
            if (nx, ny) == end and visited[nx][ny]:
                reachable = True
                return cnt + 1
    if not reachable:
        return -1

# test case
graph = [[0, 0, 0, 0, 1, 0, 0, 1],
         [0, 1, 1, 0, 1, 1, 0, 1],
         [0, 1, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 1, 1, 1, 1, 0],
         [1, 1, 0, 0, 1, 0, 0, 0],
         [0, 1, 0, 0, 0, 0, 1, 1],
         [0, 0, 0, 1, 0, 0, 0, 0],
         [1, 0, 1, 1, 0, 1, 1, 0]]
start = (0, 5); end = (5, 0)

min_distance = shortestPath(graph, start, end)
print(min_distance)