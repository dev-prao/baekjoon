import sys

input = sys.stdin.readline
ans = "Valid"
visited = []  # 방문했던 곳을 담을 리스트
for i in range(36):
    if i == 0:  # 마지막값과 체크하기 위하여 따로 빼놓음
        start = input().rstrip()
        prev = start
    elif i < 35:
        now = input().rstrip()
        if ((abs(ord(prev[0]) - ord(now[0])) == 1 and abs(int(prev[1]) - int(now[1])) == 2)
            or (abs(ord(prev[0]) - ord(now[0])) == 2 and abs(int(prev[1]) - int(now[1])) == 1)) \
                and now not in visited:
            pass
        else:
            ans = "Invalid"
        visited.append(now)  # 방문리스트에 삽입
        prev = now
    else:
        now = input().rstrip()
        if ((abs(ord(now[0]) - ord(start[0])) == 1 and abs(int(now[1]) - int(start[1])) == 2)
            or (abs(ord(now[0]) - ord(start[0])) == 2 and abs(int(now[1]) - int(start[1])) == 1)) \
                and now not in visited:
            pass
        else:
            ans = "Invalid"

print(ans)