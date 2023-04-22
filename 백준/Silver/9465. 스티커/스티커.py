t = int(input())
for _ in range(t):
    n = int(input())
    line_0 = [0] + list(map(int, input().split()))
    line_1 = [0] + list(map(int, input().split()))
    a = list(zip(line_0, line_1))
    d = [[0] * 3 for _ in range(100001)]  # 0: 선택 0, 1: 1개 선택(위), 2: 1개 선택(아래)
    for i in range(1, n + 1):
        d[i][0] += max(d[i - 1])
        d[i][1] += max(d[i - 1][0], d[i - 1][2]) + a[i][0]
        d[i][2] += max(d[i - 1][0], d[i - 1][1]) + a[i][1]
    ans = max(d[n])
    print(ans)