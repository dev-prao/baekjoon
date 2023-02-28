# for _ in range(10):
#     data = int(input())
#     num = data[0] % 42

remainders = set()

for i in range(10):
    num = int(input())
    remainders.add(num % 42)

print(len(remainders))