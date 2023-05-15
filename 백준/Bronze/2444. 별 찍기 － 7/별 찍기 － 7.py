n = int(input())
for i in range(n):
    print(" "*(n-1-i) + "*"*(2*i+1))
for j in range(n-1,0,-1):
    print(" "*(n-j) + "*"*(2*j-1))
