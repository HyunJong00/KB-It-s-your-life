""" 트리(노드) dfs 예시"""
# n,m = map(int,input().split())

# graph = {i: [] for i in range(1,n+1)}
# for i in range(m):
#     a,b = map(int, input().split())
#     graph[a].append(b)

# def dfs(graph, node, visited=None):
#     if visited is None:
#         visited = set()
#     visited.add(node)
#     print(node)
#     for neighbor in graph[node]:
#         if neighbor not in visited:
#             dfs(graph,neighbor,visited)
# dfs(graph,1)


""" 격자 그래프 예시"""
# grid = [[1,1,0],[1,0,0],[0,0,1]]
# visited = [[False] * 3 for _ in range(3)]
# directions = [(-1,0),(1,0),(0,-1),(0,1)]


# def dfs(row,col):
#     visited[row][col] = True
#     count =1
#     for dr,dc in directions:
#         next_row = row + dr
#         next_col = row + dc
#         if 0<=next_col<3 and 0<=next_row<3 and not visited[next_row][next_col] and grid[next_row][next_col]==1:
#             count+=dfs(next_row,next_col)
#     return count

# print(dfs(0,0))