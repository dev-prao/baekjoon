# 입력받은 숫자의 개수 N
N = int(input())

# 입력받은 숫자 N개를 문자열로 저장
num = input()

# 숫자 N개의 합을 저장할 변수
sum = 0

# 문자열의 각 자리를 숫자로 변환하고 합에 더함
for digit in num:
    sum += int(digit)

# 숫자 N개의 합을 출력
print(sum)
