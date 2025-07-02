def pythonBFS(graph, start):
    res = []

    visited = [False]*(len(graph)+1)
    queue = [start]
    visited[start] = True

    while queue:
        tmp = queue.pop(0)
        res.append(tmp)
        for i in graph[tmp]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)

    return res

graph = [[], [2, 3], [6], [4, 5], [6], [4, 7], [7], []]

print(pythonBFS(graph, 1))  # Output: [1, 2, 3, 6, 4, 5, 7]