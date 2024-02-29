import sys


def dfs(start, next, value, visited):
    global min_value

    if len(visited) == N:
        if travel[next][start] != 0:
            min_value = min(min_value, value + travel[next][start])
        return

    for i in range(N):
        if travel[next][i] != 0 and i != start and i not in visited and min_value > value + travel[next][start]:
            visited.append(i)
            dfs(start, i, value + travel[next][i], visited)
            visited.pop()


if __name__ == "__main__":

    N = int(input())
    travel = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(N)]

    min_value = sys.maxsize

    for i in range(N):
        dfs(i, i, 0, [i])

    print(min_value)