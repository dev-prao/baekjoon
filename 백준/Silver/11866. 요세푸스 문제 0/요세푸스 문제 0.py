n, k = map(int, input().split())
arr = [i for i in range(1, n + 1)]
ans_arr = []

idx = k - 1  # 시작 인덱스를 K-1로 설정

while arr:
    # 인덱스가 배열의 길이를 초과하는 경우, 인덱스를 배열의 길이로 나눈 나머지로 조정
    if idx >= len(arr):
        idx %= len(arr)

    remove_elem = arr.pop(idx)
    ans_arr.append(remove_elem)

    # 다음 시작 인덱스를 K-1만큼 증가
    idx += k - 1

print("<", end="")
print(", ".join(map(str, ans_arr)), end="")
print(">")
