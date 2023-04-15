n = int(input())  # 카드 묶음의 개수 입력
a = [0] + list(map(int, input().split()))
# 카드 묶음 가격 리스트 생성, 인덱스를 맞추기 위해 0을 추가

d = [0] * (n + 1)  # 동적 계획법을 위한 리스트 초기화

# 최대 이익 계산
for i in range(1, n + 1):
    for j in range(1, i + 1):
        d[i] = max(d[i], d[i - j] + a[j])

print(d[n])  # 최대 이익 출력