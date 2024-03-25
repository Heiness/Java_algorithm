import sys
input = sys.stdin.readline

N = int(input())
K = int(input())
pan = [[0 for i in range(N+2)] for j in range(N+2)]

for i in range(N+2):
    pan[0][i] = 2
    pan[N+1][i] = 2
    pan[i][0] = 2
    pan[i][N+1] = 2

for i in range(K):
    a, b = map(int, input().split())
    pan[a][b] = 1 # 1은 사과

L = int(input())
drc = {}

for i in range(L):
    X, C = input().split()
    X = int(X)
    C = str(C)
    drc[X] = C

rst = 0

def go(direction, x, y):
    px, py = x, y
    if direction == 0: # r
        y += 1
    elif direction == 1: # d
        x += 1
    elif direction == 2: # l
        y -= 1
    elif direction == 3: # u
        x -= 1
    return x, y, px, py

def solution(p):
    x = 1
    y = 1
    s = 1
    cnt = 0
    result = 0
    length = 1
    direction = 0
    m = []
    n = []
    k = 0
    for i in drc.keys():
        for j in range(s, i+1):
            x, y, px, py = go(direction, x, y)
            if p[x][y] == 2 or p[x][y] == 3:
                result = 1
                return j
            elif p[x][y] == 1: #사과
                p[x][y] = 0
                p[px][py] = 3
                m.append(px)
                n.append(py)
                length += 1
            elif p[x][y] == 0 and length > 1:
                p[px][py] = 3
                p[m[k]][n[k]] = 0
                m.append(px)
                n.append(py)
                k += 1

        c = drc[i]
        if c == 'D':
            direction = (direction + 1) % 4
        elif c == 'L':
            direction = (direction + 3) % 4
        s = i + 1

    if result == 0:
        while p[x][y] != 2 and p[x][y] != 3:
            x, y, px, py = go(direction, x, y)
            cnt += 1
        return X + cnt

rst = solution(pan)
print(rst)