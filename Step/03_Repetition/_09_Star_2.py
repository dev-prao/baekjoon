# 내가 작성한 코드
# inp = int(input())
#
# for i in range(1, inp + 1):
#     for j in range(1, inp - i + 1):
#         print(' ', end="")
#     print('*' * i)

# 구글링 코드
inp = int(input())
for i in range(1, (inp + 1)):
    print(" " * (inp - i), end="")
    print("*" * i)
