import sys

# 입력 함수를 sys.stdin.readline으로 설정
input = sys.stdin.readline

n = int(input())
lst = set()

# 한 줄씩 입력을 받아서 집합에 추가
for i in range(n):
    word = input().strip()
    lst.add(word)

# 집합을 정렬한 후 길이순으로 정렬하여 리스트로 변환
lst = sorted(sorted(lst), key=len)

# 리스트의 원소를 한 줄씩 출력
for word in lst:
    print(word)
