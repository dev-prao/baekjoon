T = int(input())  # 테스트 케이스 개수 입력 받기

for i in range(T):
    string = input()  # 문자열 입력 받기
    first_char = string[0]  # 첫 글자 추출하기
    last_char = string[-1]  # 마지막 글자 추출하기
    print(first_char + last_char)  # 첫 글자와 마지막 글자 연속 출력하기
