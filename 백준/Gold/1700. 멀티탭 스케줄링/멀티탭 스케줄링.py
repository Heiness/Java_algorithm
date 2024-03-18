import sys; input = sys.stdin.readline
from collections import deque

def decrease_index(x):
    for i in x:
        i[1]-=1


def add_MP(tmp, MP):
    if tmp in ord:
        MP.append([tmp, ord.index(tmp)])
    else:
        MP.append([tmp, 101])

n, k = map(int,input().split())
ord = deque([ *map(int,input().split()) ])
MP = []

# 멀티탭에 미존재시 가장 멀리 있는 값 빼기

cnt = 0

while ord:
    tmp = ord.popleft()
    flag = True
    
    for i in MP: # 같은 값 존재시 index만 변경
        if i[0] == tmp:
            decrease_index(MP)
            if tmp in ord:
                i[1] = ord.index(tmp)
                flag = False
            else:
                i[1] = 101
                flag = False
            MP.sort(key=lambda x: x[1])
            break
            
    
    if not flag: continue

    if len(MP)<n: # 멀티탭이 채워지지 않았을 시
        decrease_index(MP)
        add_MP(tmp, MP)
        # if tmp in ord:
        #     MP.append([tmp, ord.index(tmp)])
        # else:
        #     MP.append([tmp, 101])
        
    else: # 채워져서 빼는 경우
        decrease_index(MP)
        MP.pop()
        add_MP(tmp, MP)
        # if tmp in ord:
        #     MP.append([tmp, ord.index(tmp)])
        # else:
        #     MP.append([tmp, 101])
        cnt+=1
    
    MP.sort(key=lambda x: x[1])
print(cnt)