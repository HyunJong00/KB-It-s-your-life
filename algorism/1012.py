# 1. 배추밭 이중배열로 저장
# 2. 첫번째 입력으로 시작 / 막힌 경우 전체 순회하여 1 찾아서 다시 시작, count

import sys
# 파이썬 기본 재귀가 1000번 임
sys.setrecursionlimit(10000) 


direction = [(-1,0),(1,0),(0,1),(0,-1)]
T = int(input())

for _ in range(T):
    M,N,K = map(int,input().split())
    ground = [[0]*N for _ in range(M)]

    for i in range(K):
        x,y = map(int,input().split())
        ground[x][y] = 1

    def dfs (x,y):
        ground[x][y] = 0
        for dx,dy in direction:
            next_x = x+dx
            next_y = y+dy
            if 0<=next_x<M and 0<=next_y<N and ground[next_x][next_y]==1 :
                dfs(next_x,next_y)
    count=0
    for i in range(M):
        for j in range(N):
            if ground[i][j]==1:
                count+=1
                dfs(i,j)

    print(count)
