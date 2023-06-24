import sys
input = sys.stdin.readline

n = int(input())
n_list = [0] * 10001

for _ in range(n):
    n_list[int(input())] += 1

for i in range(10001):
    if n_list[i] != 0:
        for j in range(n_list[i]):
            print(i)