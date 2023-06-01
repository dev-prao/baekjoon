n,a,b = map(int,input().split())
if a < b:
    print("Bus")
elif a > b >= n:
    print("Subway")
else:
    print("Anything")