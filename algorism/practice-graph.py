
# def dfs(graph, node, visited):
#     if visited is None:
#         visited = set() # 방문한 노드를 저장하는 집합
#         visited.add(node) # 현재 노드를 방문한 것으로 표시
#         print(node, end=' ') # 방문한 노드를 출력
#         for neighbor in graph[node]:
#             if neighbor not in visited:
#                 dfs(graph, neighbor, visited)

# graph = {
#     "민수": ["지수", "철수"],
#     "지수": ["민수", "영희"],
#     "철수": ["민수", "동현"],
#     "영희": ["지수"],
#     "동현": ["철수"]
# }
# def dfs(graph, node, visited=None):
#     if visited is None:
#         visited=set()
#     visited.add(node)
#     print(node)
#     for neighbor in graph[node]:
#         if neighbor not in visited:
#             dfs(graph,neighbor,visited)

# dfs(graph, "민수")

# input
# 1 2
# 1 3
# 2 4
# 2 5
# 3 6
n,m = map(int,input().split())

graph = {i: [] for i in range(1,n+1)}
for i in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)

def dfs(graph, node, visited=None):
    if visited is None:
        visited = set()
    visited.add(node)
    print(node)
    for neighbor in graph[node]:
        if neighbor not in visited:
            dfs(graph,neighbor,visited)
dfs(graph,1)
