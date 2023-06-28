import sys
input = sys.stdin.readline

while True:
    num = input().rstrip()
    if num == "0":
        break

    is_palindrome = True
    for i in range(len(num)//2):
        if num[i] != num[len(num) - i - 1]:
            is_palindrome = False
            break
            
    if is_palindrome:
        print("yes")
    else:
        print("no")