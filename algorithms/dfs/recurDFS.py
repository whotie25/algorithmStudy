graph = [[], [2], [1, 3], [2 ,6, 7], [5], [4], [3, 7], [3, 6]]

res = []
visited = [False]*(len(graph)+1)

def recurDFS(graph, current):
    visited[current] = True
    res.append(current)

    for i in graph[current]:
        if not visited[i]:
            recurDFS(graph, i)

recurDFS(graph, 2)
print(res)