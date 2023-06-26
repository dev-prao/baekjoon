import sys

input = sys.stdin.readline


def factorial(n):
    if n == 1 or n == 0:
        return 1
    result = n * factorial(n - 1)
    return result


n, k = map(int, input().split())
print(factorial(n) // (factorial(k) * factorial(n - k)))
