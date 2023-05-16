n, m = map(int, input().split())
buckets = [i for i in range(1, n + 1)]
for _ in range(m):
    i, j, k = map(int, input().split())
    i, j, k = i - 1, j - 1, k - 1
    buckets = buckets[:i] + buckets[k:j + 1] + buckets[i:k] + buckets[j + 1:]

print(*buckets)