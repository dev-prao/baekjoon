#
# N = int(input())
# # 26(8) -> 68(14) -> 84(12) -> 42(6) -> 26
# M = N // 10 + N % 10
# Next_N = (N % 10) * 10 + M % 10
# Next_M = Next_N // 10 + Next_N % 10
# NNext_N = (Next_N % 10) * 10 + Next_M % 10
# count = 0
#
# while True:
#     Next_N == NNext_N
#     M == Next_M
#     if N != Next_N:
#         count += 1
#     else:
#         print(count)
#         break

# 구글링 코드(정수)
# n = int(input())        # 68
# num = n
# cnt = 0                 # 사이클 수
#
# while True:             # while 1이랑 동일
#     a = num // 10       # 6
#     b = num % 10        # 8
#     c = (a + b) % 10    # 6 + 8 = 1"4"
#     num = (b * 10) + c  # 80 + 4 = 84
#
#     cnt = cnt + 1
#     if(num == n):
#         break
#
# print(cnt)

# 구글링 코드(문자열)
n = input()
num = n
cnt = 0

while 1:
    if len(num) == 1:
        num = "0" + num
    plus = str(int(num[0]) + int(num[1]))
    num = num[-1] + plus[-1]
    cnt += 1
    if num == n:
        print(cnt)
        break