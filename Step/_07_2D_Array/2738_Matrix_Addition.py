# 행렬의 크기 입력받기
N, M = map(int, input().split())

# 행렬 A 입력받기
A = [list(map(int, input().split())) for _ in range(N)]

# 행렬 B 입력받기
B = [list(map(int, input().split())) for _ in range(N)]

# 두 행렬의 합 계산하기
result = [[0] * M for _ in range(N)]  # 결과를 저장할 2차원 리스트 초기화
for i in range(N):
    for j in range(M):
        result[i][j] = A[i][j] + B[i][j]

# 결과 출력하기
for row in result:
    print(*row)