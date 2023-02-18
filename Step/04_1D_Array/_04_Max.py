# 내가 작성한 코드
# cnt = 1
#
# for i in range(9):
#     i += 1
#     a = list(map(int, input()))
#     cnt += 1
#
# print(max(a))
# print(cnt)

# 구글링 코드
numbers = []
for _ in range(9):
    i = int(input())
    numbers.append(i)

print(max(numbers))
print(numbers.index(max(numbers))+1)