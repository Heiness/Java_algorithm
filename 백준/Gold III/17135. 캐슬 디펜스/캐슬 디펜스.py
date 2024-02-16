#https://velog.io/@nkrang/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-17135-%EC%BA%90%EC%8A%AC-%EB%94%94%ED%8E%9C%EC%8A%A4-%ED%92%80%EC%9D%B4-%ED%8C%8C%EC%9D%B4%EC%8D%AC 참조
from itertools import combinations
from collections import deque
import sys; input = sys.stdin.readline

N, M, D = map(int,input().split())
graph = [ list(map(int,input().split())) for _ in range(N) ]

archers = list(combinations([ _ for _ in range(M)],3)) 
answer = 0

dy = [0,-1,0]
dx = [-1,0,1]

def kill_enemies(a):
    temp_matrix = [x[:] for x in graph]
    killed = [[0] * M for _ in range(N)]
    result = 0
    
    for i in range(N-1,-1,-1):
        this_turn = []
        for ax in a: # 한 궁수씩 처리
            q = deque([(i,ax,1)])
            while q:
                y, x, d = q.popleft()
                if temp_matrix[y][x] == 1:
                    # temp_matrix[y][x]=0 # 동시에 궁수들이 같은 적을 공격할 수 있음. 따라서 제거 X
                    this_turn.append((y,x))
                    if killed[y][x]==0:
                        killed[y][x]=1
                        result+=1
                    break
                if d < D:
                    for di in range(3):
                        ny = y + dy[di]
                        nx = x + dx[di]
                        if 0<=ny<N and 0<=nx<M:
                            q.append((ny,nx,d+1))
        for y, x in this_turn:
            temp_matrix[y][x]=0
    
    return result

for a in archers:
    answer = max(answer,kill_enemies(a))

print(answer)
