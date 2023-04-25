n = int(input())
a = list(map(int, input().split()))

# 리스트 a의 길이가 1 이하인 경우 예외 처리합니다.
if n <= 1:
    print(n)
else:
    # 가장 긴 증가하는 부분 수열을 계산합니다.
    d = [1] * n
    for i in range(1, n):
        for j in range(i):
            if a[i] > a[j]:
                d[i] = max(d[i], d[j] + 1)

    # 가장 긴 감소하는 부분 수열을 계산합니다.
    d2 = [1] * n
    for i in range(n-2, -1, -1):
        for j in range(n-1, i, -1):
            if a[i] > a[j]:
                d2[i] = max(d2[i], d2[j] + 1)

    # 가장 긴 바이토닉 부분 수열의 길이를 계산합니다.
    ans = 0
    for i in range(n):
        ans = max(ans, d[i] + d2[i] - 1)

    print(ans)
