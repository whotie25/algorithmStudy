def basicBFS(graph, start):
    res = []

    visited = [False]*(len(graph)+1) # 방문 여부 리스트
    queue = [start] # 큐 : 시작 인덱스 삽입
    visited[start] = True # 시작 인덱스 방문 처리

    while queue:
        tmp = queue.pop(0)
        res.append(tmp)
        for i in graph[tmp]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)

    return res

graph = [[], [2, 3], [6], [4, 5], [6], [4, 7], [7], []]

print(basicBFS(graph, 1)) # Output: [1, 2, 3, 6, 4, 5, 7]