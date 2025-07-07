def stackDFS(graph, start):
    res = []
    
    visited = [False]*(len(graph)+1) # 방문 여부 리스트
    stack = [start] # 스택 : 시작 인덱스 삽입
    visited[start] = True # 시작 인덱스 방문 처리

    while stack:
        tmp = stack.pop()
        res.append(tmp)
        for i in graph[tmp]:
            if not visited[i]:
                visited[i] = True
                stack.append(i)

    return res

graph = [[], [2, 3], [4], [5, 6], [7], [8], [9, 10], [], [], [], []]

print(stackDFS(graph, 1)) # Output: [1, 3, 6, 10, 9, 5, 8, 2, 4, 7]