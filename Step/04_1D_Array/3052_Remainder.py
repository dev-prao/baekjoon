# R = []
# for i in range(10):
#     d = int(input())
#     R.append(d % 42)
#
# for i in range(10):
#     for j in range(i+1, 10):
#         if R[i] == R[j]:
#             R.remove(R[j])
#
# print(len(R))

# remainders = set()
#
# for i in range(10):
#     num = int(input())
#     remainders.add(num % 42)
#
# print(len(remainders))

remainders = []
for i in range(10):
    num = int(input())
    remainder = num % 42
    if remainder not in remainders:
        remainders.append(remainder)

print(len(remainders))