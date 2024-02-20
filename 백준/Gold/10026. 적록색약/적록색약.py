import sys; input = sys.stdin.readline
from collections import deque

dy = [0,0,-1,1]
dx = [-1,1,0,0]

n = int(input())
graph = [ list(input().strip()) for _ in range(n) ]

def bfs(y, x, cl, color):
    if cl and color in ['R', 'G']:
        T = ['R', 'G']
    else:
        T = [color]

    q = deque()
    q.append((y,x))
    visited[y][x]==1

    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0<=ny<n and 0<=nx<n and visited[ny][nx]==0 and graph[ny][nx] in T:
                visited[ny][nx]=1
                q.append((ny,nx))
                
#정상
ans = []
for k in range(2):
    t = 0
    visited = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j]==0:
                bfs(i,j,k,graph[i][j])
                t+=1
    else:
        ans.append(t)

print(*ans)
