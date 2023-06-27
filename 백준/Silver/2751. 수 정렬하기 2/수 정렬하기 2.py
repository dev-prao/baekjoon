import sys
input = sys.stdin.readline
n = int(input())
arr = [0] * n
for i in range(n):
    num = int(input())
    arr[i] = num
arr.sort()
for i in range(n):
    print(arr[i])