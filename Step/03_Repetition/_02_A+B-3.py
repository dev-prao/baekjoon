# 내가 작성한 코드
# T = int(input())
# i = 0
# while i < T:
#     i = i + 1
#     A, B = map(int,input().split())
#     print(A+B)

# 구글링 코드
t = int(input())  # 테스트 케이스 개수 t를 입력받음

for _ in range(t):  # t 만큼 반복
    a, b = map(int, input().split())
    print(a + b)
