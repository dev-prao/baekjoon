N, M = map(int, input().split())
B = []
for i in range(0, N + 1):
    B.append(i)
for _ in range(M):
    i, j = map(int, input().split())
    B[i:j] = reversed(B[i:j])

print(*B[1:])
