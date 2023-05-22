import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    M, N, x, y = map(int, input().split())
    x -= 1
    y -= 1
    k = x
    while k < N * M:
        if k % N == y:
            print(k + 1)
            break
        k += M
    else:
        print(-1)