n = int(input())
m = int(input())
graph = {i:[] for i in range(1,n+1)}
for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
print(graph)
def dfs(graph,node, visited=None):
    if visited is None:
        visited=set()
    visited.add(node)
    for neighbor in graph[node]:
        if neighbor not in visited:
            dfs(graph,neighbor,visited)
    return visited

visited = dfs(graph,1)
visited.remove(1)
print(len(visited))