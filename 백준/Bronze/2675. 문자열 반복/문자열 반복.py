T = int(input())

for _ in range(T):
    R, S = input().split()
    P = ""
    for c in S:
        P += c * int(R)
    print(P)
