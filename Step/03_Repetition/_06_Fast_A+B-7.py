# 내가 작성한 코드
# T = int(input())
# for i in range(T):
#     A, B = map(int, input().split())
#     print("Case #%d: %d" % (i + 1, A + B))

# 구글링 코드
t = int(input())

for i in range(1, t+1):  # 1부터 t까지
    a, b = map(int, input().split())
    print(f'Case #{i}: {a+b}')