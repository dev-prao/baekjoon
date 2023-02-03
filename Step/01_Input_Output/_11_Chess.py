c_list = [1,1,2,2,2,8] # chess list
p_list = list(map(int, input().split())) # present list
for i in range(6):
    print(c_list[i] - p_list[i], end=' ')

