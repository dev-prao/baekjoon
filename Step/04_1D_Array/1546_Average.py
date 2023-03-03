# N = int(input())
# l = []
# for _ in range(N):
#     G = int(input())
#     l.append(G)
# M = max(l)
# for i in range(N):
#     l[i] = l[i] * 100 / max(l)
# print((sum(l))/N)

# 첫 번째 줄 입력 받기
n = int(input())

# 두 번째 줄 입력 받기
scores = list(map(int, input().split()))

# 세 번째 줄 입력 받기
max_score = max(scores)

# 점수 변환 후 평균 계산
new_scores = [(score / max_score) * 100 for score in scores]
new_avg = sum(new_scores) / n

# 새로운 평균 출력
print(new_avg)