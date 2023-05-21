n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]
ans = 0
for i in range(n):
    for j in range(m):
        # 1
        if j + 3 < m:
            temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i][j + 3]
            if ans < temp: ans = temp
        # 2
        if i + 3 < n:
            temp = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 3][j]
            if ans < temp: ans = temp
        # 3
        if i + 1 < n and j + 1 < m:
            temp = a[i][j] + a[i + 1][j] + a[i][j + 1] + a[i + 1][j + 1]
            if ans < temp: ans = temp
        # 4
        if i + 2 < n and j + 1 < m:
            temp = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i][j + 1]
            if ans < temp: ans = temp
        # 5
        if i + 2 < n and j + 1 < m:
            temp = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 1][j + 1]
            if ans < temp: ans = temp
        # 6
        if i + 2 < n and j + 1 < m:
            temp = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 2][j + 1]
            if ans < temp: ans = temp
        # 7
        if i + 2 < n and j - 1 >= 0:
            temp = a[i][j - 1] + a[i][j] + a[i + 1][j] + a[i + 2][j]
            if ans < temp: ans = temp
        # 8
        if i + 2 < n and j - 1 >= 0:
            temp = a[i + 1][j - 1] + a[i][j] + a[i + 1][j] + a[i + 2][j]
            if ans < temp: ans = temp
        # 9
        if i + 2 < n and j - 1 >= 0:
            temp = a[i + 2][j - 1] + a[i][j] + a[i + 1][j] + a[i + 2][j]
            if ans < temp: ans = temp
        # 10
        if i + 1 < n and j + 2 < m:
            temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j]
            if ans < temp: ans = temp
        # 11
        if i + 1 < n and j + 2 < m:
            temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 1]
            if ans < temp: ans = temp
        # 12
        if i + 1 < n and j + 2 < m:
            temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 2]
            if ans < temp: ans = temp
        # 13
        if i - 1 >= 0 and j + 2 < m:
            temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i - 1][j]
            if ans < temp: ans = temp
        # 14
        if i - 1 >= 0 and j + 2 < m:
            temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i - 1][j + 1]
            if ans < temp: ans = temp
        # 15
        if i - 1 >= 0 and j + 2 < m:
            temp = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i - 1][j + 2]
            if ans < temp: ans = temp
        # 16
        if i + 1 < n and j + 2 < m:
            temp = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 1][j + 2]
            if ans < temp: ans = temp
        # 17
        if i - 1 >= 0 and j + 2 < m:
            temp = a[i][j] + a[i][j + 1] + a[i - 1][j + 1] + a[i - 1][j + 2]
            if ans < temp: ans = temp
        # 18
        if i + 2 < n and j + 1 < m:
            temp = a[i][j] + a[i + 1][j] + a[i + 1][j + 1] + a[i + 2][j + 1]
            if ans < temp: ans = temp
        # 19
        if i + 2 < n and j - 1 < m:
            temp = a[i][j] + a[i + 1][j - 1] + a[i + 1][j] + a[i + 2][j - 1]
            if ans < temp: ans = temp
print(ans)
