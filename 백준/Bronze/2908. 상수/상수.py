a, b = input().split()  # 입력받기
a = int(a[::-1])  # a를 거꾸로 뒤집기
b = int(b[::-1])  # b를 거꾸로 뒤집기

if a > b:
    print(a)
else:
    print(b)
