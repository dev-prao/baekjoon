# N = int(input())

n = int(input())
n_list = list(map(int, input().split()))
v = int(input())
#1. 정수의 개수 n, 정수 n_list, 찾으려고 하는 정수 v 를 입력 받음



print(n_list.count(v))
# count : python 리스트 내장 메소드 count() 는 매개변수로 입력된 값이 리스트 안에 몇개 있는지 세어 반환