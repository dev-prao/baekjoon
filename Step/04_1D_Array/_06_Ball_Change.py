# 내가 작성한 코드
# n, m = map(int, input().split())
# for i in range(n):
#     box = [i] * n
# for _ in range(m):
#     i, j = map(int, input().split())
#     tmp = box[i]
#     box[i] = box[j]
#     box[j] = tmp
# for i in range(n):
#     print(box[i], end=' ')

# 구글링 코드
N, M = map(int, input().split())
l = []
for i in range(0, N + 1):
    l.append(i)
for j in range(M):
    A, B = map(int, input().split())
    l[A], l[B] = l[B], l[A]
print(*l[1:])
